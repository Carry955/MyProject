package com.carry.myproject.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledFuture;

@Component
public class ScheduledTask {
    volatile ScheduledFuture<?> future;

    public void cancel() {
        ScheduledFuture<?> future = this.future;
        if (future != null) {
            future.cancel(true);
        }
    }
}
