package com.nhnacademy.eggplantdeliveryschedule.config.job;

import com.nhnacademy.eggplantdeliveryschedule.dto.ChangedDeliveryInfoDto;
import com.nhnacademy.eggplantdeliveryschedule.dto.response.DeliveryInfoStatusResponseDto;
import com.nhnacademy.eggplantdeliveryschedule.processor.DeliveryInfoStatusTargetProcessor;
import com.nhnacademy.eggplantdeliveryschedule.reader.PrepareDeliveryStatusReader;
import com.nhnacademy.eggplantdeliveryschedule.writer.PrepareDeliveryStatusWriter;
import java.util.List;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.listener.ExecutionContextPromotionListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : 조재철
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
public class DeliveryStatusChangeStepConfig {
    private static final int CHUNK_SIZE = 1;

    private final PrepareDeliveryStatusReader prepareDeliveryStatusReader;
    private final DeliveryInfoStatusTargetProcessor deliveryInfoStatusTargetProcessor;
    private final PrepareDeliveryStatusWriter prepareDeliveryStatusWriter;

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public ExecutionContextPromotionListener promotionListener() {
        ExecutionContextPromotionListener executionContextPromotionListener =
            new ExecutionContextPromotionListener();
        executionContextPromotionListener.setKeys(new String[]{"deliveryStatusList"});

        return executionContextPromotionListener;
    }

    @Bean
    @JobScope
    public Step prepareDeliveryStatusList() {
        return stepBuilderFactory.get("배송 상태를 얻는 step")
            .allowStartIfComplete(true)
            .<List<DeliveryInfoStatusResponseDto>, List<ChangedDeliveryInfoDto>>chunk(CHUNK_SIZE)
            .reader(prepareDeliveryStatusReader)
            .processor(deliveryInfoStatusTargetProcessor)
            .writer(prepareDeliveryStatusWriter)
            .listener(promotionListener())
            .build();
    }
}
