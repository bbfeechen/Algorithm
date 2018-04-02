package thinkinjava.concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CloseResource {

    public static void main(String[] args) {
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            ServerSocket server = new ServerSocket(8080);
            InputStream socketInput = new Socket("localhost", 8080).getInputStream();
            exec.execute(new IOBlocked(socketInput));
            exec.execute(new IOBlocked(System.in));
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("Shutting down all threads");
            exec.shutdownNow();
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Closing " + socketInput.getClass().getName());
            socketInput.close();
            TimeUnit.SECONDS.sleep(1);
            System.in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
