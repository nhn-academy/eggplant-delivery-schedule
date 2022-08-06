package com.nhnacademy.eggplantdeliveryschedule.reader;

import com.nhnacademy.eggplantdeliveryschedule.repository.DeliveryInfoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeliveryLocationChangeReader implements ItemReader<List<String>> {

    private final DeliveryInfoRepository deliveryInfoRepository;

    @Override
    public List<String> read() {
        return deliveryInfoRepository.retrieveStatusDeliveringTrackingNo();
    }
}
