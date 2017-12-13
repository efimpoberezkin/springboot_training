package com.epam.homework.customstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class DescriptionPrinter {

    @Autowired
    private Environment environment;

    public String getDescription() {
        return environment.getProperty("description.text");
    }
}
