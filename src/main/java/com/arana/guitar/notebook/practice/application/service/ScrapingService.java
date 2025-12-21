package com.arana.guitar.notebook.practice.application.service;

import com.arana.guitar.notebook.practice.application.dto.Tab;
import com.arana.guitar.notebook.practice.application.dto.TabResponse;
import com.arana.guitar.notebook.practice.domain.scrapers.UGScrapper;
import com.arana.guitar.notebook.practice.infrastructure.config.EnvironmentProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

@Service
public class ScrapingService {
    private final EnvironmentProperties props;

    public ScrapingService( EnvironmentProperties props){
        this.props = props;
    }

    public TabResponse scrap(Tab tab){
        WebDriverManager.chromedriver().setup();

        // no gui
        ChromeOptions options = new ChromeOptions();
        options.setBinary(props.getChromium());
        options.addArguments("--headless");        // headless
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        try {
            final String tabUrl = tab.getUrl();
            if(tabUrl.isBlank()) return new TabResponse.ErrorTabResponse("Url is blank");
            //"https://tabs.ultimate-guitar.com/tab/dreamgirl/teenage-blue-tabs-3131648";

            driver.get(tabUrl);
            String tabContent = new UGScrapper().retrieveTab(driver);

            return new TabResponse.SuccessfulTabResponse
                    ("Successfully retrieved tab", tabContent);

        } catch (Exception e) {
            return new TabResponse.ErrorTabResponse(e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
