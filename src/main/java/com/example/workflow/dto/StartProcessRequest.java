package com.example.workflow.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor @AllArgsConstructor
public class StartProcessRequest implements Serializable {

    private static final long serialVersionUID = -2900343717368432750L;

    @NotBlank
    @JsonProperty("process_name")
    private String processName;

}
