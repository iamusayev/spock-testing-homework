package com.example.spocktestinghomework.mapper;

import com.example.spocktestinghomework.dao.entity.DeveloperEntity;
import com.example.spocktestinghomework.model.dto.DeveloperRequestDto;
import com.example.spocktestinghomework.model.dto.DeveloperResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeveloperMapper {

    DeveloperMapper INSTANCE = Mappers.getMapper(DeveloperMapper.class);


    @Mapping(target = "status", constant = "ACTIVE")
    DeveloperEntity mapRequestDtoToEntity(DeveloperRequestDto dto);


    @Mapping(source = "entity", target = "fullName", qualifiedByName = "concatFirstAndLastName")
    DeveloperResponseDto mapEntityToResponseDto(DeveloperEntity entity);


    @Named(value = "concatFirstAndLastName")
    default String concatFirstAndLastname(DeveloperEntity entity) {
        return entity.getFirstname() + " " + entity.getLastname();
    }
}
