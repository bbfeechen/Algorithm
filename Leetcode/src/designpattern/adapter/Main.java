package designpattern.adapter;

import designpattern.adapter.delegate.PrintBannerDelegate;
import designpattern.adapter.extend.PrintBannerExtend;

public class Main {

    public static void main(String[] args) {
        Print p = new PrintBannerDelegate("Hello");
        p.printWeak();
        p.printStrong();

        p = new PrintBannerExtend("World");
        p.printWeak();
        p.printStrong();
    }
}
