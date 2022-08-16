package com.nortal.mega.CustomValidator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nortal.mega.persistence.BuildingRepository;
import com.nortal.mega.persistence.entity.BuildingDbo;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class LessThanOrEqualValidator implements ConstraintValidator<LessThanOrEqual, Object> {

    @Autowired
    private BuildingRepository buildingRepository;


    public void initialize(LessThanOrEqual constraintAnnotation) {
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Integer fieldValue = (Integer) new BeanWrapperImpl(value).getPropertyValue("energyUnits");
        Integer fieldMatchValue = (Integer) new BeanWrapperImpl(value).getPropertyValue("energyUnitMax");

        if (fieldMatchValue == null) {
            Long id = (Long) new BeanWrapperImpl(value).getPropertyValue("id");
            if (id == null) return false;
            BuildingDbo buildingDbo = buildingRepository.findById(id).orElseThrow();
            fieldMatchValue = buildingDbo.getEnergyUnitMax();
        }

        return fieldValue != null && fieldValue <= fieldMatchValue;
    }

}
