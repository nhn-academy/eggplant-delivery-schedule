package com.nhnacademy.eggplantdeliveryschedule.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.eggplantdeliveryschedule.writer.DeliveryLocationChangeWriter;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@DataJpaTest
class CustomDeliveryInfoRepositoryTest {
    @Autowired
    DeliveryInfoRepository deliveryInfoRepository;

    @MockBean
    DeliveryLocationChangeWriter writer;

    @Test
    void testRetrieveStatusReadyTrackingNo() {
        List<String> strings = deliveryInfoRepository.retrieveStatusReadyTrackingNo();

        assertThat(strings).isEmpty();
    }

    @Test
    void testRetrieveStatusDeliveringTrackingNo() {
        List<String> strings = deliveryInfoRepository.retrieveStatusDeliveringTrackingNo();

        assertThat(strings).isEmpty();
    }

    @Test
    void testRetrieveStatusDeliveringFinalTrackingNo() {
        List<String> strings = deliveryInfoRepository.retrieveStatusDeliveringFinalTrackingNo();

        assertThat(strings).isEmpty();
    }

}
