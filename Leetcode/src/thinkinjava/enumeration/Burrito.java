package thinkinjava.enumeration;

import static thinkinjava.enumeration.Spiciness.HOT;
import static thinkinjava.enumeration.Spiciness.MEDIUM;
import static thinkinjava.enumeration.Spiciness.NOT;

public class Burrito {
    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito is " + degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
    }
}
