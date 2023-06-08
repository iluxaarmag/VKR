package com.example.demo.mapper;

import com.example.demo.dto.GraphicDataRequestDto;
import com.example.demo.entity.GraphicDataEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-07T21:07:50+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.19 (Amazon.com Inc.)"
)
@Component
public class GraphicDataMapperImpl extends GraphicDataMapper {

    @Override
    public GraphicDataEntity toEntity(GraphicDataRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        GraphicDataEntity graphicDataEntity = new GraphicDataEntity();

        graphicDataEntity.setTemperature( dto.getTemperature() );
        graphicDataEntity.setDate( dto.getDate() );

        return graphicDataEntity;
    }

    @Override
    public List<GraphicDataRequestDto> toDto(List<GraphicDataEntity> dto) {
        if ( dto == null ) {
            return null;
        }

        List<GraphicDataRequestDto> list = new ArrayList<GraphicDataRequestDto>( dto.size() );
        for ( GraphicDataEntity graphicDataEntity : dto ) {
            list.add( graphicDataEntityToGraphicDataRequestDto( graphicDataEntity ) );
        }

        return list;
    }

    @Override
    public List<GraphicDataEntity> toEntity(List<GraphicDataRequestDto> dto) {
        if ( dto == null ) {
            return null;
        }

        List<GraphicDataEntity> list = new ArrayList<GraphicDataEntity>( dto.size() );
        for ( GraphicDataRequestDto graphicDataRequestDto : dto ) {
            list.add( toEntity( graphicDataRequestDto ) );
        }

        return list;
    }

    protected GraphicDataRequestDto graphicDataEntityToGraphicDataRequestDto(GraphicDataEntity graphicDataEntity) {
        if ( graphicDataEntity == null ) {
            return null;
        }

        GraphicDataRequestDto graphicDataRequestDto = new GraphicDataRequestDto();

        graphicDataRequestDto.setDate( graphicDataEntity.getDate() );
        graphicDataRequestDto.setTemperature( graphicDataEntity.getTemperature() );

        return graphicDataRequestDto;
    }
}
