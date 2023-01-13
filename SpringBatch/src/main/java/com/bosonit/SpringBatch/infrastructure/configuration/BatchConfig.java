package com.bosonit.SpringBatch.infrastructure.configuration;
import com.bosonit.SpringBatch.infrastructure.listener.ErrorStepExecutionListener;
import com.bosonit.SpringBatch.infrastructure.listener.TiempoJobListener;
import com.bosonit.SpringBatch.infrastructure.repository.TiempoRepository;
import com.bosonit.SpringBatch.infrastructure.repository.TiempoRiesgoRepository;
import com.bosonit.SpringBatch.job.step2.TiempoErrorItemProcessor;
import com.bosonit.SpringBatch.job.step1.TiempoItemProcessor;
import com.bosonit.SpringBatch.job.step2.TiempoErrorItemWriter;
import com.bosonit.SpringBatch.job.step1.TiempoItemWriter;
import com.bosonit.SpringBatch.models.ErrorTemperatura;
import com.bosonit.SpringBatch.models.Tiempo;
import com.bosonit.SpringBatch.models.TiempoRiesgo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;
    @Autowired
    TiempoRepository tiempoRepository;
    @Autowired
    TiempoRiesgoRepository tiempoRiesgoRepository;
    @Autowired
    DataSource dataSource;

    //READER Lee el archivo csv
    @Bean
    public FlatFileItemReader<Tiempo> tiempoReader() {
        return new FlatFileItemReaderBuilder<Tiempo>()
                .name("tiempoItemReader")
                .resource(new ClassPathResource("prueba.csv"))
                .linesToSkip(1)
                .delimited()
                .names("localidad","temperatura","fecha")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Tiempo>() {{
                    setTargetType(Tiempo.class);
                }})
                .build();
    }


    // Step1 Processor
    @Bean
    public ItemProcessor tiempoItemProcessor() {
        return new TiempoItemProcessor();
    }

    // Step1 Writer
    @Bean
    public ItemWriter tiempoItemWriter() {
        return new TiempoItemWriter();
    }

    // Step2 Processor
    @Bean
    public ItemProcessor errorProcessor(){ return new TiempoErrorItemProcessor();
    }

    // Step2 Writer
    @Bean
    public ItemWriter errorWriter() { return new TiempoErrorItemWriter();}


    //Listener
//    @Bean
//    public TiempoJobListener jobListener() { return new TiempoJobListener();
//    }

    //Error listener
    @Bean
    public ErrorStepExecutionListener stepExecutionListener() {return new ErrorStepExecutionListener(); }


    // JOB configuration esto es la automatización de los pasos
    @Bean
    public Job job (TiempoJobListener jobExecutionListener,Step step1, Step step2) {
        return jobBuilderFactory.get("job")
                .incrementer(new RunIdIncrementer())
                .listener(jobExecutionListener)
                .flow(step1)
                .next(step2)
                .end()
                .build();
    }

    // Analiza el fichero csv y guarda sus registros en la base de datos
    @Bean
    public Step step1(
            TiempoItemWriter writer,
            TiempoItemProcessor processor) {

        TaskletStep step = stepBuilderFactory.get("step1")
                .<Tiempo, TiempoRiesgo>chunk(100)
                .reader(tiempoReader())
                .processor(processor)
                .writer(writer)
                .build();
        return step;
    }


    //Guarda los errores encontrado en otro fichero csv
    @Bean
    public Step step2(TiempoErrorItemProcessor processor,
                      TiempoErrorItemWriter writer,
                      ErrorStepExecutionListener listener) {

        TaskletStep step = stepBuilderFactory.get("step2")
                .<Tiempo, ErrorTemperatura>chunk(100)
                .reader(tiempoReader())
                .processor(processor)
                .writer(writer)
                .listener(listener)
                .build();
        return step;
    }

}
