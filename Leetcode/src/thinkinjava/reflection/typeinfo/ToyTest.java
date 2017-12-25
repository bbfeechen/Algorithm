package thinkinjava.reflection.typeinfo;

interface HasBatteries {}
interface WaterProof {}
interface Shoots {}

class Toy {
    public Toy() {}
    public Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, WaterProof, Shoots {
    public FancyToy() {
        super(1);
    }
}

public class ToyTest {

    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("thinkinjava.reflection.typeinfo.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot Access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
