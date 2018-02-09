package pe.luisvertiz.peruraymi.data.entity;

/**
 * Created by Luis on 16/12/2017.
 */

public class Place {
    private int idImage;
    private String name;
    private String adress;
    private int stars;

    public Place(int idImage, String name, String adress, int stars) {
        this.idImage = idImage;
        this.name = name;
        this.adress = adress;
        this.stars = stars;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
