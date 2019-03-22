package multithread_designpattern.active_object;

public class Servant implements ActiveObject {

    @Override
    public Result<String> makeString(int count, char filechar) {
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = filechar;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
        return new RealResult<>(new String(buffer));
    }

    @Override
    public void displayString(String string) {
        try {
            System.out.println("displayString: " + string);
            Thread.sleep(10);
        } catch (Exception e) {

        }
    }
}
