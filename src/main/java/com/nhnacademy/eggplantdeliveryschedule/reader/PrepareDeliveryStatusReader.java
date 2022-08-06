package com.nhnacademy.eggplantdeliveryschedule.reader;

import com.nhnacademy.eggplantdeliveryschedule.adaptor.DeliveryInfoStatusAdaptor;
import com.nhnacademy.eggplantdeliveryschedule.dto.response.DeliveryInfoStatusResponseDto;
import com.nhnacademy.eggplantdeliveryschedule.entity.DeliveryInfo;
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
public class PrepareDeliveryStatusReader implements ItemReader<DeliveryInfoStatusResponseDto> {

    private final DeliveryInfoService deliveryInfoService;

    @Override
    public DeliveryInfoStatusResponseDto read() {
        DeliveryInfoStatusResponseDto deliveryInfoStatusResponseDto =
            deliveryInfoService.retrieveDeliveryInfoStatus();

        return deliveryInfoStatusResponseDto;
    }
}
