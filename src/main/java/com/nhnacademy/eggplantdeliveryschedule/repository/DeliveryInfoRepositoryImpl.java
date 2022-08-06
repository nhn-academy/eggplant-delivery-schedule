package com.nhnacademy.eggplantdeliveryschedule.repository;

import com.nhnacademy.eggplantdeliveryschedule.entity.DeliveryInfo;
import com.nhnacademy.eggplantdeliveryschedule.entity.QDeliveryInfo;
import com.nhnacademy.eggplantdeliveryschedule.entity.QLocation;
import com.nhnacademy.eggplantdeliveryschedule.entity.status.Status;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class DeliveryInfoRepositoryImpl extends QuerydslRepositorySupport implements CustomDeliveryInfoRepository {

    QDeliveryInfo del = new QDeliveryInfo("del");
    QDeliveryInfo deliveryInfo = QDeliveryInfo.deliveryInfo;
    QLocation loc = new QLocation("loc");

    public DeliveryInfoRepositoryImpl() {
        super(DeliveryInfo.class);
    }

    @Override
    public List<String> retrieveStatusReadyTrackingNo() {
        return from(deliveryInfo)
            .where(deliveryInfo.status.eq(Status.READY))
            .orderBy(Expressions.numberTemplate(Double.class, "function('rand')").asc())
            .limit(10L)
            .select(deliveryInfo.trackingNo)
            .fetch();
    }

    @Override
    public List<String> retrieveStatusDeliveringTrackingNo() {
        return from(deliveryInfo)
            .where(JPAExpressions.select(deliveryInfo.count()).from(del).innerJoin(loc)
                                 .on(del.trackingNo.eq(loc.pk.trackingNo)).where(
                    del.status.eq(Status.DELIVERING).and(deliveryInfo.trackingNo.eq(del.trackingNo))).eq(1L))
            .orderBy(Expressions.numberTemplate(Double.class, "function('rand')").asc())
            .limit(10L)
            .select(deliveryInfo.trackingNo)
            .fetch();
    }

}
