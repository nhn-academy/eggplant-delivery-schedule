package com.nhnacademy.eggplantdeliveryschedule.repository;

import com.nhnacademy.eggplantdeliveryschedule.entity.DeliveryInfo;
import com.nhnacademy.eggplantdeliveryschedule.entity.QDeliveryInfo;
import com.nhnacademy.eggplantdeliveryschedule.entity.QLocation;
import com.nhnacademy.eggplantdeliveryschedule.entity.status.Status;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

/**
 * Query DSL 의 사용과 JpaRepository 의 Db 접근을 구현한 클래스 입니다.
 * 해당 클래스는 배송정보 관련 처리를 위한 Repository 구현체 입니다.
 *
 * @author 조재철, 김훈민
 * @version 1.0.0
 */
public class DeliveryInfoRepositoryImpl extends QuerydslRepositorySupport implements CustomDeliveryInfoRepository {

    private static final String RAND_FUNCTION = "function('rand')";
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
            .orderBy(Expressions.numberTemplate(Double.class, RAND_FUNCTION).asc())
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
            .orderBy(Expressions.numberTemplate(Double.class, RAND_FUNCTION).asc())
            .limit(10L)
            .select(deliveryInfo.trackingNo)
            .fetch();
    }

    @Override
    public List<String> retrieveStatusDeliveringFinalTrackingNo() {
        return from(deliveryInfo)
            .where(JPAExpressions.select(deliveryInfo.count()).from(del).innerJoin(loc)
                                 .on(del.trackingNo.eq(loc.pk.trackingNo)).where(
                    del.status.eq(Status.DELIVERING).and(deliveryInfo.trackingNo.eq(del.trackingNo))).eq(2L))
            .orderBy(Expressions.numberTemplate(Double.class, RAND_FUNCTION).asc())
            .limit(10L)
            .select(deliveryInfo.trackingNo)
            .fetch();
    }

}
