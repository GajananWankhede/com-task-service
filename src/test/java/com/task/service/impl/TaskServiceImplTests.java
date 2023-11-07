package com.task.service.impl;

import com.task.service.assembler.TaskAssembler;
import com.task.service.dto.RequestResponse;
import com.task.service.dto.TaskDTO;
import com.task.service.entity.Status;
import com.task.service.entity.TaskEntity;
import com.task.service.exception.TaskNotFoundException;
import com.task.service.repository.TaskRepository;
import com.task.service.service.TaskService;
import com.task.service.service.impl.TaskServiceImpl;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TaskServiceImplTests {

    @InjectMocks
    TaskService taskService = new TaskServiceImpl();

    @Mock
    TaskAssembler taskAssembler;
    @Mock
    TaskRepository taskRepository;

    @Test
    public void createTask_Test() {

        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(12L);
        taskEntity.setTitle("JAVA");
        taskEntity.setStatus(Status.valueOf("OPEN"));
        taskEntity.setDescription("Write Junit test cases");

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(12L);
        taskDTO.setTitle("JAVA");
        taskDTO.setDescription("Write Junit test cases");
        taskDTO.setStatus(Status.valueOf("OPEN"));

        when(taskAssembler.convertToEntity(taskDTO)).thenReturn(taskEntity);
        when(taskRepository.save(taskEntity)).thenReturn(null);
        RequestResponse requestResponse = taskService.createTask(taskDTO);
        assertNotEquals(requestResponse.getMessage(), nullValue());
        assertEquals(requestResponse.getStatus(), "P");
    }

    @Test
    public void getTaskById_Test() {

        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(12L);
        taskEntity.setTitle("JAVA");
        taskEntity.setStatus(Status.valueOf("OPEN"));
        taskEntity.setDescription("Write Junit test cases");

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(12L);
        taskDTO.setTitle("JAVA");
        taskDTO.setDescription("Write Junit test cases");
        taskDTO.setStatus(Status.valueOf("OPEN"));

        when(taskAssembler.convertToEntity(taskDTO)).thenReturn(taskEntity);
        when(taskRepository.findById(12L)).thenReturn(Optional.of(taskEntity));

        RequestResponse requestResponse = taskService.getTaskById(12L);
        assertNotEquals(requestResponse.getMessage(), nullValue());
        assertEquals(requestResponse.getStatus(), "P");
    }



}
