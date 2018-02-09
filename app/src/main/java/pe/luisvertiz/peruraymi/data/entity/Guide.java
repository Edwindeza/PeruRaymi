package pe.luisvertiz.peruraymi.data.entity;

/**
 * Created by Luis on 16/12/2017.
 */

public class Guide {
    private int idImage;
    private String title;
    private String theme;
    private String description;

    public Guide(int idImage, String title, String theme, String description) {
        this.idImage = idImage;
        this.title = title;
        this.theme = theme;
        this.description = description;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
