package com.smarthost.booking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smarthost.booking.controller.impl.RoomControllerImpl;
import com.smarthost.booking.domain.OptimizeRequest;
import com.smarthost.booking.service.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RoomControllerImpl.class)
class RoomControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private RoomService roomService;

    @Test
    public void whenValidInput_thenReturns200() throws Exception{
        String uri = "/room/optimize-rooms";
        OptimizeRequest optimizeRequest = new OptimizeRequest();
        optimizeRequest.setPotentialGuests(Arrays.asList(23, 45, 155, 374, 22, 99, 100, 101, 115, 209));
        optimizeRequest.setRoomAvailablePremium(3);
        optimizeRequest.setRoomAvailableEconomy(3);
        mockMvc.perform(post(uri).contentType("application/json").content(objectMapper.writeValueAsString(optimizeRequest))).andExpect(status().isOk());
    }

    @Test
    public void whenNullInput_thenReturns402() throws Exception{
        String uri = "/room/optimize-rooms";
        OptimizeRequest optimizeRequest = new OptimizeRequest();
        mockMvc.perform(post(uri).contentType("application/json").content(objectMapper.writeValueAsString(optimizeRequest))).andExpect(status().isNoContent());
    }

}