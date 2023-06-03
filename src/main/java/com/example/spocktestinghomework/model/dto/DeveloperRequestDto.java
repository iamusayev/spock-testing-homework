package com.example.spocktestinghomework.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeveloperRequestDto {


    private String firstname;
    private String lastname;
    private String username;
    private Integer age;
    private String email;

}
