package com.spring.mvc.evnentnotfy;

import org.springframework.context.ApplicationEvent;

/**
 * Created by renqun.yuan on 2016/3/14.
 */
public class NotifyEvent extends ApplicationEvent {
    private String userName;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public NotifyEvent(String source) {
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
