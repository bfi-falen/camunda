package com.example.workflow.service;

import com.example.workflow.dto.StartProcessRequest;
import com.example.workflow.dto.StartProcessResponse;
import com.example.workflow.dto.VerifyProcessRequest;

public interface CamundaService {
    StartProcessResponse startProcess(StartProcessRequest request);

    void verifyPayment(VerifyProcessRequest request);
}
