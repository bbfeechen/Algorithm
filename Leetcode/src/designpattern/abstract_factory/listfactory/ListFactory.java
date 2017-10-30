package designpattern.abstract_factory.listfactory;

import designpattern.abstract_factory.factory.Factory;
import designpattern.abstract_factory.factory.Link;
import designpattern.abstract_factory.factory.Page;
import designpattern.abstract_factory.factory.Tray;

public class ListFactory extends Factory {

    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
