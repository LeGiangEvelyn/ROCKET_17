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
}
