package com.vti.entity.enumerate;

public enum SalaryName {
    DEV("600"), TEST("700"), SCRUMMASTER("1500"), PM("2000");

    private String code;

    SalaryName(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static SalaryName toEnum(String sqlCode) {
        for (SalaryName item : SalaryName.values()) {
            if (item.getCode().equals(sqlCode)) {
                return item;
            }
        }
        return null;
    }
}
