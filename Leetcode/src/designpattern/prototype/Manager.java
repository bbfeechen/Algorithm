package designpattern.prototype;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map showcase = new HashMap();
    public void register(String name, Product proto) {
        showcase.put(name, proto);
    }

    public Product create(String proto) {
        Product p = (Product) showcase.get(proto);
        return p.createClone();
    }
}
