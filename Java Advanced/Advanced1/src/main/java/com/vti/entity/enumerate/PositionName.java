package com.vti.entity.enumerate;

public enum PositionName {
    DEV("Dev"), TEST("Test"), SCRUMMASTER("ScrumMaster"), PM("PM");

    private String code;

    PositionName(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static PositionName of(String code) {
        for (PositionName position : PositionName.values()) {
            if (position.getCode().equals(code)) {
                return position;
            }
        }
        return null;
    }
}
