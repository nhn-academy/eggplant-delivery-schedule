package com.nhnacademy.eggplantdeliveryschedule.entity.status.writer;

import com.nhnacademy.eggplantdeliveryschedule.entity.DeliveryInfo;
import com.nhnacademy.eggplantdeliveryschedule.entity.Location;
import com.nhnacademy.eggplantdeliveryschedule.exception.NotFoundDeliveryInfoException;
import com.nhnacademy.eggplantdeliveryschedule.repository.DeliveryInfoRepository;
import com.nhnacademy.eggplantdeliveryschedule.repository.LocationRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
@StepScope
@RequiredArgsConstructor
public class DeliveryLocationChangeWriter implements ItemWriter<List<String>> {

    private final DeliveryInfoRepository deliveryInfoRepository;
    private final LocationRepository locationRepository;

    @Override
    public void write(List<? extends List<String>> trackingNoChunkList) {
        List<String> trackingNoList = trackingNoChunkList.stream()
                                                         .flatMap(List::stream)
                                                         .collect(Collectors.toList());

        for (String trackingNo : trackingNoList) {
            DeliveryInfo deliveryInfo = deliveryInfoRepository.findById(trackingNo)
                                                              .orElseThrow(NotFoundDeliveryInfoException::new);
            Location location = Location.builder()
                                        .pk(new Location.Pk(2L, deliveryInfo.getTrackingNo()))
                                        .deliveryInfo(deliveryInfo)
                                        .arrivalTime(LocalDateTime.now())
                                        .build();

            locationRepository.save(location);
        }
    }

}
