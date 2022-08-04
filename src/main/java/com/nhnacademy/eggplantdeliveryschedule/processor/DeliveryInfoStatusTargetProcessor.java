package com.nhnacademy.eggplantdeliveryschedule.processor;

import com.nhnacademy.eggplantdeliveryschedule.adaptor.DeliveryInfoStatusAdaptor;
import com.nhnacademy.eggplantdeliveryschedule.dto.ChangedDeliveryInfoDto;
import com.nhnacademy.eggplantdeliveryschedule.dto.response.DeliveryInfoStatusResponseDto;
import com.nhnacademy.eggplantdeliveryschedule.dto.Status;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author : 조재철
 * @since 1.0
 */
@Component
@RequiredArgsConstructor
public class DeliveryInfoStatusTargetProcessor implements
    ItemProcessor<List<DeliveryInfoStatusResponseDto>, List<ChangedDeliveryInfoDto>> {

    private final DeliveryInfoStatusAdaptor deliveryInfoStatusAdaptor;

    @Override
    public List<ChangedDeliveryInfoDto> process(List<DeliveryInfoStatusResponseDto> deliveryInfoStatusResponseDtos) {
        List<ChangedDeliveryInfoDto> changedDeliveryInfoDtos = new ArrayList<>();

        for (DeliveryInfoStatusResponseDto deliveryInfoStatusResponseDto : deliveryInfoStatusResponseDtos) {
            ChangedDeliveryInfoDto changedDeliveryInfoDto = new ChangedDeliveryInfoDto();
            changedDeliveryInfoDto.setStatus(Status.ARRIVAL);
            changedDeliveryInfoDto.setTrackingNo(deliveryInfoStatusResponseDto.getTrackingNo());

            changedDeliveryInfoDtos.add(changedDeliveryInfoDto);
        }

        deliveryInfoStatusAdaptor.insertChangedDeliveryInfo(changedDeliveryInfoDtos);

        return changedDeliveryInfoDtos;
    }
}
