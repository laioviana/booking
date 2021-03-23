package com.smarthost.booking.controller;

import com.smarthost.booking.domain.Room;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api("Room Controller")
public interface RoomController {
    @ApiOperation(value = "Optimize occupancy", response = Room[].class)
    @ApiResponses(value = {
            @ApiResponse(code= 200, message = "Successful"),
            @ApiResponse(code= 401, message = "Not Authorized"),
            @ApiResponse(code = 404, message = "Not Found")
    })
/*    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            dataType = "string",
            paramType = "header",
            required = true) })*/
    ResponseEntity<List<Room>> optimizeRooms(Integer roomAvailableEconomy, Integer roomAvailablePremium);
}
