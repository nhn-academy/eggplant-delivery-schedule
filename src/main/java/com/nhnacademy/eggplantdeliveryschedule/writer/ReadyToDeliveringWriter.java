package com.nhnacademy.eggplantdeliveryschedule.writer;

import com.nhnacademy.eggplantdeliveryschedule.dto.response.DeliveryInfoStatusResponseDto;
import com.nhnacademy.eggplantdeliveryschedule.entity.DeliveryInfo;
import com.nhnacademy.eggplantdeliveryschedule.entity.Location;
import com.nhnacademy.eggplantdeliveryschedule.entity.status.LocationStatus;
import com.nhnacademy.eggplantdeliveryschedule.entity.status.Status;
import com.nhnacademy.eggplantdeliveryschedule.exception.NotFoundDeliveryInfoException;
import com.nhnacademy.eggplantdeliveryschedule.module.Sender;
import com.nhnacademy.eggplantdeliveryschedule.repository.DeliveryInfoRepository;
import com.nhnacademy.eggplantdeliveryschedule.repository.LocationRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    private final DeliveryInfoRepository deliveryInfoRepository;
    private final LocationRepository locationRepository;
    private final Sender sender;

    @Transactional
    @Override
    public void write(List<? extends List<String>> trackingNoChunkList) {
        List<String> trackingNoList = trackingNoChunkList.stream()
                                                         .flatMap(List::stream)
                                                         .distinct()
                                                         .collect(Collectors.toList());

        for (String trackingNo : trackingNoList) {
            DeliveryInfo deliveryInfo = deliveryInfoRepository.findById(trackingNo)
                                                              .orElseThrow(NotFoundDeliveryInfoException::new);
            deliveryInfo.updateStatus(Status.DELIVERING);

            Location location = Location.builder()
                                        .pk(new Location.Pk(1L, deliveryInfo.getTrackingNo()))
                                        .deliveryInfo(deliveryInfo)
                                        .middleLocation(LocationStatus.FIRST_LOCATION.getValue())
                                        .arrivalTime(LocalDateTime.now())
                                        .build();

            locationRepository.save(location);

            sender.sendChangeDeliveryStatus(
                new DeliveryInfoStatusResponseDto(deliveryInfo.getOrderNo(), deliveryInfo.getStatus(),
                    deliveryInfo.getShopHost(), deliveryInfo.getCompletionTime()));
        }
    }

}
