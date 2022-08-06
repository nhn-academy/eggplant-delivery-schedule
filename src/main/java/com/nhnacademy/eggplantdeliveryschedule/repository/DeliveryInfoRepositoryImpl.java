package com.nhnacademy.eggplantdeliveryschedule.repository;

import com.nhnacademy.eggplantdeliveryschedule.entity.DeliveryInfo;
import com.nhnacademy.eggplantdeliveryschedule.entity.QDeliveryInfo;
import com.nhnacademy.eggplantdeliveryschedule.entity.status.Status;
import com.querydsl.core.types.dsl.Expressions;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class DeliveryInfoRepositoryImpl extends QuerydslRepositorySupport implements CustomDeliveryInfoRepository {

    public DeliveryInfoRepositoryImpl() {
        super(DeliveryInfo.class);
    }

    @Override
    public List<String> retrieveStatusReady() {
        QDeliveryInfo deliveryInfo = QDeliveryInfo.deliveryInfo;

        return from(deliveryInfo)
            .where(deliveryInfo.status.eq(Status.READY))
            .orderBy(Expressions.numberTemplate(Double.class, "function('rand')").asc())
            .limit(10L)
            .select(deliveryInfo.trackingNo)
            .fetch();
    }

}
