package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;




import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
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
        // Выбор гендера, обычный .click() не сработал, нужно понять почему сработал .doubleClick();
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue("5674567456");
        // Выбор даты рождения
        // selectOptionByValue узнать что это
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("9");
        $(".react-datepicker__year-select").selectOptionByValue("1991");
        $(".react-datepicker__day.react-datepicker__day--018").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $("#uploadPicture").doubleClick();
        $("#uploadPicture").uploadFromClasspath("joka.jpg");

        sleep(5000);
        //sleep(5000);
        // скролим страницу чтобы элемент submit стал доступен
        $("#submit").scrollIntoView(true);
        $("#submit").click();
        sleep(5000);
        //$("#submit").should(visible, Duration.ofSeconds(5)).click(); совет из чата (не сработал)


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
}