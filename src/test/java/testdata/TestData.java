package testdata;

import static utils.RandomUtils.*;

public class TestData {

    public static String userEmailNeg = "sergey@missingdomain"; // Неправльная почта для негативного теста
    public static String userEmailNegNotAnEmail = "not-an-email"; // Неправльная почта для негативного теста
    public static String userNumberNeg = "123456789"; //короткий номер
    public static String userNumberNega = "abcdefghij"; //буквы вместо цифр
    public static String uploadPicture = "img.png";


    //Faker

    public static String userEmailF = getRandomEmailF(); // Правильная почта
    public static String currentAddressF = getRandomAddress();
    public static String permanentAddressF = getRandomPermamentAddress();
    public static String firstNameF = getRandomFirstNameF();
    public static String lastNameF = getRandomLastNameF();
    public static String userNumberF = getRandomNumberF();
    public static String genterWrapperF = getRandomGenderF();
    public static String monthSelectF = getRandomCalendarMonth();
    public static String yearSelectF = getRandomCalendarYear();
    public static String daySelectF = getRandomCalendarDay(monthSelectF, yearSelectF);
    public static String subjectsInputF = getRandomSubjectF();
    public static String hobbiesWrapperF = getRandomHobbieF();
    public static String stateF = getRandomState();
    public static String cityF = (getRandomCity(stateF));

    }
