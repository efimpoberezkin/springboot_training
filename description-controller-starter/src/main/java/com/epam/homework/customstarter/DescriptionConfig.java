package com.epam.homework.customstarter;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@NoArgsConstructor
public class DescriptionConfig {

    private HashMap<String, String> configMap = new HashMap<>();

    public void put(String key, String value) {
        configMap.put(key, value);
    }
}
