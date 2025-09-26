package com.arana.guitar.notebook.practice.models.enums;

public enum ProgressEnum {
    BEGINNER(25),
    INTERMEDIATE(50),
    ADVANCED(75),
    FLUENT(100);

    private final int percentage;

    ProgressEnum(int percentage) {
        this.percentage = percentage;
    }

    public int getPercentage() {
        return percentage;
    }
}
