package com.arana.guitar.notebook.practice.domain.scrapers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UGScrapper implements Scrapper {
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
