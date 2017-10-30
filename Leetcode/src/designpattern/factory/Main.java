package designpattern.factory;

public class Main {

    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("First Name");
        Product card2 = factory.create("Middle Name");
        Product card3 = factory.create("Last Name");
        card1.use();
        card2.use();
        card3.use();
    }
}
