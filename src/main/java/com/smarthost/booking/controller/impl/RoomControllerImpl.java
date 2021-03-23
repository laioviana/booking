package com.smarthost.booking.controller.impl;

import com.smarthost.booking.controller.RoomController;
import com.smarthost.booking.domain.OptimizeRequest;
import com.smarthost.booking.domain.OptimizeResponse;
import com.smarthost.booking.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/room")
public class RoomControllerImpl implements RoomController {

    private RoomService roomService;

    @PostMapping("/optimize-rooms")
    public ResponseEntity<OptimizeResponse> optimizeRooms(@RequestBody OptimizeRequest optimizeRequest) {
        return ResponseEntity.ok(roomService.optimizeRooms(optimizeRequest));
    }

}
