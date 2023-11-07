package com.task.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.task.service.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTO {

    private Long id;
    @NotNull(message = "title Should not be blank")
    private String title;

    @NotNull(message = "description should not be blank")
    private String description;

    @NotNull(message = "due Date should not be blank")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    @NotNull(message = "status should not be blank")
    private Status status;
}
