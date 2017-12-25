package thinkinjava.generics.watercolors;

import java.util.EnumSet;
import java.util.Set;

import static thinkinjava.generics.Sets.complement;
import static thinkinjava.generics.Sets.difference;
import static thinkinjava.generics.Sets.intersection;
import static thinkinjava.generics.Sets.union;
import static thinkinjava.generics.watercolors.Watercolors.BRILLIANT_RED;
import static thinkinjava.generics.watercolors.Watercolors.BURNT_UMBER;
import static thinkinjava.generics.watercolors.Watercolors.CERULEAN_BLUE_HUE;
import static thinkinjava.generics.watercolors.Watercolors.VIRIDIAN_HUE;

public class WatercolorSets {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("union(set1, set2): " + union(set1, set2));
        System.out.println("intersection(set1, set2): " + intersection(set1, set2));
        System.out.println("difference(set1, set2): " + difference(set1, set2));
        System.out.println("complement(set1, set2): " + complement(set1, set2));
    }
}
