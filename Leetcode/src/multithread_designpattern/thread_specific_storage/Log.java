package multithread_designpattern.thread_specific_storage;

public class Log {
    private static final ThreadLocal<TSLog> tsLogs = new ThreadLocal<>();

    public static void println(String s) {
        getTSLog().println(s);
    }

    public static void close() {
        getTSLog().close();
    }

    private static TSLog getTSLog() {
        TSLog tsLog = tsLogs.get();
        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogs.set(tsLog);
        }
        return tsLog;
    }
}
