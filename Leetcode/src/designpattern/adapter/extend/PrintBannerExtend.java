package designpattern.adapter.extend;

import designpattern.adapter.Banner;
import designpattern.adapter.Print;

public class PrintBannerExtend extends Banner implements Print {

    public PrintBannerExtend(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
