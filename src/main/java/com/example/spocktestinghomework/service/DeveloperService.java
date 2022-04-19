package com.example.spocktestinghomework.service;

import com.example.spocktestinghomework.dao.entity.DeveloperEntity;
import com.example.spocktestinghomework.dao.repository.DeveloperRepository;
import com.example.spocktestinghomework.exception.NotFoundException;
import com.example.spocktestinghomework.mapper.DeveloperMapper;
import com.example.spocktestinghomework.model.constants.ExceptionConstants;
import com.example.spocktestinghomework.model.dto.DeveloperRequestDto;
import com.example.spocktestinghomework.model.dto.DeveloperResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.spocktestinghomework.model.constants.ExceptionConstants.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class DeveloperService {

    private final DeveloperRepository developerRepository;


    public void createDeveloper(DeveloperRequestDto dto) {
        log.info("ActionLog.createDeveloper.start");

        var entity = DeveloperMapper.INSTANCE
                .mapRequestDtoToEntity(dto);
        developerRepository.save(entity);

        log.info("ActionLog.createDeveloper.success");
    }

    public DeveloperResponseDto getDeveloperById(Long id) {
        log.info("ActionLog.getDeveloperById.start id: {}", id);

        var responseDto = DeveloperMapper.INSTANCE
                .mapEntityToResponseDto(fetchDeveloperIfExist(id));

        log.info("ActionLog.getDeveloperById.success id: {}", id);
        return responseDto;
    }


    public DeveloperEntity updateDeveloperUsername(Long id, String username) {
        log.info("ActionLog.updateDeveloperUsername.start id: {} ", id);

        var entity = fetchDeveloperIfExist(id);
        entity.setUsername(username);

        log.info("ActionLog.updateDeveloperUsername.success id: {}", id);
        return developerRepository.save(entity);
    }


        private DeveloperEntity fetchDeveloperIfExist(Long id) {
            return developerRepository.findById(id).orElseThrow(() -> {
                log.error("ActionLog.fetchDeveloperIfExist.error id: {}", id);
                throw new NotFoundException(String.format(String.format(DEVELOPER_NOT_FOUND_MESSAGE, id), id),
                        DEVELOPER_NOT_FOUND_CODE);
            });
        }


}
