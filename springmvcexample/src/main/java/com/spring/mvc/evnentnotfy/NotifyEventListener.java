package com.spring.mvc.evnentnotfy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * Created by renqun.yuan on 2016/3/14.
 */
@Service
public class NotifyEventListener implements ApplicationListener<NotifyEvent> {
    private static final Logger logger = LoggerFactory.getLogger(NotifyEventListener.class);

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(NotifyEvent event) {
        String userName = event.getUserName();
        // todo something , maybe send email, here just logger some info
        logger.info("please say hello， {}", userName);
    }
}
