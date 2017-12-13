package com.epam.homework.springboot.controller;

import com.epam.homework.customstarter.DescriptionPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${description.uri}")
public class DescriptionController {

    @Autowired
    private DescriptionPrinter descriptionPrinter;

    @GetMapping
    public String getDescription() {
        return descriptionPrinter.getDescription();
    }
}
