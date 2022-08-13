package com.nhnacademy.eggplantdeliveryschedule.reader;

import com.nhnacademy.eggplantdeliveryschedule.repository.DeliveryInfoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

/**
 * 배송위치를 조회해 배송위치 옮기기 위해 Db 에 접근해 정보를 읽을 Reader 클래스 입니다.
 *
 * @author : 조재철, 김훈민
 * @version 1.0.0
 */
@Component
@RequiredArgsConstructor
public class DeliveryLocationChangeReader implements ItemReader<List<String>> {

    private final DeliveryInfoRepository deliveryInfoRepository;

    @Override
    public List<String> read() {
        List<String> trackingNoList = deliveryInfoRepository.retrieveStatusDeliveringTrackingNo();
        return trackingNoList.isEmpty() ? null : trackingNoList;
    }

}
