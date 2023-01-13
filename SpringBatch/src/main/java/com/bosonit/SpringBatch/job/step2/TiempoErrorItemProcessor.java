package com.bosonit.SpringBatch.job.step2;

import com.bosonit.SpringBatch.models.ErrorTemperatura;
import com.bosonit.SpringBatch.models.Tiempo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

//Step2 Processor
@Slf4j
public class TiempoErrorItemProcessor implements ItemProcessor<Tiempo, ErrorTemperatura> {
    @Override
    public ErrorTemperatura process(Tiempo tiempo) {
        if(tiempo.getTemperatura() > 50 || tiempo.getTemperatura() < -20){
            log.info("Registros recibido de error: {}", tiempo);
            return new ErrorTemperatura(tiempo.getLocalidad(), tiempo.getFecha(), tiempo.getTemperatura());
        }
        return null;
    }
}
