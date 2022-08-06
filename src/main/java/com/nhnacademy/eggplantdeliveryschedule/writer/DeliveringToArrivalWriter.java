package com.nhnacademy.eggplantdeliveryschedule.writer;

import com.nhnacademy.eggplantdeliveryschedule.entity.DeliveryInfo;
import com.nhnacademy.eggplantdeliveryschedule.entity.status.Status;
import com.nhnacademy.eggplantdeliveryschedule.exception.NotFoundDeliveryInfoException;
import com.nhnacademy.eggplantdeliveryschedule.repository.DeliveryInfoRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

/**
 * @author : 조재철
 * @since 1.0
 */
@Component
@StepScope
@RequiredArgsConstructor
public class DeliveringToArrivalWriter implements ItemWriter<List<String>> {

    private final DeliveryInfoRepository deliveryInfoRepository;

    @Override
    public void write(List<? extends List<String>> trackingNoChunkList) {
        List<String> trackingNoList = trackingNoChunkList.stream()
                                                         .flatMap(List::stream)
                                                         .collect(Collectors.toList());

        for (String trackingNo : trackingNoList) {
            DeliveryInfo deliveryInfo = deliveryInfoRepository.findById(trackingNo)
                                                              .orElseThrow(NotFoundDeliveryInfoException::new);
            deliveryInfo.updateStatus(Status.ARRIVAL);
        }
    }
}