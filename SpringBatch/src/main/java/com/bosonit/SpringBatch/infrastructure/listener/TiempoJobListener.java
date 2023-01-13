package com.bosonit.SpringBatch.infrastructure.listener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class TiempoJobListener implements JobExecutionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TiempoJobListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        LOGGER.info("Iniciando job");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            LOGGER.error("Finalizando job -> Ejecución exitosa");
        } else if (jobExecution.getStatus() == BatchStatus.FAILED) {
            LOGGER.info("Error ejecutando el job");
        }
    }

}
