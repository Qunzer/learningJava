package com.javalearning.builder;

/**
 * Created by renqun.yuan on 2015/11/5.
 */
public class BuilderTest {
    public static void main(String[] args) {
        EmailInfo emailInfo = new EmailInfoBuilder().from("foo").to("bar").subject("say hi").body("hello bar").build();
        System.out.println(emailInfo);
    }
}
