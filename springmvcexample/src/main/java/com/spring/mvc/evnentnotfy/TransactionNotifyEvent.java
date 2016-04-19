package com.spring.mvc.evnentnotfy;

import org.springframework.context.ApplicationEvent;

/**
 * Created by rq on 2016/4/19.
 */
public class TransactionNotifyEvent extends ApplicationEvent {
    private String userName;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public TransactionNotifyEvent(String source) {
        super(source);
        this.userName = source;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
