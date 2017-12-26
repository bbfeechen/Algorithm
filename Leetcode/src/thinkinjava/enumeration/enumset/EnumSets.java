package thinkinjava.enumeration.enumset;

import java.util.EnumSet;

import static thinkinjava.enumeration.enumset.AlarmPoints.BATHROOM;
import static thinkinjava.enumeration.enumset.AlarmPoints.KITCHEN;
import static thinkinjava.enumeration.enumset.AlarmPoints.OFFICE1;
import static thinkinjava.enumeration.enumset.AlarmPoints.OFFICE4;
import static thinkinjava.enumeration.enumset.AlarmPoints.STAIR1;
import static thinkinjava.enumeration.enumset.AlarmPoints.STAIR2;

public class EnumSets {

    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(BATHROOM);
        System.out.println(points);
        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);
        points = EnumSet.allOf(AlarmPoints.class);
        System.out.println(points);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);
        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        System.out.println(points);
    }
}
