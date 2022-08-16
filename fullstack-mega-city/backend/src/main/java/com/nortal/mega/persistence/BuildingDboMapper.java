package com.nortal.mega.persistence;

import com.nortal.mega.persistence.entity.BuildingDbo;
import com.nortal.mega.service.Building;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BuildingDboMapper {

    Building map(BuildingDbo dbo);

    BuildingDbo map(Building building);

//    @Mapping(source = "sectorCode", target="sectorCode",
//            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "energyUnitMax", target="energyUnitMax",
//            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BuildingDbo merge(Building entity, @MappingTarget BuildingDbo dbo);
}
