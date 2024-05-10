package ru.kashtanov.coffee_shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.kashtanov.coffee_shop.dto.ArabicaDtoRequest;
import ru.kashtanov.coffee_shop.repository.ArabicaRepository;
import ru.kashtanov.coffee_shop.service.ArabicaService;


@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ArabicaControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArabicaService arabicaService;
    @MockBean
    ArabicaRepository arabicaRepository;


    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }


    @Test
    void getAllArabica() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/coffee/arabica/all"))
                .andExpect(MockMvcResultMatchers.status().isAccepted());

    }

    @Test
    void addNewArabica() throws Exception {
        ArabicaDtoRequest arabicaDtoRequest = new ArabicaDtoRequest("arabica", 2.0);
        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/v1/coffee/arabica/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(arabicaDtoRequest));
        mockMvc.perform(mockRequest)
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }


}

