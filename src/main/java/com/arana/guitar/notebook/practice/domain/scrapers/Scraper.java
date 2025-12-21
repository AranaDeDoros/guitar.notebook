package com.arana.guitar.notebook.practice.domain.scrapers;

import org.openqa.selenium.WebDriver;

public interface Scraper {
    String retrieveTab(WebDriver driver);
}
