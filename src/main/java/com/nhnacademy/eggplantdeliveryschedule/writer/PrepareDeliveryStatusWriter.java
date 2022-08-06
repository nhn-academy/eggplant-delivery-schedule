package com.nhnacademy.eggplantdeliveryschedule.writer;

import com.nhnacademy.eggplantdeliveryschedule.dto.response.DeliveryInfoStatusResponseDto;
import com.nhnacademy.eggplantdeliveryschedule.entity.DeliveryInfo;
import com.nhnacademy.eggplantdeliveryschedule.entity.Location;
import com.nhnacademy.eggplantdeliveryschedule.entity.status.Status;
import com.nhnacademy.eggplantdeliveryschedule.exception.NotFoundDeliveryInfoException;
import com.nhnacademy.eggplantdeliveryschedule.repository.DeliveryInfoRepository;
import com.nhnacademy.eggplantdeliveryschedule.repository.LocationRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class PrepareDeliveryStatusWriter implements ItemWriter<DeliveryInfoStatusResponseDto> {

    private StepExecution stepExecution;
    private final DeliveryInfoRepository deliveryInfoRepository;
    private final LocationRepository locationRepository;

    @Override
    public void write(List<? extends DeliveryInfoStatusResponseDto> deliveryInfoStatusResponseDtos) {
        ExecutionContext executionContext = this.stepExecution.getExecutionContext();
        executionContext.put("deliveryInfoStatusResponseDtos", deliveryInfoStatusResponseDtos);

        for (DeliveryInfoStatusResponseDto deliveryInfoStatusResponseDto : deliveryInfoStatusResponseDtos) {
            DeliveryInfo deliveryInfo = deliveryInfoRepository.findById(deliveryInfoStatusResponseDto.getTrackingNo())
                                                              .orElseThrow(() -> new NotFoundDeliveryInfoException(
                                                                  "해당 배송 정보가 없습니다."));
            deliveryInfo.updateStatus(Status.DELIVERING);

            Location location = Location.builder()
                                        .locationNo(1L)
                                        .deliveryInfo(deliveryInfo)
                                        .arrivalTime(LocalDateTime.now())
                                        .build();

            locationRepository.save(location);
        }
    }

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

}
