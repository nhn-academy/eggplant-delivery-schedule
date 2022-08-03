package com.nhnacademy.eggplantdeliveryschedule.reader;

import com.nhnacademy.eggplantdeliveryschedule.adaptor.DeliveryInfoStatusAdaptor;
import com.nhnacademy.eggplantdeliveryschedule.dto.response.DeliveryInfoStatusResponseDto;
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
public class PrepareDeliveryStatusReader implements ItemReader<List<DeliveryInfoStatusResponseDto>> {

    private final DeliveryInfoStatusAdaptor deliveryInfoStatusAdaptor;

    private int cnt = 0;

    @Override
    public List<DeliveryInfoStatusResponseDto> read() {
        List<DeliveryInfoStatusResponseDto> deliveryInfoStatusResponseDtos =
            deliveryInfoStatusAdaptor.findDeliveryInfoStatuses();

        return ++cnt == 1 ? deliveryInfoStatusResponseDtos : null;
    }
}
