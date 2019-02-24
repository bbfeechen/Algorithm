package designpattern.observer.pub_sub;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

public class MyTopic implements Subject {

    private List<Observer> observers;
    private String message;
    private boolean needNotified = false;
    private final Object lock = new Object();

    public MyTopic() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(@NonNull Observer observer) {
        synchronized (lock) {
            if (!observers.contains(observer)) {
                observers.add(observer);
            }
        }
    }

    @Override
    public void unregister(@NonNull Observer observer) {
        synchronized (lock) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;
        synchronized (lock) {
            if (needNotified) {
                observersLocal = observers;
                needNotified = false;
            }
        }
        if (observersLocal == null) {
            return;
        }
        for (Observer observer : observersLocal) {
            observer.update();
        }
    }

    @Override
    public Object getUpdate(@NonNull Observer observer) {
        return message;
    }

    public void postMessage(String message) {
        this.message = message;
        this.needNotified = true;
        notifyObservers();
    }
}
