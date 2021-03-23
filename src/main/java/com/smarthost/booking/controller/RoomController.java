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
    @ApiOperation(value = "Optimize occupancy", response = OptimizeResponse[].class)
    @ApiResponses(value = {
            @ApiResponse(code= 200, message = "Successful"),
            @ApiResponse(code= 401, message = "Not Authorized"),
            @ApiResponse(code = 404, message = "Not Found")
    })
/*    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            dataType = "string",
            paramType = "header",
            required = true) })*/
    ResponseEntity<OptimizeResponse> optimizeRooms(OptimizeRequest optimizeRequest);
}
