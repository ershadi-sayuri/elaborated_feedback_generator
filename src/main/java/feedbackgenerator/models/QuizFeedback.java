package feedbackgenerator.models;

/**
 * Created by Ershadi Sayuri on 2/12/2016.
 */
public class QuizFeedback {
    private int quizId;
    private double minGrade;
    private double maxGrade;

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public double getMinGrade() {
        return minGrade;
    }

    public void setMinGrade(double minGrade) {
        this.minGrade = minGrade;
    }

    public double getMaxGrade() {
        return maxGrade;
    }

    public void setMaxGrade(double maxGrade) {
        this.maxGrade = maxGrade;
    }

    public void getQuizFeedbackData(){

    }
}
