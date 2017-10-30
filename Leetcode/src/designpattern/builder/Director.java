package designpattern.builder;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.makeTitle("Greeting");
        builder.makeString("from morning to afternoon");
        builder.makeItems(new String[] {"good morning", "good afternoon"});
        builder.makeString("in the evening");
        builder.makeItems(new String[] {"good evening", "good night", "bye-bye"});
        builder.close();
    }
}
