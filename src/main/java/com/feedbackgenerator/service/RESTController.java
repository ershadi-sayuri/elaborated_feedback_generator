package com.feedbackgenerator.service;

import com.feedbackgenerator.algorithms.total.TotalKnowledge;
import com.feedbackgenerator.filehandling.CSVFileWriter;
import com.feedbackgenerator.models.*;
import com.feedbackgenerator.other.UserProfiling;
import com.feedbackgenerator.recommendation.CBRecommendation;
import com.feedbackgenerator.recommendation.CollaborativeFilter;
import com.feedbackgenerator.recommendation.ContentBasedFilter;
import com.feedbackgenerator.recommendation.HybridRecommendation;
import com.google.gson.Gson;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import weka.core.Instances;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


/**
 * Created by Ershadi on 5/7/2016.
 */
@Path("/controller")
public class RESTController {
    static {
        BasicConfigurator.configure();
    }

    private Logger logger = Logger.getLogger("RESTController");

    @POST
    @Path("/test")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMessage(String url) {
        return Response.status(200).entity("tess").build();
    }

    @POST
    @Path("/generateFeedback")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Response generateFeedback(InputData input) {
        int userId = input.getUserId();
        int quizId = input.getQuizId();

        TotalKnowledge totalKnowledge = new TotalKnowledge();
        CSVFileWriter csvFileWriter = new CSVFileWriter();
        CollaborativeFilter collaborativeFilter = new CollaborativeFilter();
        ContentBasedFilter contentBasedFilter = new ContentBasedFilter();

        CBRecommendation cbRecommendation = new CBRecommendation();

        Feedback feedback = new Feedback();

        ArrayList<Knowledge> knowledgesToFindHR = null;
        JSONObject responceJson = new JSONObject();

        try {
            // hybrid recommendation

            knowledgesToFindHR = totalKnowledge.calculateUserTotalKnowledge(userId, quizId, true);
            ArrayList<UserProfile> hUserProfiles = UserProfiling.createUserProfile(userId, knowledgesToFindHR);
            csvFileWriter.writeUserProfileData("testProfile.csv", hUserProfiles);
            // generate recommendations with content based
            contentBasedFilter.filterContentBased("trainProfile.csv", "testProfile.csv", "trainCData.csv",
                    "testCData.csv", userId);
            Instances cbRecommendations = cbRecommendation.recommendCBLM("trainCData.csv", userId);

            // collaborative
            csvFileWriter.writeKnowledgeData("testData.csv", knowledgesToFindHR, true);
            ArrayList<String> cRecommendations = collaborativeFilter.filterCollaborative("trainData.csv",
                    "testData.csv", 1);
            ArrayList<LearningMaterial> learningMaterials = HybridRecommendation.generateHybridRecommendation
                    (cbRecommendations, cRecommendations, hUserProfiles.get(0));
            Gson gson = new Gson();
            String learninMaterialsSJSONStr = gson.toJson(learningMaterials);



            UserModel userModel = new UserModel(hUserProfiles.get(0).getUserId(), hUserProfiles.get(0).isVideo(),
                    hUserProfiles.get(0).isImages(), hUserProfiles.get(0).isParagraph(), hUserProfiles.get(0).isBullets(),
                    hUserProfiles.get(0).isExamples(), hUserProfiles.get(0).isFactsAndProcedures(),
                    hUserProfiles.get(0).isTheoriesAndMeaning(), hUserProfiles.get(0).isStepsGiven(),
                    hUserProfiles.get(0).isPractical(), hUserProfiles.get(0).isThinking());
            String userProfileJSONStr = gson.toJson(userModel);
            JSONArray learninMaterialsJSON = new JSONArray(learninMaterialsSJSONStr);
            JSONObject userProfilesJSON = new JSONObject(userProfileJSONStr);

            User user = new User();
            user = user.getUserData(userId);

            feedback.setDescription("Hello " + user.getFirstName() + ", following are the recommended learning materials for you");
            feedback.setLearningMaterials(learningMaterials);

            responceJson.put("description", "Hello " + user.getFirstName() + ", " +
                    "following are the recommended learning materials for you");
            responceJson.put("learning_material", learninMaterialsJSON);
            responceJson.put("user_profile", userProfilesJSON);

        } catch (Exception e) {
            e.printStackTrace();
//            return Response.status(500).entity("Error occurred. Please try again with correct data").build();
        }

        return Response.status(200).entity(responceJson.toString()).build();
    }


}
