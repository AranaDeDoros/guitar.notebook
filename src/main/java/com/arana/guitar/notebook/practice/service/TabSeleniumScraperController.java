package com.arana.guitar.notebook.practice.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scrape")
public class TabSeleniumScraperController {

    @GetMapping("/tab")
    public ResponseEntity<String> scrapeTabWithSelenium() {
        WebDriverManager.chromedriver().setup();

        // Opciones para usar Chrome sin interfaz gráfica
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        options.addArguments("--headless");        // Ejecutar en modo headless
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        try {
            String url = "https://tabs.ultimate-guitar.com/tab/dreamgirl/teenage-blue-tabs-3131648";
            driver.get(url);

            Thread.sleep(3000);

            WebElement preElement = driver.findElement(By.tagName("pre"));
            String tabContent = preElement.getText();

            return ResponseEntity.ok(tabContent);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al hacer scraping con Selenium: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}