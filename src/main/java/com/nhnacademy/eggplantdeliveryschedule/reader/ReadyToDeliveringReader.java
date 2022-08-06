package com.nhnacademy.eggplantdeliveryschedule.reader;

import com.nhnacademy.eggplantdeliveryschedule.service.DeliveryInfoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

/**
 * @author : 조재철
 * @since 1.0
 */
@Component
@RequiredArgsConstructor
public class ReadyToDeliveringReader implements ItemReader<List<String>> {

    private final DeliveryInfoService deliveryInfoService;

    @Override
    public List<String> read() {
        return deliveryInfoService.retrieveDeliveryInfoStatus();
    }
}
