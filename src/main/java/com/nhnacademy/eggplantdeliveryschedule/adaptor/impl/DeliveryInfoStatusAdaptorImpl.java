package com.nhnacademy.eggplantdeliveryschedule.adaptor.impl;

import com.nhnacademy.eggplantdeliveryschedule.adaptor.DeliveryInfoStatusAdaptor;
import com.nhnacademy.eggplantdeliveryschedule.dto.ChangedDeliveryInfoDto;
import com.nhnacademy.eggplantdeliveryschedule.dto.response.DeliveryInfoStatusResponseDto;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author : 조재철
 * @since 1.0
 */
@Component
@ConfigurationProperties("eggplant-delivery-server")
public class DeliveryInfoStatusAdaptorImpl implements DeliveryInfoStatusAdaptor {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public List<DeliveryInfoStatusResponseDto> findDeliveryInfoStatuses() {
        WebClient webClient = WebClient.builder()
                                       .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                       .baseUrl(url + ":8080")
                                       .build();

        return webClient.get()
                        .uri(uriBuilder -> uriBuilder.path("/delivery-info-statuses").build())
                        .retrieve()
                        .bodyToFlux(DeliveryInfoStatusResponseDto.class)
                        .collectList()
                        .block();
    }

    @Override
    public void insertChangedDeliveryInfo(List<ChangedDeliveryInfoDto> changedDeliveryInfoDtos) {
        WebClient webClient = WebClient.builder()
                                       .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                       .baseUrl(url + ":8080")
                                       .build();

        webClient.patch()
                 .uri(uriBuilder -> uriBuilder.path("/eggplant-delivery/delivery-completion").build())
                 .bodyValue(changedDeliveryInfoDtos)
                 .retrieve()
                 .toEntity(Void.class)
                 .block();
    }
}
