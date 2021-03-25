package com.smarthost.booking.controller;

import com.smarthost.booking.domain.OptimizeRequest;
import com.smarthost.booking.domain.OptimizeResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api("Room Controller")
public interface RoomController {
    @ApiOperation(value = "Inform number of rooms for each category and potential guest offers", response = OptimizeResponse[].class)
    @ApiResponses(value = {
            @ApiResponse(code= 200, message = "Successful"),
            @ApiResponse(code= 204, message = "No Content"),
            @ApiResponse(code = 500, message = "Internal Error")
    })
    ResponseEntity<OptimizeResponse> optimizeRooms(OptimizeRequest optimizeRequest);
}
