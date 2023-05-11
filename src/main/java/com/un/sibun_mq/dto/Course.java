package com.un.sibun_mq.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class Course {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String description;
    private Integer price;
    private String beginDate;
    private String endDate;
}
