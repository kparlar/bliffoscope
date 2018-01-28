package com.kparlar.bliffoscope.controller.app;

import com.kparlar.bliffoscope.exception.BliffoscopeException;
import com.kparlar.bliffoscope.model.dto.BliffoscopeDto;
import com.kparlar.bliffoscope.service.TargetService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:8000")
@Controller
@RequestMapping("/api/app/bliffoscope/v1/targets")
public class TargetController {

    private TargetService targetService;

    public TargetController(TargetService targetService){
        this.targetService = targetService;

    }
    @RequestMapping(value = "/{targetType}",headers="content-type=multipart/*", method = RequestMethod.POST)
    @ApiOperation(value = "Get all targets according to given target type", notes = "If any internal error occured, GlobalControllerException " +
            "handler return 500 error with unique id. This method checks given target file in the test data file within a given threshold. If the " +
            "target file occurrences are over given threshold than the x and y coordinates are returned with the percentage of the hit ratio. " +
            "")
    @ApiResponses(value =
            {@ApiResponse(code = 200, message = "Successfully get Consumption between given start and end month period"),
                    @ApiResponse(code = 400, message = "Thrown when Test File is smaller than Target File"),
                    @ApiResponse(code = 404, message = "Thrown when targettype is not StarShip or SlimeTorpedo"),
                    @ApiResponse(code = 500, message = "Thrown when parsing error the Test or Target File")
            })
    public ResponseEntity<BliffoscopeDto> findAll(@PathVariable(value = "targetType") String targetType, @RequestParam(required = true) MultipartFile targetFile, @RequestParam(required = true)MultipartFile testFile, @RequestParam(required = true)Double threshold) throws BliffoscopeException {
        BliffoscopeDto bliffoscopeDto = targetService.compare(targetType, targetFile, testFile, threshold.doubleValue());
        return new ResponseEntity<>(bliffoscopeDto, HttpStatus.OK);
    }
}
