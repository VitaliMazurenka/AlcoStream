package ait.homework;

import java.util.Objects;

public class Alcohol implements Comparable<Alcohol>{
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

        @Override
        public int compareTo(Alcohol o) {
            return Double.compare(this.price,o.price);
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alcohol alcohol = (Alcohol) o;

        if (Double.compare(alcohol.strength, strength) != 0) return false;
        if (Double.compare(alcohol.price, price) != 0) return false;
        return Objects.equals(title, alcohol.title);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title != null ? title.hashCode() : 0;
        temp = Double.doubleToLongBits(strength);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

