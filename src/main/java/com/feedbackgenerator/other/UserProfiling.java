package com.feedbackgenerator.other;

import com.feedbackgenerator.models.Knowledge;
import com.feedbackgenerator.models.UserProfile;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 4/23/2016.
 */
public class UserProfiling {
    public static ArrayList<UserProfile> createUserProfile(int userId, ArrayList<Knowledge> knowledges) {

        ArrayList<UserProfile> usersProfiles = new ArrayList<UserProfile>();

        for (Knowledge knowledge : knowledges) {

            UserProfile userProfile = new UserProfile();
            userProfile.setUserId(userId);

            if (knowledge.getVisualOrVerbal() > 0) {
                userProfile.setVideo(true);
                userProfile.setImages(false);
            } else {
                userProfile.setVideo(false);
                userProfile.setImages(true);
            }

            if (knowledge.getSensoryOrIntuitive() > 0) {
                userProfile.setParagraph(true);
                userProfile.setBullets(false);
            } else {
                userProfile.setParagraph(false);
                userProfile.setBullets(true);
            }

            if (knowledge.getActiveOrReflective() > 0) {
                userProfile.setExamples(false);
            } else {
                userProfile.setExamples(true);
            }

            if (knowledge.getSensoryOrIntuitive() > 0) {
                userProfile.setFactsAndProcedures(false);
                userProfile.setTheoriesAndMeaning(true);
            } else {
                userProfile.setFactsAndProcedures(true);
                userProfile.setTheoriesAndMeaning(false);
            }

            if (knowledge.getSequentialOrGlobal() > 0) {
                userProfile.setStepsGiven(false);
            } else {
                userProfile.setStepsGiven(true);
            }

            if (knowledge.getActiveOrReflective() > 0) {
                userProfile.setPractical(false);
                userProfile.setThinking(true);
            } else {
                userProfile.setPractical(true);
                userProfile.setThinking(false);
            }

            userProfile.setTopic(knowledge.getTopic());

            if (knowledge.getAdvanceTopicKnowledge() > 0.5 && knowledge.getEasyTopicKnowledge() > 0.5) {
                userProfile.setAdvanced(true);
                userProfile.setMedium(false);
                userProfile.setEasy(false);
            } else if (knowledge.getAdvanceTopicKnowledge() < 0.5 && knowledge.getEasyTopicKnowledge() > 0.5) {
                userProfile.setAdvanced(true);
                userProfile.setMedium(true);
                userProfile.setEasy(false);
            } else if (knowledge.getAdvanceTopicKnowledge() > 0.5 && knowledge.getEasyTopicKnowledge() < 0.5) {
                userProfile.setAdvanced(true);
                userProfile.setMedium(true);
                userProfile.setEasy(true);
            } else {
                userProfile.setAdvanced(true);
                userProfile.setMedium(true);
                userProfile.setEasy(true);
            }

            usersProfiles.add(userProfile);
        }

        return usersProfiles;
    }
}
