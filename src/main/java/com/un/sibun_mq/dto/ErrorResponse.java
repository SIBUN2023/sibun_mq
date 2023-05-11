package com.un.sibun_mq.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class ErrorResponse {
    String error;
}

