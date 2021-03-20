package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;




import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class Test2 {

String Name = "Vadim";
String LasName = "Zubrilov";
String mail = "test@mail.com";
String mobile ="5674567456";
String subjects ="Computer Science";
String Picture ="testjpg.jpg";
String Address = "Penza58";
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
        $("#firstName").setValue(Name);
        $("#lastName").setValue(LasName);
        $("#userEmail").setValue(mail);
        // Выбор гендера, обычный .click() не сработал, нужно понять почему сработал .doubleClick();
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue(mobile);
        // Выбор даты рождения
        // selectOptionByValue узнать что это
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("9");
        $(".react-datepicker__year-select").selectOptionByValue("1991");
        $(".react-datepicker__day.react-datepicker__day--018").click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $(byText("Sports")).click();
        //$("#uploadPicture").doubleClick(), понять как работает uploadFromClasspath
        $("#uploadPicture").uploadFromClasspath(Picture);
        $("#currentAddress").setValue(Address);
        $("#state").click();
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue(city).pressEnter();
        sleep(2000);
        //sleep(5000);
        // скролим страницу чтобы элемент submit стал доступен
        $("#submit").scrollIntoView(true);
        $("#submit").click();
        sleep(2000);
        //$("#submit").should(visible, Duration.ofSeconds(5)).click(); совет из чата (не сработал)


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(text(Name + " " + LasName));
        $(".modal-content").shouldHave(text(mail));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text(mobile));
        $(".modal-content").shouldHave(text("18 October,1991"));
        $(".modal-content").shouldHave(text(subjects));
        $(".modal-content").shouldHave(text("Sports"));
        $(".modal-content").shouldHave(text(Picture));
        $(".modal-content").shouldHave(text(Address));
        $(".modal-content").shouldHave(text(state + " " + city));
    }
}