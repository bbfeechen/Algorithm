package rxjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.schedulers.TestScheduler;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;

public class Main {

    static Observable<String> observable1 = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello, world!");
            subscriber.onCompleted();
        }
    });

    static Observable<String> observable2 = Observable.just("Hello, world!");

    static Subscriber<String> subscriber1 = new Subscriber<String>() {
        @Override
        public void onCompleted() { }

        @Override
        public void onError(Throwable throwable) { }

        @Override
        public void onNext(String s) {
            System.out.println(s);
        }
    };

    static Action1<String> onNextAction = new Action1<String>() {
        @Override
        public void call(String s) {
            System.out.println(s);
        }
    };

    public static void main(String[] args) {
        // part1
//        observable1.subscribe(subscriber1);
//        observable2.subscribe(onNextAction);
//
//        Observable.just("Hello, world!")
//                .subscribe(s -> System.out.println(s + " -Dan"));
//
//        Observable.just("Hello, world!")
//                .map(s -> s + " -Dan")
//                .subscribe(s -> System.out.println(s));
//
//        Observable.just("Hello, world!")
//                .map(s -> s.hashCode())
//                .map(i -> Integer.toString(i))
//                .subscribe(s -> System.out.println(s));

        // part2
//        Observable.from(new ArrayList<>(Arrays.asList("url1", "url2", "url3")))
//                .take(3)
//                .subscribe(url -> System.out.println(url));
//        Subscription subscription = Observable.just("Hello, world!")
//                .map(s -> (1 / 0))
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("Completed");
//                    }
//
//                    @Override
//                    public void onError(Throwable throwable) {
//                        System.out.println("Error");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        System.out.println("Next");
//                    }
//                });
//        subscription.unsubscribe();
//        System.out.println("Unsubscribed = " + subscription.isUnsubscribed());

        // Subject
//        PublishSubject<Integer> source = PublishSubject.create();
//        ReplaySubject<Integer> source = ReplaySubject.create();
//        BehaviorSubject<Integer> source = BehaviorSubject.create();
//        AsyncSubject<Integer> source = AsyncSubject.create();
//
//        // It will get 1, 2, 3, 4 and onComplete
//        source.subscribe(new Observer<Integer>() {
//            @Override
//            public void onCompleted() {
//                System.out.println("Observer1 onCompleted");
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                System.out.println("Observer1 onError");
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                System.out.println("Observer1 onNext " + integer);
//            }
//        });
//
//        source.onNext(1);
//        source.onNext(2);
//        source.onNext(3);
//
//        // It will get 4 and onComplete for second observer also.
//        source.subscribe(new Observer<Integer>() {
//            @Override
//            public void onCompleted() {
//                System.out.println("Observer2 onCompleted");
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                System.out.println("Observer2 onError");
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                System.out.println("Observer2 onNext " + integer);
//            }
//        });
//
//        source.onNext(4);
//        source.onCompleted();

        // first vs take(1)
//        Observable.empty().take(1)
//                .subscribe(System.out::println, Throwable::printStackTrace,
//                        () -> System.out.println("Done"));
//
//        Observable.just(1).take(1)
//                .subscribe(System.out::println, Throwable::printStackTrace,
//                        () -> System.out.println("Done"));
//
//        Observable.just(1, 2, 3).take(1)
//                .subscribe(System.out::println, Throwable::printStackTrace,
//                        () -> System.out.println("Done"));
//
//        Observable.empty().first()
//                .subscribe(System.out::println, Throwable::printStackTrace,
//                        () -> System.out.println("Done"));
//
//        Observable.just(1).first()
//                .subscribe(System.out::println, Throwable::printStackTrace,
//                        () -> System.out.println("Done"));
//
//        Observable.just(1, 2, 3).first()
//                .subscribe(System.out::println, Throwable::printStackTrace,
//                        () -> System.out.println("Done"));
//
//        Observable.empty().single()
//                .subscribe(System.out::println, Throwable::printStackTrace,
//                        () -> System.out.println("Done"));
//
//        Observable.just(1, 2, 3).single()
//                .subscribe(System.out::println, Throwable::printStackTrace,
//                        () -> System.out.println("Done"));


        final List<String> items = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
        final TestScheduler scheduler = new TestScheduler();
        Observable.from(items)
                .concatMap( s -> {
                    final int delay = new Random().nextInt(10);
                    return Observable.just(s + "x")
                            .delay(delay, TimeUnit.SECONDS, scheduler);
                })
                .toList()
                .doOnNext(System.out::println)
                .subscribe();

        scheduler.advanceTimeBy(1, TimeUnit.MINUTES);
    }
}
