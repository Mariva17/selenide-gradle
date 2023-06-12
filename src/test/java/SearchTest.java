import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {

    @ParameterizedTest
    @MethodSource("searchDataList")
    public void validSearch(String query) {
        open("https://duckduckgo.com/");
        $(byId("search_form_input_homepage")).shouldBe(editable).setValue(query);
        $(byId("search_button_homepage")).click();
        sleep(5000);
        for (SelenideElement title : $$ ("[data-testid='result-title-a']")) {
            title.shouldHave(text(query));
        }

//        $$ ("[data-testid='result-title-a']").shouldHave(CollectionCondition.texts("Java", "Java", "Java", "Java", "Java", "Java", "Java","Java", "Java","Java"));



    }

    static Stream<Arguments> searchDataList() {
        return Stream.of(
                Arguments.arguments("Java"),
                Arguments.arguments("Python"),
                Arguments.arguments("bicycle")
        );
    }

}
