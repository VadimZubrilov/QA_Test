package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


public class Test2 {

    @BeforeAll
    // делаем расширения браузера на весь экран
    static void setup() {

        Configuration.startMaximized = true;
    }

    @Test
    void successfulFillTest() {
        // открываем сайт
        open("https://demoqa.com/automation-practice-form");
        //Заполняем поля
        $("#firstName").setValue("Vadim");
        $("#lastName").setValue("Zubrilov");
        $("#userEmail").setValue("test@mail.com");
        $("#submit").click();
        sleep(5000);

        //$("#firstName").shouldHave(text("Vadim"));
    }
}