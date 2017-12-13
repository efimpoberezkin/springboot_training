package com.epam.homework.customstarter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "description")
@Getter
@Setter
public class DescriptionPrinterProperties {

    private String text;
}
