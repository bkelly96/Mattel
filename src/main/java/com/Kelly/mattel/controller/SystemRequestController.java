package com.Kelly.mattel.controller;

import com.Kelly.mattel.model.Request;
import com.Kelly.mattel.service.RequestService;
import com.Kelly.mattel.service.Status;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import static org.springframework.http.HttpStatus.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/request")
public class SystemRequestController {

    private final RequestService requestService;

    @GetMapping
    public ResponseEntity<List<Request>> getAllRequests(){
        return new ResponseEntity<List<Request>>(requestService.getAllRequestsFromLastThirtyDays(), OK);
    }

    //create a service to fetch the data to send it to the controller

    @GetMapping("/{id}")
    public ResponseEntity<Request> getRequestById(@PathVariable long id){
        Request request = requestService.getRequestById(id);
        return new ResponseEntity<Request>(requestService.getRequestById(id), OK);

    }

    @PostMapping
    public ResponseEntity createRequest(@RequestBody Request request){
        requestService.createRequest(request);
        return new ResponseEntity(CREATED);
    }

    @PutMapping("/{id}/{status}")
    public ResponseEntity updateStatus(@PathVariable long id, @PathVariable Status status){
        requestService.setStatus(id, status);
        return new ResponseEntity(OK);

    }

}
