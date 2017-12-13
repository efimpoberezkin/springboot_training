package com.epam.homework.customstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(DescriptionControllerPrinter.class)
@EnableConfigurationProperties(DescriptionControllerProperties.class)
public class DescriptionControllerAutoConfiguration {

    @Autowired
    private DescriptionControllerProperties descriptionControllerProperties;

    @Bean
    @ConditionalOnMissingBean
    public DescriptionConfig descriptionConfig() {
        String text = descriptionControllerProperties.getText() == null
                ? System.getProperty("description.text")
                : descriptionControllerProperties.getText();

        String uri = descriptionControllerProperties.getUri() == null
                ? System.getProperty("description.uri")
                : descriptionControllerProperties.getUri();

        DescriptionConfig descriptionConfig = new DescriptionConfig();
        descriptionConfig.put("text", text);
        descriptionConfig.put("uri", uri);

        return descriptionConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public DescriptionControllerPrinter descriptionController() {
        return new DescriptionControllerPrinter();
    }
}
