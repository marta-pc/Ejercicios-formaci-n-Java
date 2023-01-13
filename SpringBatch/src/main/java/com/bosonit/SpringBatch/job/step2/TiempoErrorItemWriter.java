package com.bosonit.SpringBatch.job.step2;

import com.bosonit.SpringBatch.models.ErrorTemperatura;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.Writer;

//Step2 Writer
public class TiempoErrorItemWriter extends FlatFileItemWriter<ErrorTemperatura> {

    public TiempoErrorItemWriter() {
        setResource(new FileSystemResource("SpringBatch/src/main/resources/registros_erroneos.csv"));
        setAppendAllowed(false);
        setHeaderCallback(new FlatFileHeaderCallback() {
            @Override
            public void writeHeader(Writer writer) throws IOException {
                writer.write("Localidad, Fecha, Temperatura");
            }
        });
        setLineAggregator(new DelimitedLineAggregator<ErrorTemperatura>(){{
            setDelimiter(",");
            setFieldExtractor(new BeanWrapperFieldExtractor<ErrorTemperatura>() {{
                setNames(new String[] {"localidad", "fecha", "temperatura"});
            }});
        }
        });

    }
}
