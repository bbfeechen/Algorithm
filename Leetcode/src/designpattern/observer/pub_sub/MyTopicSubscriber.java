package designpattern.observer.pub_sub;

public class MyTopicSubscriber implements Observer {
    private String name;
    private Subject subject;

    public MyTopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String message = (String) subject.getUpdate(this);
        System.out.println("name = " + name + " "
                + (message == null ? "has no message" : "consumed message = " + message));
    }

    @Override
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
