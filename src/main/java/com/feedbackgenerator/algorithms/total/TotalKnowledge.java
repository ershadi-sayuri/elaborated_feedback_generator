package com.feedbackgenerator.algorithms.total;

import com.feedbackgenerator.algorithms.interactiondata.Interaction;
import com.feedbackgenerator.algorithms.knowledge.allround.ARDifficultyOrTopicKnowledge;
import com.feedbackgenerator.algorithms.knowledge.allround.ARDifficultyTopicKnowledge;
import com.feedbackgenerator.algorithms.knowledge.allround.ARQuestionKnowledge;
import com.feedbackgenerator.algorithms.knowledge.quizwise.QWDifficultyOrTopicKnowledge;
import com.feedbackgenerator.algorithms.knowledge.quizwise.QWDifficultyTopicKnowledge;
import com.feedbackgenerator.algorithms.knowledge.quizwise.QWOverallQuizKnowledge;
import com.feedbackgenerator.algorithms.learningstyle.LearningStyle;
import com.feedbackgenerator.learningmaterial.InitialLearningMaterialRecommender;
import com.feedbackgenerator.models.Knowledge;
import com.feedbackgenerator.models.QuizSlot;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 3/4/2016.
 */
public class TotalKnowledge {
    /**
     * remove duplicates
     * @param titlesWithDuplicates
     * @return titles
     */
    public static ArrayList<String> removeDuplicateNames(ArrayList<String> titlesWithDuplicates) {
        ArrayList<String> titles = new ArrayList<String>();

        for (String title : titlesWithDuplicates) {
            String[] newTitle = title.split(",");
            if (!titles.contains(newTitle[0])) {
                titles.add(newTitle[0]);
            }
        }

        return titles;
    }

