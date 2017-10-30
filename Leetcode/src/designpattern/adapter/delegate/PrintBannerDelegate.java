package designpattern.adapter.delegate;

import designpattern.adapter.Banner;
import designpattern.adapter.Print;

public class PrintBannerDelegate implements Print {
    private Banner banner;

    public PrintBannerDelegate(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
