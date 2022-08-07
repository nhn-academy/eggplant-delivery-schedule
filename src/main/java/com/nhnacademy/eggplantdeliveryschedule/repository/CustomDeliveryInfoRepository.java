package com.nhnacademy.eggplantdeliveryschedule.repository;

import java.util.List;

/**
 * QueryDsl 의 사용을 위한 CustomRepository 인터페이스 입니다.
 *
 * @author 조재철, 김훈민
 * @version 1.0.0
 */
public interface CustomDeliveryInfoRepository {
    List<String> retrieveStatusReadyTrackingNo();

    List<String> retrieveStatusDeliveringTrackingNo();

    List<String> retrieveStatusDeliveringFinalTrackingNo();
}
