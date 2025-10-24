package com.arana.guitar.notebook.practice.domain.models.enums;

import java.util.Map;
import java.util.HashMap;

public enum ProgressEnum {
    NEW(0),
    BEGINNER(25),
    INTERMEDIATE(50),
    ADVANCED(75),
    FLUENT(100);

    private final int percentage;
    private static final Map<Integer, ProgressEnum> LOOKUP_MAP = new HashMap<>();

    static {
        for (ProgressEnum progress : values()) {
            LOOKUP_MAP.put(progress.percentage, progress);
        }
    }

    ProgressEnum(int percentage) {
        this.percentage = percentage;
    }

    public int getPercentage() {
        return percentage;
    }

    public static ProgressEnum fromPercentage(int percentage) {
        return LOOKUP_MAP.getOrDefault(percentage, NEW); // default = NEW
    }
}
