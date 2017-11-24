package designpattern.memento;

import designpattern.memento.game.Gamer;
import designpattern.memento.game.Memento;

public class Main {

    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();
        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);
            System.out.println("Current: " + gamer);
            gamer.bet();
            System.out.println("Now Money is " + gamer.getMoney());
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("money increased, so save state");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("money decreased, so restore state");
                gamer.restoreMemento(memento);
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("");
    }
}
