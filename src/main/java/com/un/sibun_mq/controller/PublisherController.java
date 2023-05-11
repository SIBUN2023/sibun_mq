package com.un.sibun_mq.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.un.sibun_mq.dto.Course;
import com.un.sibun_mq.dto.CourseDto;
import com.un.sibun_mq.dto.ErrorResponse;
import com.un.sibun_mq.mq.RabbitMQPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PublisherController {

    @Autowired
    RabbitMQPublisher rabbitMQPublisher;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody Course course, @RequestParam Long typeId){
        try {
            var courseDto = CourseDto.builder()
                    .course(course)
                    .typeId(typeId)
                    .build();
            var jsonCourseDto = objectMapper.writeValueAsString(courseDto);
            rabbitMQPublisher.publishMessage(jsonCourseDto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(course);
        }catch (Exception e){
            var error = ErrorResponse.builder()
                    .error(e.getMessage())
                    .build();
            return  ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(error);
        }
    }
}
