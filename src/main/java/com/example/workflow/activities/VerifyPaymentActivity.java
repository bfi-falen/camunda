package com.example.workflow.activities;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class VerifyPaymentActivity implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("Running Verify Payment Activity");
        boolean isPaymentReceived = (boolean) delegateExecution.getVariable("paymentReceived");
        log.info("isPaymentReceived: {}", isPaymentReceived);
//        throw new BpmnError("paymentVerificationError", "Hit API Error");
    }
}
