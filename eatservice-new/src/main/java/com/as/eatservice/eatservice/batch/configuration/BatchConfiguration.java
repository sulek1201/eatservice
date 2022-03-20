package com.as.eatservice.eatservice.batch.configuration;


import com.as.eatservice.eatservice.batch.processor.FoodOrdersProcessor;
import com.as.eatservice.eatservice.batch.reader.FoodOrdersReader;
import com.as.eatservice.eatservice.batch.writer.FoodOrderWriter;
import com.as.eatservice.eatservice.model.FoodOrder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {


    @Autowired
    private JobNotificationListener jobNotificationListener;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job foodOrderBatchJob() {
        return jobBuilderFactory.get("foodOrderBatchJob")
                .incrementer(new RunIdIncrementer())
                .listener(jobNotificationListener)
                .flow(foodOrderBatchStep())
                .end()
                .build();
    }
    @Bean
    public Step foodOrderBatchStep() {
        return stepBuilderFactory.get("foodOrderBatchStep").<List<FoodOrder>, List<FoodOrder>>chunk(1)
                .reader(fooodOrderReader())
                .processor(fooodOrderProcessor())
                .writer(fooodOrderWriter())
                .throttleLimit(1)
                .build();
    }

    @Bean
    public ItemReader<List<FoodOrder>> fooodOrderReader() {
        return new FoodOrdersReader();
    }

    @Bean
    public ItemProcessor<List<FoodOrder>, List<FoodOrder>> fooodOrderProcessor() {
        return new FoodOrdersProcessor();
    }

    @Bean
    public ItemWriter<List<FoodOrder>> fooodOrderWriter() {
        return new FoodOrderWriter();
    }

    @Bean
    public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(JobRegistry jobRegistry) {
        JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
        jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry);
        return jobRegistryBeanPostProcessor;
    }
}
