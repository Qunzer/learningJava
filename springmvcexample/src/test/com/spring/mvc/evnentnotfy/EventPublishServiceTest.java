package com.spring.mvc.evnentnotfy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by renqun.yuan on 2016/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class EventPublishServiceTest {
    @Resource
    private EventPublishService eventPublishService;

    @Test
    public void testPublishEvent() throws Exception {
        eventPublishService.doSomething("spring mvc ");
    }
}