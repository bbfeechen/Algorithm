package thinkinjava.generics.coffee;

import java.util.Iterator;
import java.util.Random;

import thinkinjava.generics.Generator;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = { Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class };
    private Random rand = new Random(47);
    private int size = 0;

    public CoffeeGenerator() {}

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
    }

    public static void main(String[] args) {
        CoffeeGenerator generator = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }
        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
        }
    }
}
