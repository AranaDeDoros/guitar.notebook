package com.arana.guitar.notebook.practice.domain.scrapers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

//will change once new implementations are created
@Component
public class UGScraper implements Scraper {
    @Override
    public String retrieveTab(WebDriver driver){
        String tabContent = "";
        try {
            Thread.sleep(3000);
            WebElement preElement = driver.findElement(By.tagName("pre"));
            tabContent = preElement.getText();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return tabContent;
    }
}
