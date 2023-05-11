package com.un.sibun_mq.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CourseDto {
    private Course course;
    private Long typeId;
}
