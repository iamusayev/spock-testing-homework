package com.example.spocktestinghomework.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeveloperResponseDto {


    private String fullName;
    private Integer age;
    private String username;


}
