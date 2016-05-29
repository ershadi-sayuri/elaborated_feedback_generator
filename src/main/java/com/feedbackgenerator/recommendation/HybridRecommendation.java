package com.feedbackgenerator.recommendation;

import com.feedbackgenerator.models.LearningMaterial;
import com.feedbackgenerator.models.UserProfile;
import weka.core.Instances;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 5/25/2016.
 */
public class HybridRecommendation {
    public static ArrayList<LearningMaterial> generateHybridRecommendation(Instances cbfResult, ArrayList<String> cResult
            , UserProfile userProfile) {
        Instances recommendations = new Instances(cbfResult, 100);

        for (int i = 0; i < cbfResult.numInstances(); i++) {
            boolean isDuplicate = false;

            for (String url : cResult) {
                if (url.equals(cbfResult.instance(i).stringValue(0))) {
                    isDuplicate = true;
                }
            }

            if (isDuplicate) {
                recommendations.add(cbfResult.instance(i));
            }

        }

        if (recommendations.numInstances() < 2) {
            for (int i = 0; i < cbfResult.numInstances(); i++) {
                if (cbfResult.instance(i).value(2) == 1.0) {
                    if (userProfile.isVideo()) {
                        recommendations.add(cbfResult.instance(i));
                    }

                } else if (cbfResult.instance(i).value(5) == 1.0) {
                    if (userProfile.isBullets()) {
                        recommendations.add(cbfResult.instance(i));
                    }
                } else if (cbfResult.instance(i).value(15) == 1.0) {
                    if (userProfile.isThinking()) {
                        recommendations.add(cbfResult.instance(i));
                    }
                } else if (cbfResult.instance(i).value(14) == 1.0) {
                    if (userProfile.isPractical()) {
                        recommendations.add(cbfResult.instance(i));
                    }
                } else if (cbfResult.instance(i).value(13) == 1.0) {
                    if (userProfile.isStepsGiven()) {
                        recommendations.add(cbfResult.instance(i));
                    }
                } else if (cbfResult.instance(i).value(12) == 1.0) {
                    if (userProfile.isTheoriesAndMeaning()) {
                        recommendations.add(cbfResult.instance(i));
                    }
                } else if (cbfResult.instance(i).value(11) == 1.0) {
                    if (userProfile.isFactsAndProcedures()) {
                        recommendations.add(cbfResult.instance(i));
                    }
                } else if (cbfResult.instance(i).value(10) == 1.0) {
                    if (userProfile.isFactsAndProcedures()) {
                        recommendations.add(cbfResult.instance(i));
                    }
                } else if (cbfResult.instance(i).value(9) == 1.0) {
                    if (userProfile.isEasy()) {
                        recommendations.add(cbfResult.instance(i));
                    }
                } else if (cbfResult.instance(i).value(8) == 1.0) {
                    if (userProfile.isMedium()) {
                        recommendations.add(cbfResult.instance(i));
                    }
                } else if (cbfResult.instance(i).value(7) == 1.0) {
                    if (userProfile.isAdvanced()) {
                        recommendations.add(cbfResult.instance(i));
                    }
                } else if (cbfResult.instance(i).value(6) == 1.0) {
                    if (userProfile.isExamples()) {
                        recommendations.add(cbfResult.instance(i));
                    }
                } else if (cbfResult.instance(i).value(3) == 1.0) {
                    if (userProfile.isImages()) {
                        recommendations.add(cbfResult.instance(i));
                    }
                } else if (cbfResult.instance(i).value(4) == 1.0) {
                    if (userProfile.isParagraph()) {
                        recommendations.add(cbfResult.instance(i));
                    }
                }
            }
        }

        Double doubleV;
        Double doubleI;
        Integer integerV;
        Integer integerI;

        ArrayList<LearningMaterial> hybridRecommendations = new ArrayList<LearningMaterial>();
        for (int i = 0; i < recommendations.numInstances(); i++) {
            doubleV = recommendations.instance(i).value(2);
            integerV = doubleV.intValue();
            doubleI = recommendations.instance(i).value(3);
            integerI = doubleI.intValue();

            LearningMaterial learningMaterial = new LearningMaterial(recommendations.instance(i).stringValue(0),
                    recommendations.instance(i).stringValue(1), integerV, integerI,
                    Boolean.parseBoolean(recommendations.instance(i).stringValue(4)),
                    Boolean.parseBoolean(recommendations.instance(i).stringValue(5)),
                    Boolean.parseBoolean(recommendations.instance(i).stringValue(6)),
                    Boolean.parseBoolean(recommendations.instance(i).stringValue(7)),
                    Boolean.parseBoolean(recommendations.instance(i).stringValue(8)),
                    Boolean.parseBoolean(recommendations.instance(i).stringValue(9)),
                    recommendations.instance(i).stringValue(10),
                    Boolean.parseBoolean(recommendations.instance(i).stringValue(11)),
                    Boolean.parseBoolean(recommendations.instance(i).stringValue(12)),
                    Boolean.parseBoolean(recommendations.instance(i).stringValue(13)),
                    Boolean.parseBoolean(recommendations.instance(i).stringValue(14)),
                    Boolean.parseBoolean(recommendations.instance(i).stringValue(15)),
                    recommendations.instance(i).value(16));

            hybridRecommendations.add(learningMaterial);
        }

//        ArrayList<LearningMaterial> newRec = new ArrayList<LearningMaterial>();
//        if(hybridRecommendations.size()>13){
//            newRec = hybridRecommendations.re
//        }

        return hybridRecommendations;
    }
}
