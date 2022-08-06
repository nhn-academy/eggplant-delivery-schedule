package com.nhnacademy.eggplantdeliveryschedule.config.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Batch 설정 클래스.
 *
 * @author : 조재철
 * @version 1.0
 */
@Configuration
@RequiredArgsConstructor
public class BatchConfig {

    private final JobRegistry jobRegistry;

    /**
     * Job 마다 등록할 필요 없이 Job Type 이 빈으로 등록될 때 후 처리로 자동으로 JobRegistry 에 등록
     * JobRegistryBeanPostProcessor 에 JobRegistry 를 등록하게 하는 클래스.
     *
     * @return JobRegistry 를 등록한 JobPostBeanProcessor 반환.
     */
    @Bean
    public BeanPostProcessor beanPostProcessor() {
        JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();

        jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry);

        return jobRegistryBeanPostProcessor;
    }
}
