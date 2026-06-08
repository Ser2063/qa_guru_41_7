import org.junit.jupiter.api.Test;
import pages.DemocaUiTestsPage;

import static testdata.TestData.*;

public class DemocaUiTests extends TestBase {

    DemocaUiTestsPage democaUiTestsPage = new DemocaUiTestsPage();

    @Test
    void fillingFormFieldsCSS_With_Faker() {

        democaUiTestsPage.openPage();
        democaUiTestsPage.typeFirstName(firstNameF);
        democaUiTestsPage.typeLastName(lastNameF);
        democaUiTestsPage.typeUserEmail(userEmailF);
        democaUiTestsPage.typeUserNumber(userNumberF);
        democaUiTestsPage.setGender(genterWrapperF);

        // Дата рождения
        democaUiTestsPage.setDateOfBirth(daySelectF, monthSelectF, yearSelectF);

        // Предметы
        democaUiTestsPage.typeSubjects(subjectsInputF);

        //Хобби
        democaUiTestsPage.setHobby(hobbiesWrapperF);

        //Адрес
        democaUiTestsPage.typeCurrentAddress(currentAddressF);

        //Картинка
        democaUiTestsPage.setPicture(uploadPicture);

        //штат и город
        democaUiTestsPage.setState(stateF);
        democaUiTestsPage.setCity(cityF);

        //нажимаем кнопку
        democaUiTestsPage.submitForm();

        // Реконсиляция (Проверка по таблице)
        democaUiTestsPage.checkModalVisible()
                .checkResult("Student Name", firstNameF + " " + lastNameF)
                .checkResult("Student Email", userEmailF)
                .checkResult("Gender", genterWrapperF)
                .checkResult("Mobile", userNumberF)
                .checkResult("Date of Birth", daySelectF + " " + monthSelectF + "," + yearSelectF)
                .checkResult("Subjects", subjectsInputF)
                .checkResult("Hobbies", hobbiesWrapperF)
                .checkResult("Picture", uploadPicture)
                .checkResult("Address", currentAddressF)
                .checkResult("State and City", stateF + " " + cityF);

        // Закрытие модального окна
        democaUiTestsPage.closeModal();

    }


    @Test
    void submitEmptyFormTest() {
        democaUiTestsPage.openPage();
        democaUiTestsPage.submitForm();
        democaUiTestsPage.checkModalNotVisible(); // Проверка отсутствия модалки через существующий элемент UI
        democaUiTestsPage.firstNameShouldBeRed(); // Проверка валидации (красная рамка)
    }


    @Test
    void shortMobileNumberTest() {
        democaUiTestsPage.openPage();
        democaUiTestsPage.typeFirstName(firstNameF);
        democaUiTestsPage.typeLastName(lastNameF);
        democaUiTestsPage.setGender(genterWrapperF);
        democaUiTestsPage.typeUserNumber(userNumberNeg);
        democaUiTestsPage.submitForm();
        democaUiTestsPage.checkModalNotVisible();
        democaUiTestsPage.checkUserNumberIsInvalid();
    }


    @Test
    void alphabeticMobileNumberTest() {
        democaUiTestsPage.openPage();
        democaUiTestsPage.typeFirstName(firstNameF);
        democaUiTestsPage.typeLastName(lastNameF);
        democaUiTestsPage.setGender(genterWrapperF);
        democaUiTestsPage.typeUserNumber(userNumberNega);
        democaUiTestsPage.submitForm();
        democaUiTestsPage.checkModalNotVisible();
    }

    @Test
    void missingGenderTest() {
        democaUiTestsPage.openPage();
        democaUiTestsPage.typeFirstName(firstNameF);
        democaUiTestsPage.typeLastName(lastNameF);
        democaUiTestsPage.typeUserNumber(userNumberF); // Пропускаем клик по Gender
        democaUiTestsPage.submitForm();
        democaUiTestsPage.checkModalNotVisible();
    }





}
