package com.nhnacademy.eggplantdeliveryschedule.repository;

import java.util.List;

public interface CustomDeliveryInfoRepository {
    List<String> retrieveStatusReadyTrackingNo();

    List<String> retrieveStatusDeliveringTrackingNo();

    List<String> retrieveStatusDeliveringFinalTrackingNo();
}
