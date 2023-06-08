package com.example.demo.mapper;

import com.example.demo.dto.GraphicDataRequestDto;
import com.example.demo.entity.GraphicDataEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class GraphicDataMapper {


    @Mapping(target = "id", ignore = true)
    public abstract GraphicDataEntity toEntity(GraphicDataRequestDto dto);
    public abstract List<GraphicDataRequestDto> toDto(List<GraphicDataEntity> dto);
    public abstract List<GraphicDataEntity> toEntity(List<GraphicDataRequestDto> dto);
}
