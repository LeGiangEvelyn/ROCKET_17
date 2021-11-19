package com.vti.entity.enumerate;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SalaryConverter implements AttributeConverter<SalaryName, String> {

    @Override
    public String convertToDatabaseColumn(SalaryName name) {
        if (name == null) {
            return null;
        }
        return name.getCode();
    }

    //convert from String to Enum
    @Override
    public SalaryName convertToEntityAttribute(String code) {
        if (code == null){
            return null;
        }
        return SalaryName.toEnum(code);
    }
}
