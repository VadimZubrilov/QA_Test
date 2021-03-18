package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class Test2 {
    @Test
    void successfulFillTest() {
        open("https://demoqa.com/automation-practice-form");
        System.out.println("debug");
    }
}