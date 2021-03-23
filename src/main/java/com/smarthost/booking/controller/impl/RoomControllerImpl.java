package com.smarthost.booking.controller.impl;

import com.smarthost.booking.controller.RoomController;
import com.smarthost.booking.domain.Room;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/room")
public class RoomControllerImpl implements RoomController {

    @GetMapping("/optimize-rooms/{roomAvailableEconomy}/{roomAvailablePremium}")
    public ResponseEntity<List<Room>> optimizeRooms(@PathVariable Integer roomAvailableEconomy, @PathVariable Integer roomAvailablePremium) {
        return ResponseEntity.ok(new ArrayList<>());
    }

}
