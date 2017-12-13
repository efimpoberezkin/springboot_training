package com.epam.homework.customstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(DescriptionPrinter.class)
@EnableConfigurationProperties(DescriptionPrinterProperties.class)
public class DescriptionPrinterAutoConfiguration {

    @Autowired
    private DescriptionPrinterProperties descriptionControllerProperties;

    @Bean
    @ConditionalOnMissingBean
    public DescriptionConfig descriptionConfig() {
        String text = descriptionControllerProperties.getText() == null
                ? System.getProperty("description.text")
                : descriptionControllerProperties.getText();

        DescriptionConfig descriptionConfig = new DescriptionConfig();
        descriptionConfig.put("text", text);

        return descriptionConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public DescriptionPrinter descriptionPrinter() {
        return new DescriptionPrinter();
    }
}
