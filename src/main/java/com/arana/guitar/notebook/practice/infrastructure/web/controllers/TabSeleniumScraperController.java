package com.arana.guitar.notebook.practice.infrastructure.web.controllers;

import com.arana.guitar.notebook.practice.application.dto.TabRequest;
import com.arana.guitar.notebook.practice.application.dto.TabResponse;
import com.arana.guitar.notebook.practice.application.service.ScrapingService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.coyote.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scrape")
public class TabSeleniumScraperController {

    private final ScrapingService scraper;

    public TabSeleniumScraperController(ScrapingService scraper) {
        this.scraper = scraper;
    }

    @GetMapping("/tab")
    public ResponseEntity<TabResponse> scrapeTabWithSelenium(@RequestBody TabRequest request) {
        var tabResponse = this.scraper.scrap(request.getTab());

        if (tabResponse instanceof TabResponse.ErrorTabResponse error) {
            return ResponseEntity.badRequest().body(error);
        }
        return ResponseEntity.ok(tabResponse);
    }
}