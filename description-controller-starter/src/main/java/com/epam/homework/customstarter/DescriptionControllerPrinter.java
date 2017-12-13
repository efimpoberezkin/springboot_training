package com.epam.homework.customstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${description.uri}")
public class DescriptionControllerPrinter {

    @Autowired
    private Environment environment;

    @GetMapping
    public String getDescription() {
        return environment.getProperty("description.text");
    }
}
