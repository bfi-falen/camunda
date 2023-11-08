package com.example.workflow.controllers;

import com.example.workflow.dto.StartProcessRequest;
import com.example.workflow.dto.StartProcessResponse;
import com.example.workflow.dto.VerifyProcessRequest;
import com.example.workflow.service.CamundaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/camunda")
public class CamundaController {

    private final CamundaService camundaService;

    @PostMapping("/start")
    @ResponseStatus(HttpStatus.OK)
    StartProcessResponse startProcessInstance(@Valid @RequestBody StartProcessRequest request){
        return camundaService.startProcess(request);
    }

    @PostMapping("/verify")
    @ResponseStatus(HttpStatus.OK)
    void verifyProcess(@Valid @RequestBody VerifyProcessRequest request){
        camundaService.verifyPayment(request);
    }
}
