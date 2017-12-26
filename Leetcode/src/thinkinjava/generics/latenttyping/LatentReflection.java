package thinkinjava.generics.latenttyping;

import java.lang.reflect.Method;

class Mime {
    public void walkAgainstTheWind() {}
    public void sit() {
        System.out.println("Pretending to sit");
    }
    public void pushInvisibleWalls() {}
    public String toString() {
        return "Mime";
    }
}

class SmartDog {
    public void speak() {
        System.out.println("Woof!");
    }
    public void sit() {
        System.out.println("Sitting");
    }
    public void reproduce() {}
}

class CommunicateReflectively {
    public static void perform(Object speaker) {
        try {
            Class<?> spkr = speaker.getClass();
            try {
                Method speak = spkr.getMethod("speak");
                speak.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker + " cannot speak");
            }
            try {
                Method sit = spkr.getMethod("sit");
                sit.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker + " cannot sit");
            }
        } catch (Exception e) {
            throw new RuntimeException(speaker.toString(), e);
        }
    }
}

public class LatentReflection {

    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Robot());
        CommunicateReflectively.perform(new Mime());
    }
}
