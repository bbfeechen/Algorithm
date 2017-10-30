package designpattern.abstract_factory;

import designpattern.abstract_factory.factory.Factory;
import designpattern.abstract_factory.factory.Link;
import designpattern.abstract_factory.factory.Page;
import designpattern.abstract_factory.factory.Tray;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main class.name.of.ConcreteFactory");
            System.out.println("Example 1: java Main listfactory.ListFactory");
            System.out.println("Example 2: java Main tablefactory.TableFactory");
            System.exit(0);
        }

        Factory factory = Factory.getFactory(args[0]);
        Link asahi = factory.createLink("Asahi News", "http://www.asahi.com/");
        Link yomiuri = factory.createLink("Yomiuri News", "http://www.yomiuri.co.jp/");
        Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
        Link jp_yahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/");
        Link excite = factory.createLink("Excite", "http://www.excite.com/");
        Link google = factory.createLink("Google", "http://www.google.com/");

        Tray trayNews = factory.createTray("News");
        trayNews.add(asahi);
        trayNews.add(yomiuri);

        Tray trayYahoo = factory.createTray("Yahoo!");
        trayNews.add(us_yahoo);
        trayNews.add(jp_yahoo);

        Tray traySearch = factory.createTray("SearchEngine!");
        trayNews.add(trayYahoo);
        trayNews.add(excite);
        trayNews.add(google);

        Page page = factory.createPage("LinkPage", "Kailiang");
        page.add(trayNews);
        page.add(traySearch);
        page.output();
    }
}
