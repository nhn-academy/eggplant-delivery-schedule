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
 * @author : 조재철
 * @since 1.0
 */
@RequiredArgsConstructor
@Component
public class DeliveryInfoStatusScheduler {
    private final JobLauncher jobLauncher;

    private final JobConfig jobConfig;

    @Scheduled(fixedRate = 1000)
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

    @Scheduled(fixedRate = 10000)
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

}
