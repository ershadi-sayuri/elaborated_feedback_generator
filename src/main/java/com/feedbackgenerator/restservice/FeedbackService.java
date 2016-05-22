package com.feedbackgenerator.restservice;

import com.feedbackgenerator.feedback.FeedbackGenerator;
import com.feedbackgenerator.models.Feedback;
import com.feedbackgenerator.models.InputData;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by Ershadi Sayuri on 4/16/2016.
 */
@Path("/Controller")
public class FeedbackService {
    @POST
    @Path("/generateFeedback")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON })
    public Feedback generateFeedback(InputData input) {
        int userId = input.getUserId();
        int quizId = input.getUserId();

        FeedbackGenerator feedbackGenerator = new FeedbackGenerator();
        Feedback feedback = feedbackGenerator.generateFeedback(userId, quizId);

        ObjectMapper objectMapper = new ObjectMapper();
        return feedback;
//        try {
////            Object json = objectMapper.readValue(objectMapper.writeValueAsString(feedback),
////                    Object.class);
////            return Response.status(200).entity(json).build();
//        } catch (IOException e) {
//            return Response.status(500).entity("Feedback is empty").build();
//        }
    }
}
