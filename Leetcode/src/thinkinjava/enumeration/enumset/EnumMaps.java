package thinkinjava.enumeration.enumset;

import java.util.EnumMap;
import java.util.Map;

import static thinkinjava.enumeration.enumset.AlarmPoints.BATHROOM;
import static thinkinjava.enumeration.enumset.AlarmPoints.KITCHEN;
import static thinkinjava.enumeration.enumset.AlarmPoints.UTILITY;

interface Command {
    void action();
}

public class EnumMaps {

    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);
        em.put(KITCHEN, new Command() {
            @Override
            public void action() {
                System.out.println("Kitchen fire!");
            }
        });
        em.put(BATHROOM, new Command() {
            @Override
            public void action() {
                System.out.println("Bathroom alert!");
            }
        });
        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            System.out.print(e.getKey() + ": ");
            e.getValue().action();
        }
        try {
            em.get(UTILITY).action();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
