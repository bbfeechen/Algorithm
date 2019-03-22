package multithread_designpattern.active_object;

public class MakeStringRequest extends MethodRequest<String> {
    private final int count;
    private final char filechar;

    public MakeStringRequest(Servant servant, FutureResult<String> future, int count, char filechar) {
        super(servant, future);
        this.count = count;
        this.filechar = filechar;
    }

    @Override
    public void execute() {
        Result<String> result = servant.makeString(count, filechar);
        future.setResult(result);
    }
}
