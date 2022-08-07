package com.nhnacademy.eggplantdeliveryschedule.reader;

import com.nhnacademy.eggplantdeliveryschedule.repository.DeliveryInfoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

/**
 * 배송정보의 상태가 배송준비중에서 배송중 처리를 하기위해 Db 를 읽을 Reader 클래스 입니다.
 *
 * @author : 조재철, 김훈민
 * @version 1.0.0
 */
@Component
@RequiredArgsConstructor
public class ReadyToDeliveringReader implements ItemReader<List<String>> {

    private final DeliveryInfoRepository deliveryInfoRepository;

    @Override
    public List<String> read() {
        return deliveryInfoRepository.retrieveStatusReadyTrackingNo();
    }

}
