package com.example.spocktestinghomework.controller;

import com.example.spocktestinghomework.model.dto.DeveloperRequestDto;
import com.example.spocktestinghomework.model.dto.DeveloperResponseDto;
import com.example.spocktestinghomework.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/developers")
public class DeveloperController {

    private final DeveloperService developerService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDeveloper(@RequestBody DeveloperRequestDto dto) {
        developerService.createDeveloper(dto);
    }

    @GetMapping("/{id}")
    public DeveloperResponseDto getDeveloperById(@PathVariable Long id) {
        return developerService.getDeveloperById(id);
    }


    @PatchMapping("/{id}/username")
    public void updateDeveloperUsername(@PathVariable Long id,
                                        @RequestParam(value = "value") String username) {
        developerService.updateDeveloperUsername(id, username);
    }


}
