package com.javalearning.builder;

/**
 * Created by renqun.yuan on 2015/11/5.
 */
public class EmailInfoBuilder implements Builder<EmailInfo> {
    private EmailInfo emailInfo;

    public EmailInfoBuilder() {
        emailInfo = new EmailInfo();
    }

    public EmailInfoBuilder to(String to) {
        emailInfo.setTo(to);
        return this;
    }

    public EmailInfoBuilder from(String from) {
        emailInfo.setFrom(from);
        return this;
    }

    public EmailInfoBuilder subject(String subject) {
        emailInfo.setSubject(subject);
        return this;
    }

    public EmailInfoBuilder body(String body) {
        emailInfo.setBody(body);
        return this;
    }

    @Override
    public EmailInfo build() {
        return this.emailInfo;
    }
}
