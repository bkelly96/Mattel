package com.Kelly.mattel.service;

import com.Kelly.mattel.exception.RequestNotFoundException;
import com.Kelly.mattel.model.Request;
import com.Kelly.mattel.repository.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.Period;
import java.util.List;

@Service
@AllArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;;

    public List<Request> getAllRequestsFromLastThirtyDays(){
        //return requestRepository.findAllWithDateBefore();
        return requestRepository.findAllByPending();
    }

    public Request getRequestById(long id){
        return requestRepository.findById(id).orElseThrow(() -> new RequestNotFoundException("No Request found with id + " + id));

    }
    public void createRequest(Request request){
        request.setCreatedAt(Instant.now());
        requestRepository.save(request);
    }

    public void setStatus(long id, Status status){
        requestRepository.findById(id).map(request -> {
            request.setStatus(status);
            return requestRepository.save(request);
        }).orElseThrow(() -> new RequestNotFoundException("No Request found with id + " + id)); ;
    }

}
