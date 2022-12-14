package com.nhnacademy.eggplantdeliveryschedule.scheduler;

import com.nhnacademy.eggplantdeliveryschedule.config.batch.JobConfig;
import com.nhnacademy.eggplantdeliveryschedule.exception.CustomJobException;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Job 의 Scheduling 을 담당하는 클래스 입니다.
 *
 * @author : 조재철, 김훈민
 * @version 1.0.0
 */
@RequiredArgsConstructor
@Component
public class DeliveryScheduler {

    private final JobLauncher jobLauncher;
    private final JobConfig jobConfig;

    /**
     * 배달 상태를 바꿔주는 일을 2 ~ 4분 단위로 처리하는 스케쥴러 메소드 입니다.
     */
    @Scheduled(fixedDelayString = "#{new Double((T(java.lang.Math).random() + 1) * 2 * 1000 * 60).intValue()}")
    public void doChangeDeliveryStatus() {

        Job job = jobConfig.deliveryStatusChangeJob();
        JobParameters jobParameters = new JobParameters();

        try {
            jobLauncher.run(job, jobParameters);
        } catch (JobInstanceAlreadyCompleteException
            | JobExecutionAlreadyRunningException
            | JobParametersInvalidException
            | JobRestartException e) {

            throw new CustomJobException();
        }
    }

    /**
     * 배달 상태를 바꿔주는 일을 2 ~ 4분 단위로 처리하는 스케쥴러 메소드 입니다.
     */
    @Scheduled(fixedDelayString = "#{new Double((T(java.lang.Math).random() + 1) * 2 * 1000 * 60).intValue()}")
    public void doDeliveryLocationChangeJob() {
        Job job = jobConfig.deliveryLocationChangeJob();
        JobParameters jobParameters = new JobParameters();

        try {
            jobLauncher.run(job, jobParameters);
        } catch (JobInstanceAlreadyCompleteException
            | JobExecutionAlreadyRunningException
            | JobParametersInvalidException
            | JobRestartException e) {

            throw new CustomJobException();
        }
    }

    /**
     * 배달 상태를 바꿔주는 일을 2 ~ 4분 단위로 처리하는 스케쥴러 메소드 입니다.
     */
    @Scheduled(fixedDelayString = "#{new Double((T(java.lang.Math).random() + 1) * 2 * 1000 * 60).intValue()}")
    public void deliveringToArrival() {
        Job job = jobConfig.deliveringToArrivalJob();
        JobParameters jobParameters = new JobParameters();

        try {
            jobLauncher.run(job, jobParameters);
        } catch (JobInstanceAlreadyCompleteException
            | JobExecutionAlreadyRunningException
            | JobParametersInvalidException
            | JobRestartException e) {

            throw new CustomJobException();
        }
    }

}