    /**
     * calculate total knowledge to recommend learning materials
     * @param userId
     * @param quizId
     * @param setRec
     * @return knowledges
     * @throws Exception
     */
    public ArrayList<Knowledge> calculateUserTotalKnowledge(int userId, int quizId, boolean setRec) throws Exception {
        //  find learning style models
        ArrayList<Integer> learningStyleModels = LearningStyle.findLearningStyleModel(userId);
        // end find learning style models

        // find user knowledge related data
        double arQuizAttemptProgress = ARQuestionKnowledge.findQuizAttemptProgress(userId);
        double arQuizGrade = ARQuestionKnowledge.findQuizGrade(userId);

        double qwQuizGrade = QWOverallQuizKnowledge.findAverageGrade(userId, quizId);
        double qwQuizAttemptProgress = QWOverallQuizKnowledge.findQuizGradingProgress(userId, quizId);

        double arAdvancedQuestionGrade = ARDifficultyOrTopicKnowledge.findTopicOrDifficultyGrade(userId, "advanced");
        double arAdvancedQuestionProgress = ARDifficultyOrTopicKnowledge.findTopicOrDifficultyProgress(userId,
                "advanced");
        double arAdvancedGrade = (arAdvancedQuestionGrade + arAdvancedQuestionProgress) / 2;

        double arEasyQuestionGrade = ARDifficultyOrTopicKnowledge.findTopicOrDifficultyGrade(userId, "easy");
        double arEasyQuestionProgress = ARDifficultyOrTopicKnowledge.findTopicOrDifficultyProgress(userId, "easy");
        double arEasyGrade = (arEasyQuestionGrade + arEasyQuestionProgress) / 2;

        double qwAdvancedQuestionGrade = QWDifficultyOrTopicKnowledge.findTopicOrDifficultyGrade(userId, quizId,
                "advanced");
        double qwAdvancedQuestionProgress = QWDifficultyOrTopicKnowledge.findTopicOrDifficultyProgress(userId, quizId,
                "advanced");
        double qwAdvancedGrade = (qwAdvancedQuestionGrade + qwAdvancedQuestionProgress) / 2;

        double qwEasyQuestionGrade = QWDifficultyOrTopicKnowledge.findTopicOrDifficultyGrade(userId, quizId, "easy");
        double qwEasyQuestionProgress = QWDifficultyOrTopicKnowledge.findTopicOrDifficultyProgress(userId, quizId,
                "easy");
        double qwEasyGrade = (qwEasyQuestionGrade + qwEasyQuestionProgress) / 2;

        QuizSlot quizSlot = new QuizSlot();
        ArrayList<String> arNamesOfQuestionsWithDuplicates = quizSlot.getDifferentNamesOfQuestions();
        ArrayList<String> arDifferentNamesOfQuestions = removeDuplicateNames(arNamesOfQuestionsWithDuplicates);

        ArrayList<String> qwNamesOfQuestionsWithDuplicates = quizSlot.getDifferentNamesOfQuestionsByQuiz(quizId);
        ArrayList<String> qwDifferentNamesOfQuestions = removeDuplicateNames(qwNamesOfQuestionsWithDuplicates);

        double overAllAttemptAverage = Interaction.findARNumberOfAttempts(userId);
        double quizWiseAttemptAverage = Interaction.findQWNumberOfAttempts(userId, quizId);

        double arAverageDifficultyOrTopicGrade = 0;
        double arDifficultyOrTopicProgress = 0;
        double arAdvancedTopicGrade = 0;
        double arAdvancedTopicProgress = 0;
        double arEasyTopicGrade = 0;
        double arEasyTopicProgress = 0;
        double arTopicKnowledge = 0;
        double arAdvanceTopicKnowledge = 0;
        double arEasyTopicKnowledge = 0;
        double arKnowledge = 0;

        double qwAverageDifficultyOrTopicGrade = 0;
        double qwDifficultyOrTopicProgress = 0;
        double qwAdvancedTopicGrade = 0;
        double qwAdvancedTopicProgress = 0;
        double qwEasyTopicGrade = 0;
        double qwEasyTopicProgress = 0;
        double qwTopicKnowledge = 0;
        double qwAdvanceTopicKnowledge = 0;
        double qwEasyTopicKnowledge = 0;
        double qwKnowledge = 0;

        long timeSpentViewingMaterial = 0;

        ArrayList<Knowledge> knowledges = new ArrayList<Knowledge>();

        for (int i = 0; i < arDifferentNamesOfQuestions.size(); i++) {
            /**
             * all round knowledge
             */

            // topic
            arAverageDifficultyOrTopicGrade += ARDifficultyOrTopicKnowledge.findTopicOrDifficultyGrade(userId,
                    arDifferentNamesOfQuestions.get(i));
            arDifficultyOrTopicProgress += ARDifficultyOrTopicKnowledge.findTopicOrDifficultyProgress(userId,
                    arDifferentNamesOfQuestions.get(i));

            //difficulty topic
            arAdvancedTopicGrade = ARDifficultyTopicKnowledge.findTopicDifficultyGrade(userId,
                    arDifferentNamesOfQuestions.get(i), "advanced");
            arAdvancedTopicProgress = ARDifficultyTopicKnowledge.findTopicDifficultyProgress(userId,
                    arDifferentNamesOfQuestions.get(i), "advanced");
            arEasyTopicGrade = ARDifficultyTopicKnowledge.findTopicDifficultyGrade(userId,
                    arDifferentNamesOfQuestions.get(i), "easy");
            arEasyTopicProgress = ARDifficultyTopicKnowledge.findTopicDifficultyProgress(userId,
                    arDifferentNamesOfQuestions.get(i), "easy");

            arTopicKnowledge = (arAdvancedTopicGrade + arAdvancedTopicProgress + arEasyTopicGrade + arEasyTopicProgress)
                    / 4;

            arAdvanceTopicKnowledge = (arAdvancedTopicGrade + arAdvancedTopicProgress) / 2;
            arEasyTopicKnowledge = (arEasyTopicGrade + arEasyTopicProgress) / 2;

            arKnowledge = (arQuizAttemptProgress + arQuizGrade + arAdvancedQuestionGrade + arAdvancedQuestionProgress +
                    arEasyQuestionGrade + arEasyQuestionProgress + arAverageDifficultyOrTopicGrade +
                    arDifficultyOrTopicProgress + arTopicKnowledge) / 9;

            // time spent reading materials
            timeSpentViewingMaterial = Interaction.calculateTimSpentViewingMaterial(arDifferentNamesOfQuestions.get(i));

            /**
             * quiz wise knowledge
             */

            if (qwDifferentNamesOfQuestions.contains(arDifferentNamesOfQuestions.get(i))) {
                qwAverageDifficultyOrTopicGrade += QWDifficultyOrTopicKnowledge.findTopicOrDifficultyGrade(userId,
                        quizId, arDifferentNamesOfQuestions.get(i));
                qwDifficultyOrTopicProgress += QWDifficultyOrTopicKnowledge.findTopicOrDifficultyProgress(userId,
                        quizId, arDifferentNamesOfQuestions.get(i));

                qwAdvancedTopicGrade = QWDifficultyTopicKnowledge.findTopicDifficultyGrade(userId, quizId,
                        arDifferentNamesOfQuestions.get(i), "advanced");
                qwAdvancedTopicProgress = QWDifficultyTopicKnowledge.findTopicDifficultyProgress(userId, quizId,
                        arDifferentNamesOfQuestions.get(i), "advanced");
                qwEasyTopicGrade = QWDifficultyTopicKnowledge.findTopicDifficultyGrade(userId, quizId,
                        arDifferentNamesOfQuestions.get(i), "easy");
                qwEasyTopicProgress = QWDifficultyTopicKnowledge.findTopicDifficultyProgress(userId, quizId,
                        arDifferentNamesOfQuestions.get(i), "easy");

                qwTopicKnowledge = (qwAdvancedTopicGrade + qwAdvancedTopicProgress + qwEasyTopicGrade + qwEasyTopicProgress)
                        / 4;

                qwAdvanceTopicKnowledge = (qwAdvancedTopicGrade + qwAdvancedTopicProgress) / 2;
                qwEasyTopicKnowledge = (qwEasyTopicGrade + qwEasyTopicProgress) / 2;

                qwKnowledge = (qwQuizAttemptProgress + qwQuizGrade + qwAdvancedQuestionGrade +
                        qwAdvancedQuestionProgress + qwEasyQuestionGrade + qwEasyQuestionProgress +
                        qwAverageDifficultyOrTopicGrade + qwDifficultyOrTopicProgress + qwTopicKnowledge) / 9;
            }

            Knowledge knowledge = new Knowledge();
            knowledge.setTopic(arDifferentNamesOfQuestions.get(i));
            knowledge.setTopicKnowledge((arTopicKnowledge + qwTopicKnowledge) / 2);
            knowledge.setOverAllTopicKnowledge(arTopicKnowledge);
            knowledge.setQuizWiseTopicKnowledge(qwTopicKnowledge);
            knowledge.setAdvanceTopicKnowledge((arAdvanceTopicKnowledge + qwAdvanceTopicKnowledge) / 2);
            knowledge.setOverAllAdvanceTopicKnowledge(arAdvanceTopicKnowledge);
            knowledge.setQuizWiseAdvanceTopicKnowledge(qwAdvanceTopicKnowledge);
            knowledge.setEasyTopicKnowledge((arEasyTopicKnowledge + qwEasyTopicKnowledge) / 2);
            knowledge.setOverAllEasyTopicKnowledge(arEasyTopicKnowledge);
            knowledge.setQuizWiseEasyTopicKnowledge(qwEasyTopicKnowledge);
            knowledge.setKnowledge((arKnowledge + qwKnowledge) / 2);
            knowledge.setOverAllKnowledge(arKnowledge);
            knowledge.setQuizWiseKnowledge(qwKnowledge);
            knowledge.setAdvancedKnowledge((arAdvancedGrade + qwAdvancedGrade) / 2);
            knowledge.setOverAllAdvancedKnowledge(arAdvancedGrade);
            knowledge.setQuizWiseAdvancedKnowledge(qwAdvancedGrade);
            knowledge.setEasyKnowledge((arEasyGrade + qwEasyGrade) / 2);
            knowledge.setOverAllEasyKnowledge(arEasyGrade);
            knowledge.setQuizWiseEasyKnowledge(qwEasyGrade);

            knowledge.setTimeSpentViewingMaterial(timeSpentViewingMaterial);
            knowledge.setOverAllAttemptAverage(overAllAttemptAverage);
            knowledge.setQuizWiseAttemptAverage(quizWiseAttemptAverage);

            knowledge.setActiveOrReflective(learningStyleModels.get(0));
            knowledge.setSensoryOrIntuitive(learningStyleModels.get(1));
            knowledge.setVisualOrVerbal(learningStyleModels.get(2));
            knowledge.setSequentialOrGlobal(learningStyleModels.get(3));

            if (setRec == true) {
                knowledge.setRecommendation(InitialLearningMaterialRecommender.filterRecommendationsByTopic(knowledge).getRecommendation());
            } else {
                knowledge.setRecommendation("?");
            }


            knowledges.add(knowledge);
        }

        return knowledges;
    }
}
