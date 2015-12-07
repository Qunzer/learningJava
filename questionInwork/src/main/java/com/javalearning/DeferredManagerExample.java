package com.javalearning;

import com.google.common.collect.Lists;
import org.jdeferred.DeferredManager;
import org.jdeferred.DoneCallback;
import org.jdeferred.FailCallback;
import org.jdeferred.impl.DefaultDeferredManager;
import org.jdeferred.multiple.MultipleResults;
import org.jdeferred.multiple.OneReject;

import java.util.List;

/**
 * Created by renqun.yuan on 2015/12/7.
 */
public class DeferredManagerExample {
    public static void main(String[] args) {
        DeferredManager deferredManager = new DefaultDeferredManager();

        final List<String> customer = Lists.newArrayList();
        final List<String> systemCode = Lists.newArrayList();
        // when中将本来的串行的准备工作并行化，所有的when中执行成功后，执行done，有执行失败的时候，执行fail
        deferredManager.when(new Runnable() {
                                 @Override
                                 public void run() {
                                     customer.add("query from db");
                                     System.out.println("customer done");
                                 }
                             }, new Runnable() {
                                 @Override
                                 public void run() {
                                     systemCode.add("systemCode to build model");
                                     System.out.println("systemCode done");
                                 }
                             }
        ).done(new DoneCallback<MultipleResults>() {
            @Override
            public void onDone(MultipleResults result) {
                String modelInfo = customer.toString() + systemCode.toString();
                System.out.println(modelInfo);
            }
        }).fail(new FailCallback<OneReject>() {
            @Override
            public void onFail(OneReject result) {
                System.out.println(result.getReject().toString());
            }
        });
    }
}
