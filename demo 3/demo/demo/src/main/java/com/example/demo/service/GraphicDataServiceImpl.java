package com.example.demo.service;

import com.example.demo.dto.GraphicDataRequestDto;
import com.example.demo.entity.GraphicDataEntity;
import com.example.demo.mapper.GraphicDataMapper;
import com.example.demo.repositiry.GraphicDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class GraphicDataServiceImpl implements GraphicDataService {

    @Autowired
    GraphicDataRepository repository;
    @Autowired
    GraphicDataMapper mapper;

    public void izmenenieGrafikovICheToTam() {
    }

    @Override
    @Transactional
    public void add(GraphicDataRequestDto dto) {
        Optional<GraphicDataEntity> entityOptional = getByTemperature(dto.getTemperature());
        if (entityOptional.isPresent()) {
            log.info("This temperature " + dto.getTemperature() + " already exists i mne sobsna pohuy");
//            GraphicDataEntity entity = entityOptional.get();
//            entity.setTemperature(dto.getTemperature());
//            repository.save(entity);
        } else {
            /// Optional<GraphicData> entityOptional = getByVinNumber(dto.getVinNumber());
            repository.save(mapper.toEntity(dto));
        }
    }
    public static GraphicDataRequestDto getRandomElement(List<GraphicDataRequestDto> list) {
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
    // 1. Генерация пропусков с механизмом MCAR (Missing Completely At Random)
    public List<GraphicDataRequestDto> generateMissingDataMCAR(List<GraphicDataRequestDto> dto, double percentage) {
        double missingCount = Math.ceil(dto.size() * percentage);
        List missingIndexes = new ArrayList<>();

        while (missingIndexes.size() < missingCount) {
            double randomIndex = Math.floor(Math.random() * dto.size());
            if (!missingIndexes.contains(randomIndex)) {
                missingIndexes.add(randomIndex);
                //dto.set(dto.indexOf(getRandomElement(dto)), null);
                GraphicDataRequestDto entity = dto.get(dto.indexOf(getRandomElement(dto)));
                entity.setDate(null);//    getRandomElement(dto).getTemperature();
                repository.saveAll(mapper.toEntity(dto));// или другое значение, обозначающее пропуск
            }
        }
// dto.set(dto.get((int) randomIndex),null) , data[randomIndex] = null
        return dto;
    }


    private Optional<GraphicDataEntity> getByTemperature(double temperature) {
        return repository.getOptionalByTemperature(temperature);
    }
}

