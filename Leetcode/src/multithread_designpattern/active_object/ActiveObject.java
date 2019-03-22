package multithread_designpattern.active_object;

public interface ActiveObject {
    Result<String> makeString(int count, char filechar);

    void displayString(String string);
}
