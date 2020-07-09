package com.testmodule.rxjava;

import com.testmodule.testKotlin.entity.CartEntity;
import io.reactivex.*;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

/**
 * @author changePosition
 * @date 2020/7/5/005 0:47
 */
public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("TAG-"+0);
        list.add("TAG-"+1);
        list.add("TAG-"+2);
        list.add("TAG-"+3);
        list.add("TAG-"+4);

        Observable.fromArray(list)

//                .map(new Function<List<String>, Object>() {
//                    @Override
//                    public Object apply(List<String> strings) throws Exception {
//                        return null;
//                    }
//                })


                .flatMap(new Function<List<String>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(List<String> strings) throws Exception {
                        return Observable.fromArray(strings);
                    }
                })

                .subscribe((System.out::println));
    }

    private static void map(List<String> list){
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {

            }
        });
        Observable.just(list)
                .map(new Function<List<String>, CartEntity>() {
                    @Override
                    public CartEntity apply(List<String> strings) throws Exception {
                        return null;
                    }
                })
                .subscribe(new Consumer<CartEntity>() {
                    @Override
                    public void accept(CartEntity cartEntity) throws Exception {

                    }
                });

    }

}
