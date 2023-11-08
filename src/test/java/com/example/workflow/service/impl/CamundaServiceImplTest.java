package com.example.workflow.service.impl;

import com.example.workflow.dto.StartProcessRequest;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CamundaServiceImplTest {
    @InjectMocks
    private CamundaServiceImpl camundaService;

    @Mock
    private RuntimeService runtimeService;

    @Test
    void startProcessInstanceTest(){
        ProcessInstance processInstance = mock(ProcessInstance.class);
        String processInstanceId = UUID.randomUUID().toString();

        when(runtimeService.startProcessInstanceByKey("demo")).thenReturn(processInstance);
        when(processInstance.getProcessInstanceId()).thenReturn(processInstanceId);

        var result = camundaService.startProcess(StartProcessRequest
                .builder()
                .processName("demo")
                .build());

        assertEquals(processInstanceId, result.getProcessInstanceId());
    }

}
