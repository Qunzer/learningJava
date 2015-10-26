package com.javalearning.concurrent;

import com.google.common.base.Throwables;
import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by renqun.yuan on 2015/10/26.
 */
public class ExecutorExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);


        ListenableFuture<String> submit = listeningExecutorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "called";
            }
        });

        Futures.addCallback(submit, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("on success:" + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(Throwables.getStackTraceAsString(t));
            }
        });

        System.out.println(submit.get());
    }
}
