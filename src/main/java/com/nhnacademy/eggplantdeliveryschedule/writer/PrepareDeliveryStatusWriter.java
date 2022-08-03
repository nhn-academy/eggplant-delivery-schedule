package com.nhnacademy.eggplantdeliveryschedule.writer;

import com.nhnacademy.eggplantdeliveryschedule.dto.ChangedDeliveryInfoDto;
import com.nhnacademy.eggplantdeliveryschedule.dto.response.DeliveryInfoStatusResponseDto;
import java.util.List;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

/**
 * @author : 조재철
 * @since 1.0
 */
@Component
@StepScope
public class PrepareDeliveryStatusWriter implements ItemWriter<List<ChangedDeliveryInfoDto>> {

    private StepExecution stepExecution;

    @Override
    public void write(List<? extends List<ChangedDeliveryInfoDto>> changedDeliveryInfoDtos) {
        ExecutionContext executionContext = this.stepExecution.getExecutionContext();
        executionContext.put("changedDeliveryInfoDtos", changedDeliveryInfoDtos);
    }

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }
}
