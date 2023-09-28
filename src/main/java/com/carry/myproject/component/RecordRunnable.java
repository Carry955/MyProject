package com.carry.myproject.component;

import com.carry.myproject.dao.RecordDao;
import com.carry.myproject.entity.RecordEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.transaction.annotation.Transactional;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = {"expression"})
public class RecordRunnable implements Runnable {
    private String expression;

    private RecordDao recordDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void run() {
        System.out.println(expression);
        RecordEntity entity = new RecordEntity();
        entity.setData(expression);
        recordDao.insert(entity);
    }
}
