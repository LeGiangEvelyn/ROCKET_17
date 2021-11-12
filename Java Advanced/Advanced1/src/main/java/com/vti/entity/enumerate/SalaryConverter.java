package com.vti.entity.enumerate;

import com.vti.entity.enumerate.SalaryName;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class SalaryConverter implements AttributeConverter<SalaryName, String> {

    @Override
    public String convertToDatabaseColumn(SalaryName name) {
        if (name == null) {
            return null;
        }
        return name.getCode();
    }

    //set lambda 8, sysc
    @Override
    public SalaryName convertToEntityAttribute(String code) {
        if (code == null){
            return null;
        }
        return Stream.of(SalaryName.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
