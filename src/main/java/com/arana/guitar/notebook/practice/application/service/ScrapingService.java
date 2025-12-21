package com.arana.guitar.notebook.practice.application.service;

import com.arana.guitar.notebook.practice.application.dto.Tab;
import com.arana.guitar.notebook.practice.application.dto.TabResponse;
import com.arana.guitar.notebook.practice.domain.scrapers.Scraper;
import com.arana.guitar.notebook.practice.infrastructure.config.EnvironmentProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ScrapingService {
    private final EnvironmentProperties props;
    private final Scraper scraper;

    public ScrapingService(EnvironmentProperties props, Scraper scraper){
        this.props = props;
        this.scraper = scraper;
    }

    @PostConstruct
    void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Async("scraperExecutor")
    public CompletableFuture<TabResponse> scrapAsync(Tab tab) {
        return CompletableFuture.completedFuture(scrap(tab));
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
            String tabContent = scraper.retrieveTab(driver);

            return new TabResponse.SuccessfulTabResponse
                    ("Successfully retrieved tab", tabContent);

        } catch (Exception e) {
            return new TabResponse.ErrorTabResponse(e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
