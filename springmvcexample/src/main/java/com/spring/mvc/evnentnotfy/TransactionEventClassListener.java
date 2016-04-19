package com.spring.mvc.evnentnotfy;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * Created by rq on 2016/4/19.
 */
@Component
public class TransactionEventClassListener {

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void doSomething(TransactionNotifyEvent transactionNotifyEvent) {
        System.out.println("提交之前" + transactionNotifyEvent.getUserName());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void doSomething2(TransactionNotifyEvent transactionNotifyEvent) {
        System.out.println("提交之后" + transactionNotifyEvent.getUserName());
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT, fallbackExecution = true)
    public void doSomething3(TransactionNotifyEvent transactionNotifyEvent) {
        System.out.println("提交完成" + transactionNotifyEvent.getUserName());
    }
}
