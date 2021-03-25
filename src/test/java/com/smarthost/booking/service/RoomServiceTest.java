package com.smarthost.booking.service;

import com.smarthost.booking.domain.OptimizeRequest;
import com.smarthost.booking.domain.OptimizeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RoomServiceTest {

    @Autowired
    RoomService roomService;

    @Test
    void testOptimizeRooms() {
        OptimizeRequest optimizeRequest = new OptimizeRequest();
        optimizeRequest.setPotentialGuests(Arrays.asList(23, 45, 155, 374, 22, 99, 100, 101, 115, 209));
        OptimizeResponse optimizeResponse;
        //TEST 1
        optimizeRequest.setRoomAvailableEconomy(3);
        optimizeRequest.setRoomAvailablePremium(3);
        optimizeResponse = roomService.optimizeRooms(optimizeRequest);
        assertEquals(optimizeResponse.getAmountPaidEconomy(),167);
        assertEquals(optimizeResponse.getAmountPaidPremium(),738);
        assertEquals(optimizeResponse.getUsageEconomy(),3);
        assertEquals(optimizeResponse.getUsagePremium(),3);
        //TEST 2
        optimizeRequest.setRoomAvailableEconomy(5);
        optimizeRequest.setRoomAvailablePremium(7);
        optimizeResponse = roomService.optimizeRooms(optimizeRequest);
        assertEquals(optimizeResponse.getAmountPaidEconomy(),189);
        assertEquals(optimizeResponse.getAmountPaidPremium(),1054);
        assertEquals(optimizeResponse.getUsageEconomy(),4);
        assertEquals(optimizeResponse.getUsagePremium(),6);
        //TEST 3
        optimizeRequest.setRoomAvailableEconomy(7);
        optimizeRequest.setRoomAvailablePremium(2);
        optimizeResponse = roomService.optimizeRooms(optimizeRequest);
        assertEquals(optimizeResponse.getAmountPaidEconomy(),189);
        assertEquals(optimizeResponse.getAmountPaidPremium(),583);
        assertEquals(optimizeResponse.getUsageEconomy(),4);
        assertEquals(optimizeResponse.getUsagePremium(),2);
        //TEST 4
        optimizeRequest.setRoomAvailableEconomy(1);
        optimizeRequest.setRoomAvailablePremium(7);
        optimizeResponse = roomService.optimizeRooms(optimizeRequest);
        assertEquals(optimizeResponse.getAmountPaidEconomy(),45);
        assertEquals(optimizeResponse.getAmountPaidPremium(),1153);
        assertEquals(optimizeResponse.getUsageEconomy(),1);
        assertEquals(optimizeResponse.getUsagePremium(),7);
    }

}