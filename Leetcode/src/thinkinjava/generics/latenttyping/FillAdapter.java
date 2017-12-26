package thinkinjava.generics.latenttyping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import thinkinjava.generics.Generator;
import thinkinjava.generics.coffee.Coffee;
import thinkinjava.generics.coffee.Latte;
import thinkinjava.generics.coffee.Mocha;

interface Addable<T> {
    void add(T t);
}

public class FillAdapter {
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++) {
            try {
                addable.add(classToken.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }
}

class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }

    @Override
    public void add(T item) {
        c.add(item);
    }
}

class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<>(c);
    }
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    public void add(T item) {
        super.add(item);
    }
}

class FillAdapterTest {

    public static void main(String[] args) {
        List<Coffee> carrier = new ArrayList<>();
        FillAdapter.fill(new AddableCollectionAdapter<>(carrier), Coffee.class, 3);
        FillAdapter.fill(Adapter.collectionAdapter(carrier), Latte.class, 2);
        for (Coffee c : carrier) {
            System.out.println(c);
        }
        System.out.println("-------");
        AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<>();
        FillAdapter.fill(coffeeQueue, Mocha.class, 4);
        FillAdapter.fill(coffeeQueue, Latte.class, 1);
        for (Coffee c : coffeeQueue) {
            System.out.println(c);
        }
    }
}
