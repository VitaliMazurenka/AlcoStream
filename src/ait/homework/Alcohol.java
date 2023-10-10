package ait.homework;

public class Alcohol {
    private String title;
    private double strength;
    private double price;

    public Alcohol(String title, double strength, double price) {
        this.title = title;
        this.strength = strength;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Alcohol{" +
                "title='" + title + '\'' +
                ", strength=" + strength +
                ", price=" + price +
                '}';
    }
}
