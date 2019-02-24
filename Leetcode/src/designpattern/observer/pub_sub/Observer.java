package designpattern.observer.pub_sub;

public interface Observer {
    void update();

    void setSubject(Subject subject);
}
