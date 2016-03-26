package comtest.feedbackgeneratortest.controllerstest.algorithmstest.usertest.knowledgetest.gradetest;

import com.feedbackgenerator.algorithms.knowledge.grade.Grade;
import com.feedbackgenerator.models.QuizSlot;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Ershadi Sayuri on 3/4/2016.
 */
public class GradeTest {

    @Test
    public void testFindQuizGrade() throws Exception {
        Grade grade = new Grade();
        QuizSlot quizSlot = new QuizSlot();
        ArrayList<Integer> questionIds = quizSlot.getNameWiseQuestionIdsOfAQuiz(2, "easy");
        double quizGrade = grade.findQuizGrade(questionIds, 4);
        System.out.println(quizGrade);
    }
}