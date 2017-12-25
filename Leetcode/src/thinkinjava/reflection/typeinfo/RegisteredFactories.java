package thinkinjava.reflection.typeinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import thinkinjava.reflection.typeinfo.factory.Factory;

class Part {
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Factory<? extends Part>> partFactories = new ArrayList<>();
    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }

    private static Random rand = new Random(47);
    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}

class Filter extends Part {}

class FuelFilter extends Filter {
    public static class Factory implements thinkinjava.reflection.typeinfo.factory.Factory {
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Factory implements thinkinjava.reflection.typeinfo.factory.Factory {
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinFilter extends Filter {
    public static class Factory implements thinkinjava.reflection.typeinfo.factory.Factory {
        @Override
        public CabinFilter create() {
            return new CabinFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class Factory implements thinkinjava.reflection.typeinfo.factory.Factory {
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {}

class FanBelt extends Belt {
    public static class Factory implements thinkinjava.reflection.typeinfo.factory.Factory {
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements thinkinjava.reflection.typeinfo.factory.Factory {
        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class Factory implements thinkinjava.reflection.typeinfo.factory.Factory {
        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

public class RegisteredFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
}
