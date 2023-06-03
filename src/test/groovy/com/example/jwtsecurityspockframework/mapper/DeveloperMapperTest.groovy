package com.example.jwtsecurityspockframework.mapper

import io.github.benas.randombeans.EnhancedRandomBuilder
import spock.lang.Specification

class DeveloperMapperTest extends Specification {

    private random = EnhancedRandomBuilder.aNewEnhancedRandom()

    def "MapRequestDtoToEntity"() {
        given:
        def dto = random.nextObject(DeveloperRequestDto)

        when:
        def entity = DeveloperMapper.INSTANCE
                .mapRequestDtoToEntity(dto)

        then:
        entity.firstname == dto.firstname
        entity.lastname == dto.lastname
        entity.username == dto.username
        entity.age == dto.age
        entity.email == dto.email
        entity.status == Status.ACTIVE
    }

    def "MapEntityToResponseDto"() {
        given:
        def entity = random.nextObject(DeveloperEntity)

        when:
        def dto = DeveloperMapper.INSTANCE
                .mapEntityToResponseDto(entity)

        then:
        dto.username == entity.username
        dto.fullName == entity.firstname + " " + entity.lastname
        dto.age == entity.age
    }

    def "ConcatFirstAndLastname"() {
        given:
        def entity = random.nextObject(DeveloperEntity)

        when:
        def result = DeveloperMapper.INSTANCE.concatFirstAndLastname(entity)

        then:
        result == entity.firstname + " " + entity.lastname
    }
}
