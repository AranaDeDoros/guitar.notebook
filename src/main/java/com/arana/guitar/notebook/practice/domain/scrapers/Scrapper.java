package com.arana.guitar.notebook.practice.domain.scrapers;

import org.openqa.selenium.WebDriver;

public interface Scrapper {
    String retrieveTab(WebDriver driver);
}
