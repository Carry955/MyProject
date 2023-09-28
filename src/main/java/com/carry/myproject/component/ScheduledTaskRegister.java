package com.carry.myproject.component;

import lombok.Getter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.config.FixedRateTask;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Getter
public class ScheduledTaskRegister implements DisposableBean {
    private final Map<Runnable, ScheduledTask> scheduledTaskMap = new ConcurrentHashMap<>(16);

    @Autowired
    private TaskScheduler taskScheduler;

    public Integer addTask(Runnable task, long interval) {
        return addTask(new FixedRateTask(task, interval, 0));
    }

    private Integer addTask(FixedRateTask fixedRateTask) {
        if (fixedRateTask != null) {
            Runnable task = fixedRateTask.getRunnable();
            if (this.scheduledTaskMap.containsKey(task)) {
                removeTask(task);
            }

            ScheduledTask scheduledTask = new ScheduledTask();
            scheduledTask.future = this.taskScheduler.scheduleAtFixedRate(task, fixedRateTask.getInterval());

            this.scheduledTaskMap.put(task, scheduledTask);
        }
        return 0;
    }

    public void removeTask(Runnable task) {
        ScheduledTask scheduledTask = this.scheduledTaskMap.remove(task);
        if (scheduledTask != null) {
            scheduledTask.cancel();
        }
    }

    @Override
    public void destroy() {
        this.scheduledTaskMap.clear();
    }
}
