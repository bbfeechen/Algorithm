package designpattern.abstract_factory.tablefactory;

import java.util.Iterator;

import designpattern.abstract_factory.factory.Item;
import designpattern.abstract_factory.factory.Tray;

public class TableTray extends Tray {

    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<td>\n");
        buffer.append("<table width=\"100%\" border=\"1\"><tr>");
        buffer.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\"" + tray.size() + "\"><b>" + caption +
                "</b><td>");
        buffer.append("</tr>\n");
        buffer.append("<tr>\n");
        Iterator iterator = tray.iterator();
        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</tr></table>\n");
        buffer.append("</td>\n");
        return buffer.toString();
    }
}
