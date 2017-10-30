package designpattern.builder;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }
        if (args[0].equals("plain")) {
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            String result = textBuilder.getResult();
            System.out.println(result);
        } else if (args[0].equals("html")) {
            HTMLBulder htmlBulder = new HTMLBulder();
            Director director = new Director(htmlBulder);
            director.construct();
            String filename = htmlBulder.getResult();
            System.out.println(filename + " created");
        } else {
            usage();
            System.exit(0);
        }
    }

    public static void usage() {
        System.out.println("Usage: java Main plain - plain text created");
        System.out.println("Usage: java Main html - html text created");
    }
}
