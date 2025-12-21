package com.arana.guitar.notebook.practice.infrastructure.web.controllers;

import com.arana.guitar.notebook.practice.application.dto.TabRequest;
import com.arana.guitar.notebook.practice.application.dto.TabResponse;
import com.arana.guitar.notebook.practice.application.service.ScrapingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/scrap")
public class TabSeleniumScraperController {

    private final ScrapingService scraperServ;

    public TabSeleniumScraperController(ScrapingService scraper) {
        this.scraperServ = scraper;
    }

    @PostMapping("/tab")
    public CompletableFuture<ResponseEntity<TabResponse>> scrapeTabWithSelenium
            (@Valid @RequestBody TabRequest request) {
        return scraperServ.scrapAsync(request.getTab())
                .thenApply(tabResponse -> {
                    if (tabResponse instanceof TabResponse.ErrorTabResponse error) {
                        return ResponseEntity.badRequest().body(error);
                    }
                    return ResponseEntity.ok(tabResponse);
        });
    }
}