package com.nhnacademy.eggplantdeliveryschedule.reader;

import com.nhnacademy.eggplantdeliveryschedule.repository.DeliveryInfoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

/**
 * 배송정보의 상태가 배송중에서 배송완료 처리를 하기위해 Db 를 읽을 Reader 클래스 입니다.
 *
 * @author : 조재철, 김훈민
 * @version 1.0.0
 */
@Component
@StepScope
@RequiredArgsConstructor
public class DeliveringToArrivalReader implements ItemReader<List<String>> {

    private final DeliveryInfoRepository deliveryInfoRepository;

    @Override
    public List<String> read() {
        List<String> trackingNoList = deliveryInfoRepository.retrieveStatusDeliveringFinalTrackingNo();
        return trackingNoList.isEmpty() ? null : trackingNoList;
    }

}
