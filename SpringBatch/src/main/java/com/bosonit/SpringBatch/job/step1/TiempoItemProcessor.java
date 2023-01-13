package com.bosonit.SpringBatch.job.step1;

import com.bosonit.SpringBatch.models.Tiempo;
import com.bosonit.SpringBatch.models.TiempoRiesgo;
import org.springframework.batch.item.ItemProcessor;


//Step1 Processor
public class TiempoItemProcessor implements ItemProcessor<Tiempo, TiempoRiesgo> {

    @Override
    public TiempoRiesgo process(Tiempo tiempo) {

        if(tiempo.getTemperatura()>50 || tiempo.getTemperatura()<-20) {
            return null;
        }else {
            String localidad = tiempo.getLocalidad();
            String fecha = tiempo.getFecha();

            String[] datos = fecha.split("-");

            String anio = datos[0];

            String mes = datos[1];

            String dia = datos[2];

            String riesgo;
            int temperatura = tiempo.getTemperatura();
            if(temperatura >= 36){
                riesgo = TiempoRiesgo.HIGH;
            } else if (temperatura < 36 && temperatura >=32) {
                riesgo = TiempoRiesgo.NORMAL;
            } else {
                riesgo = TiempoRiesgo.LOW;
            }

            TiempoRiesgo tiempoRiesgo = new TiempoRiesgo(localidad,fecha,temperatura,anio,mes,dia,
                    riesgo,tiempo);
            return tiempoRiesgo;
        }
    }
}
