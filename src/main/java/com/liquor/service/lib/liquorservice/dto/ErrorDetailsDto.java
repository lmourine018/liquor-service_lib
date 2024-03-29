package com.liquor.service.lib.liquorservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetailsDto {

    private Date timestamp;
    private String message;
    private String description;
}