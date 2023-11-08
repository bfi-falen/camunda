package com.example.workflow.service.impl;

import com.example.workflow.dto.StartProcessRequest;
import com.example.workflow.dto.StartProcessResponse;
import com.example.workflow.dto.VerifyProcessRequest;
import com.example.workflow.service.CamundaService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CamundaServiceImpl implements CamundaService {

    private final RuntimeService runtimeService;
    private final TaskService taskService;


    @Override
    public StartProcessResponse startProcess(StartProcessRequest request) {
        ProcessInstance result = runtimeService.startProcessInstanceByKey(request.getProcessName());
        return StartProcessResponse
                .builder()
                .processInstanceId(result.getProcessInstanceId())
                .build();
    }

    @Override
    public void verifyPayment(VerifyProcessRequest request) {
        List<Task> tasks = taskService
                .createTaskQuery()
                .processInstanceId(request.getProcessInstanceId())
                .list();

        for (Task task : tasks) {
            if (task.getTaskDefinitionKey().equals("Activity_Payment")) {
                Map<String, Object> inputForm = new HashMap<>();

                inputForm.put("paymentReceived", request.getIsPayment());
                taskService.complete(task.getId(), inputForm);
            }
        }

    }
}
