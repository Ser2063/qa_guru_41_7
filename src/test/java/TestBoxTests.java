import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static testdata.TestData.*;

public class TestBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();


    @Test
    void fillFormTest() {
        textBoxPage
                .openPage()
                .typeUserName(firstNameF)
                .typeUserEmail(userEmailF)
                .typeCurrentAddress(currentAddressF)
                .typePublicAddress(permanentAddressF)
                .submitForm()
                .checkField("name", firstNameF)
                .checkField("email", userEmailF)
                .checkField("currentAddress", currentAddressF)
                .checkField("permanentAddress", permanentAddressF);
    }


    // Негативные тесты
    @Test
    void invalidEmailTest() {
        textBoxPage.openPage()
                .typeUserEmail(userEmailNegNotAnEmail) // "not-an-email"
                .submitForm()
                .userEmailInputShouldHaveErrorClass() // Проверяем наличие CSS-класс ошибки у поля
                .userEmailInputShouldNotBeVisible();
    }

    @Test
    void emptyFormSubmitTest() {
        textBoxPage
                .openPage()
                .submitForm()
                .userEmailInputShouldNotBeVisible()
                .outputNameShouldNotExist();
    }

    @Test
    void incompleteEmailTest() {
        textBoxPage
                .openPage()
                .typeUserName(firstNameF)
                .typeUserEmail(userEmailNeg) // sergey@missingdomain Без .ru/.com и т.д.
                .submitForm()
                .userEmailInputShouldHaveErrorClass() // Проверяем наличие CSS-класс ошибки у поля
                .userEmailInputShouldNotBeVisible(); // Проверяем, что блок с результатом не отобразился
    }
}
