package feedbackgenerator.models;

/**
 * Created by Ershadi Sayuri on 3/5/2016.
 */
public class Title {
    private String title;
    private boolean duplicability;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDuplicability() {
        return duplicability;
    }

    public void setDuplicability(boolean duplicability) {
        this.duplicability = duplicability;
    }
}
