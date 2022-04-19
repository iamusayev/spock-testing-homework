package com.example.jwtsecurityspockframework.service

import com.example.spocktestinghomework.dao.repository.DeveloperRepository
import com.example.spocktestinghomework.exception.NotFoundException
import com.example.spocktestinghomework.service.DeveloperService
import io.github.benas.randombeans.EnhancedRandomBuilder
import spock.lang.Specification

class DeveloperServiceTest extends Specification {

    private random = EnhancedRandomBuilder.aNewEnhancedRandom()

    private DeveloperService service
    private DeveloperRepository repository


    void setup() {
        repository = Mock()
        service = new DeveloperService(repository)
    }

    def "GetDeveloperById success case"() {
        given:
        def id = 1L
        def entity = random.nextObject(DeveloperEntity)

        when:
        def result = service.getDeveloperById(id)

        then:
        1 * repository.findById(id) >> Optional.of(entity)
        result != null;
    }


    def "GetDeveloperById fail case"() {
        given:
        def id = 1L
        def entity = random.nextObject(DeveloperEntity)

        when:
        def result = service.getDeveloperById(id)

        then:
        1 * repository.findById(id) >> Optional.empty()
        NotFoundException ex = thrown()
        ex.message == String.format("Developer with id %s not found", id)
        ex.code == "DEVELOPER_NOT_FOUND"
    }
}
