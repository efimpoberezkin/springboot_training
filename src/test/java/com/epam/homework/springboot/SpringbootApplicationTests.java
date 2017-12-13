package com.epam.homework.springboot;

import com.epam.homework.springboot.domain.Airplane;
import com.epam.homework.springboot.domain.PassengerContactInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringbootApplicationTests {

    @Autowired
    private Environment environment;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAirplaneAdd() throws Exception {
        String modelNumber = "Boeing747";
        int capacity = 175;

        Airplane airplane = new Airplane();
        airplane.setModelNumber(modelNumber);
        airplane.setCapacity(capacity);

        mockMvc.perform(post(environment.getProperty("airplanes.uri"))
                .content(asJsonString(airplane))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.modelNumber", is(modelNumber)))
                .andExpect(jsonPath("$.capacity", is(capacity)));
    }

    @Test
    public void testFlightDelete() throws Exception {
        mockMvc.perform(delete(environment.getProperty("flights.uri") + "/3"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testPassengerContactInfoUpdate() throws Exception {
        int id = 5;
        String email = "Jaimes new email";
        String phone = "Jaimes new phone";

        PassengerContactInfo passengerContactInfo = new PassengerContactInfo();
        passengerContactInfo.setId(((long) id));
        passengerContactInfo.setEmail(email);
        passengerContactInfo.setPhone(phone);

        mockMvc.perform(put(environment.getProperty("passengerinfo.uri"))
                .content(asJsonString(passengerContactInfo))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id)))
                .andExpect(jsonPath("$.email", is(email)))
                .andExpect(jsonPath("$.phone", is(phone)));
    }

    @Test
    public void testPassengerGet() throws Exception {
        mockMvc.perform(get(environment.getProperty("passengers.uri") + "/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.name", is("Logan")))
                .andExpect(jsonPath("$.gender", is("MALE")))
                .andExpect(jsonPath("$.contactInfo.id", is(3)))
                .andExpect(jsonPath("$.contactInfo.email", is("Logans email")))
                .andExpect(jsonPath("$.contactInfo.phone", is("Logans phone")));
    }

    @Test
    public void testPassengerGetAll() throws Exception {
        mockMvc.perform(get(environment.getProperty("passengers.uri")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", is(9)));
    }

    @Test
    public void testPassengerGetByGender() throws Exception {
        mockMvc.perform(get(environment.getProperty("passengers.uri") + "/gender/FEMALE"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("[*].id", containsInAnyOrder(2, 6, 7, 8)));
    }

    @Test
    public void testFlightGetByFromLocAndToLoc() throws Exception {
        mockMvc.perform(get(environment.getProperty("flights.uri") + "/from/A/to/B"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("[*].id", containsInAnyOrder(1, 4)));
    }

    private String asJsonString(Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
