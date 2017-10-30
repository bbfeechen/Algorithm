package designpattern.singleton;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start.");
        Singleton ob1 = Singleton.getInstance();
        Singleton ob2 = Singleton.getInstance();
        if (ob1 == ob2) {
            System.out.println("ob1 and ob2 are the same.");
        } else {
            System.out.println("ob1 and ob2 are different");
        }
        System.out.println("End.");
    }
}
