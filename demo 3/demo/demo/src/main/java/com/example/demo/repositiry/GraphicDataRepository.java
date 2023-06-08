package com.example.demo.repositiry;

import com.example.demo.entity.GraphicDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GraphicDataRepository extends JpaRepository<GraphicDataEntity, Long> {

    Optional<GraphicDataEntity> getOptionalByTemperature(double temperature);
    @Override
    List<GraphicDataEntity> findAll();

}
