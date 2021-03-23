package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class Test1 {

    String name = "Vadim";
    String lasName = "Zubrilov";
    String mail = "test@mail.com";
    String mobile = "5674567456";
    String subjects = "Computer Science";
    String picture = "testjpg.jpg";
    String address = "Penza58";
    String state = "Uttar Pradesh";
    String city = "Agra";

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
        $("#firstName").setValue(name);
        $("#lastName").setValue(lasName);
        $("#userEmail").setValue(mail);
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue(mobile);
        // Выбор даты рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("9");
        $(".react-datepicker__year-select").selectOptionByValue("1991");
        $(".react-datepicker__day.react-datepicker__day--018").click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue(city).pressEnter();
        // скролим страницу чтобы элемент submit стал доступен
        //$("#submit").scrollIntoView(true);
        //$("#submit").click();
        $("#submit").scrollTo().click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(text(name + " " + lasName),
                text(mail),
                text("Male"),
                text(mobile),
                text("18 October,1991"),
                text(subjects),
                text("Sports"),
                text(picture),
                text(address),
                text(state + " " + city));
    }
}