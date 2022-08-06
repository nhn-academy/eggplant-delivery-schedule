package com.nhnacademy.eggplantdeliveryschedule.config.batch.step;

import com.nhnacademy.eggplantdeliveryschedule.dto.response.DeliveryInfoStatusResponseDto;
import com.nhnacademy.eggplantdeliveryschedule.entity.DeliveryInfo;
import com.nhnacademy.eggplantdeliveryschedule.reader.PrepareDeliveryStatusReader;
import com.nhnacademy.eggplantdeliveryschedule.repository.DeliveryInfoRepository;
import com.nhnacademy.eggplantdeliveryschedule.writer.PrepareDeliveryStatusWriter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.listener.ExecutionContextPromotionListener;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : 조재철
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
public class DeliveryStatusChangeStepConfig {

    private static final int CHUNK_SIZE = 10;

    private final PrepareDeliveryStatusReader prepareDeliveryStatusReader;
    private final PrepareDeliveryStatusWriter prepareDeliveryStatusWriter;

    private final StepBuilderFactory stepBuilderFactory;

    private final DeliveryInfoRepository deliveryInfoRepository;

    @Bean
    public ExecutionContextPromotionListener promotionListener() {
        ExecutionContextPromotionListener executionContextPromotionListener =
            new ExecutionContextPromotionListener();
        executionContextPromotionListener.setKeys(new String[] {"deliveryStatusList"});

        return executionContextPromotionListener;
    }

    @Bean
    @JobScope
    public Step prepareDeliveryStatusList() {
        return stepBuilderFactory.get("배송 상태를 얻는 step")
                                 .allowStartIfComplete(true)
                                 .<DeliveryInfoStatusResponseDto, DeliveryInfoStatusResponseDto>chunk(CHUNK_SIZE)
                                 .reader(prepareDeliveryStatusReader)
                                 .writer(prepareDeliveryStatusWriter)
                                 .build();
    }

}