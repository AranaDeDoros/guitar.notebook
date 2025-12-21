package com.arana.guitar.notebook.practice.infrastructure.web.controllers;

import com.arana.guitar.notebook.practice.application.dto.TabRequest;
import com.arana.guitar.notebook.practice.application.dto.TabResponse;
import com.arana.guitar.notebook.practice.application.service.ScrapingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scrape")
public class TabSeleniumScraperController {

    private final ScrapingService scraperServ;

    public TabSeleniumScraperController(ScrapingService scraper) {
        this.scraperServ = scraper;
    }

    @GetMapping("/tab")
    public ResponseEntity<TabResponse> scrapeTabWithSelenium
            (@Valid @RequestBody TabRequest request) {
        var tabResponse = this.scraperServ.scrap(request.getTab());

        if (tabResponse instanceof TabResponse.ErrorTabResponse error) {
            return ResponseEntity.badRequest().body(error);
        }
        return ResponseEntity.ok(tabResponse);
    }
}