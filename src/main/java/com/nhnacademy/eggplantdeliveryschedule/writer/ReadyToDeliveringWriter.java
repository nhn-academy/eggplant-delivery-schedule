package com.nhnacademy.eggplantdeliveryschedule.writer;

import com.nhnacademy.eggplantdeliveryschedule.entity.DeliveryInfo;
import com.nhnacademy.eggplantdeliveryschedule.entity.Location;
import com.nhnacademy.eggplantdeliveryschedule.entity.status.Status;
import com.nhnacademy.eggplantdeliveryschedule.exception.NotFoundDeliveryInfoException;
import com.nhnacademy.eggplantdeliveryschedule.repository.DeliveryInfoRepository;
import com.nhnacademy.eggplantdeliveryschedule.repository.LocationRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

/**
 * ReadyToDeliveringReader 에서 읽은 데이터의 정보를 처리하기 위한 Writer 클래스 입니다.
 *
 * @author : 조재철, 김훈민
 * @version 1.0.0
 */
@Component
@StepScope
@RequiredArgsConstructor
public class ReadyToDeliveringWriter implements ItemWriter<List<String>> {

    private StepExecution stepExecution;
    private final DeliveryInfoRepository deliveryInfoRepository;
    private final LocationRepository locationRepository;

    @Override
    public void write(List<? extends List<String>> trackingNoChunkList) {
        ExecutionContext executionContext = this.stepExecution.getExecutionContext();
        executionContext.put("trackingNoChunkList", trackingNoChunkList);

        List<String> trackingNoList = trackingNoChunkList.stream()
                                                         .flatMap(List::stream)
                                                         .collect(Collectors.toList());

        for (String trackingNo : trackingNoList) {
            DeliveryInfo deliveryInfo = deliveryInfoRepository.findById(trackingNo)
                                                              .orElseThrow(NotFoundDeliveryInfoException::new);
            deliveryInfo.updateStatus(Status.DELIVERING);

            Location location = Location.builder()
                                        .pk(new Location.Pk(1L, deliveryInfo.getTrackingNo()))
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
