package thinkinjava.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}

public class CoveriantArrays {

    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        try {
            fruits[0] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            fruits[0] = new Orange();
        } catch (Exception e) {
            System.out.println(e);
        }

//        List<Fruit> flist = new ArrayList<Apple>();
        List<? extends Fruit> flist = new ArrayList<Apple>();
//        flist.add(new Apple());
        flist.add(null);
        Fruit f = flist.get(0);

        List<? extends Fruit> flist2 = new ArrayList<Apple>();
        Apple a = (Apple) flist.get(0);
        System.out.println(flist2.contains(new Apple()));
        System.out.println(flist2.indexOf(new Apple()));
    }
}
