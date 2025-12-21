package com.arana.guitar.notebook.practice.domain.models.enums;

public enum TabSource {
    // temporal
    GUITAR_ULTIMATE("https://tabs.ultimate-guitar.com/tab/");
    // define more as you need 'em

    private final String source;

    TabSource(String source) {
        this.source = source;
    }
}
