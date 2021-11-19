package com.vti.entity.enumerate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PositionNameConverter implements AttributeConverter<PositionName, String> {

    @Override
    public String convertToDatabaseColumn(PositionName positionName) {
        if (positionName == null) {
            return null;
        }
        return positionName.getCode();
    }

    @Override
    public PositionName convertToEntityAttribute(String code) {
        if (code == null){
            return null;
        }
        return PositionName.of(code);    }
}
