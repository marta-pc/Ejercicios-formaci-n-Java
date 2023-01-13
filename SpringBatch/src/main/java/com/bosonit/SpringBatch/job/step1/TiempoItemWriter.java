package com.bosonit.SpringBatch.job.step1;

import com.bosonit.SpringBatch.infrastructure.repository.TiempoRiesgoRepository;
import com.bosonit.SpringBatch.models.TiempoRiesgo;
import org.springframework.batch.item.ItemWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//Step1 Writer
@Slf4j
public class TiempoItemWriter implements ItemWriter<TiempoRiesgo> {

    @Autowired
    private TiempoRiesgoRepository tiempoRiesgoRepository;


    @Override
    public void write(List<? extends TiempoRiesgo> list) {
        log.info("Registros recibido de tiempos : {}", list.size());
            tiempoRiesgoRepository.saveAll(list);

    }

}

