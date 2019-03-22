package multithread_designpattern.active_object;

public class RealResult<T> extends Result<T> {
    private final T result;

    public RealResult(T result) {
        this.result = result;
    }

    @Override
    public T getResult() {
        return result;
    }
}
