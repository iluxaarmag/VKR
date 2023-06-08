package com.example.demo.controller;

import com.example.demo.dto.GraphicDataRequestDto;
import com.example.demo.entity.GraphicDataEntity;
import com.example.demo.mapper.GraphicDataMapper;
import com.example.demo.repositiry.GraphicDataRepository;
import com.example.demo.service.GraphicDataServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/data")
public class GraphicDataController {

    @Autowired
    GraphicDataRepository repository;
    @Autowired
    GraphicDataMapper mapper;

    @Autowired
    GraphicDataServiceImpl service;

    @Operation(summary = "получение всех записей")
    @GetMapping("/get")
    public List<GraphicDataEntity> getDataList(){
        log.info("method getDataList started and finished with no params ");
        return repository.findAll();
    }

    @Operation(summary = "сохранение новой сущности")
    @PostMapping(value = "/save",produces = "application/json;charset=UTF-8")
    public void saveGraphicData(@RequestBody GraphicDataRequestDto dto){
        service.add(dto);
        log.info("method saveGraphicData finished with params {}",dto);
    }
    @Operation(summary = "генерация пропусков в данных")
    @PostMapping(value = "/generate", produces = "application/json;charset=UTF-8")
    public void generateMissing() {
        List<GraphicDataRequestDto> dto = mapper.toDto(repository.findAll());
        service.generateMissingDataMCAR(dto,0.5);
        log.info("method saveGraphicData finished with params {}", dto);
    }
}
