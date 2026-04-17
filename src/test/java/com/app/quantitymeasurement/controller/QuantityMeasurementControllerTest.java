package com.app.quantitymeasurement.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.security.oauth2.client.autoconfigure.OAuth2ClientAutoConfiguration;
import org.springframework.boot.security.oauth2.client.autoconfigure.servlet.OAuth2ClientWebSecurityAutoConfiguration;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.app.quantitymeasurement.dto.QuantityDTO;
import com.app.quantitymeasurement.dto.QuantityInputDTO;
import com.app.quantitymeasurement.dto.QuantityMeasurementDTO;
import com.app.quantitymeasurement.filters.JWTFilter;
import com.app.quantitymeasurement.service.IQuantityMeasurementService;
import com.app.quantitymeasurement.service.JWTService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(
    controllers = QuantityMeasurementController.class,
    excludeAutoConfiguration = {
        OAuth2ClientAutoConfiguration.class,
        OAuth2ClientWebSecurityAutoConfiguration.class
    }
)
@AutoConfigureMockMvc(addFilters = false)
class QuantityMeasurementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IQuantityMeasurementService service;

    @MockitoBean
    private JWTService jwtService;

    @MockitoBean
    private UserDetailsService userDetailsService;

    @MockitoBean
    private JWTFilter jwtFilter;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private QuantityInputDTO quantity1;
    private QuantityMeasurementDTO measurementResult;

    @BeforeEach
    void setUp() {
        quantity1 = new QuantityInputDTO();
        quantity1.setThisQuantityDTO(new QuantityDTO(1.0, "FEET", "LengthUnit"));
        quantity1.setThatQuantityDTO(new QuantityDTO(12.0, "INCHES", "LengthUnit"));

        measurementResult = new QuantityMeasurementDTO();
        measurementResult.setThisValue(quantity1.getThisQuantityDTO().getValue());
        measurementResult.setThisUnit(quantity1.getThisQuantityDTO().getUnit());
        measurementResult.setThisMeasurementType(quantity1.getThisQuantityDTO().getMeasurementType());
        measurementResult.setThatValue(quantity1.getThatQuantityDTO().getValue());
        measurementResult.setThatUnit(quantity1.getThatQuantityDTO().getUnit());
        measurementResult.setThatMeasurementType(quantity1.getThatQuantityDTO().getMeasurementType());
    }

    @Test
    void testCompareQuantities_Success() throws Exception {
        measurementResult.setOperation("Compare");
        measurementResult.setResultString("true");
        measurementResult.setResultValue(0.0);
        measurementResult.setResultUnit(null);
        measurementResult.setResultMeasurementType(null);
        measurementResult.error = false;

        Mockito.when(service.compare(
                quantity1.getThisQuantityDTO(),
                quantity1.getThatQuantityDTO()))
                .thenReturn(measurementResult);

        mockMvc.perform(post("/api/v1/quantities/compare")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(quantity1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.resultString").value("true"));
    }

    @Test
    void testAddQuantities_Success() throws Exception {
        measurementResult.setOperation("add");
        measurementResult.setResultValue(2.0);
        measurementResult.setResultUnit("FEET");
        measurementResult.setResultMeasurementType("LengthUnit");
        measurementResult.error = false;

        Mockito.when(service.add(
                quantity1.getThisQuantityDTO(),
                quantity1.getThatQuantityDTO()))
                .thenReturn(measurementResult);

        mockMvc.perform(post("/api/v1/quantities/add")
                        .param("targetUnit", "FEET")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(quantity1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.resultValue").value(2.0));
    }

    @Test
    void testGetOperationHistory_Success() throws Exception {
        Mockito.when(service.getOperationHistory("COMPARE"))
                .thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/v1/quantities/history/operation/COMPARE")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    void testGetOperationCount_Success() throws Exception {
        Mockito.when(service.getOperationCount("COMPARE")).thenReturn(0L);

        mockMvc.perform(get("/api/v1/quantities/count/COMPARE")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }
}