package com.github.vitmonk.freemarker.enums;

public enum MyEnum {

    FIRST(1), SECOND(2);

    private Integer number;

    MyEnum(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
