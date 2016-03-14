package com.javalearning;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * Created by renqun.yuan on 2016/3/2.
 */
public class TestMain {
    public static void main(String[] args) {
        ModelTest modelTest = new ModelTest();
        modelTest.setKey("0MOde0");
        ModelTest modelTest1 = new ModelTest();
        modelTest1.setKey("0MOdel");
        modelTest1.setModelTestList(Lists.newArrayList(modelTest));
        ModelTest modelTest2 = new ModelTest();
        modelTest2.setKey("0MOde2");
        modelTest2.setModelTestList(Lists.<ModelTest>newArrayList(modelTest1));
        List<String> urls = Lists.newArrayList();

        TestMain testMain = new TestMain();
        testMain.build(urls, modelTest2);
        System.out.println(urls);

    }

    private void build(List<String> urls , ModelTest modelTest) {
        if (modelTest == null) {
            return;
        }

        urls.add(modelTest.getKey());

        List<ModelTest> children = modelTest.getModelTestList();

        if (CollectionUtils.isEmpty(children)) {
            return;
        }

        for (ModelTest child : children) {
            build(urls, child);
        }
    }
}
