package com.arana.guitar.notebook.practice.domain.models;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.arana.guitar.notebook.practice.domain.models.enums.ProgressEnum;

@Converter(autoApply = true)
public class ProgressEnumConverter implements AttributeConverter<ProgressEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ProgressEnum attribute) {
        if (attribute == null) return 0;
        return attribute.getPercentage();
    }

    @Override
    public ProgressEnum convertToEntityAttribute(Integer dbData) {
        if (dbData == null) return ProgressEnum.NEW;
        return ProgressEnum.fromPercentage(dbData);
    }
}
