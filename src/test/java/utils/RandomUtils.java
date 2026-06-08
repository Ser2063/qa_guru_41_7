package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

public class RandomUtils {

    static String myState = getRandomState();

    public static void main(String[] args) {
        System.out.println(getRandomFirstName(8));
        System.out.println(getRandomLastName(11 ));
        System.out.println(getRandomEmail(8));
        System.out.println(getRandomNumber(10));
        System.out.println(getRandomInt(111111111, 999999999));
        System.out.println(getRandomPhone());
        System.out.println(getRandomGender());
        System.out.println(getRandomSubject());
        System.out.println(getRandomAddress());
        System.out.println(getRandomPermamentAddress());
        System.out.println(getRandomHobbie());
        System.out.println(getRandomState());
        System.out.println(getRandomCity(myState));

        System.out.println(getRandomFirstNameF());
        System.out.println(getRandomLastNameF());
        System.out.println(getRandomEmailF());
        System.out.println(getRandomNumberF());
        System.out.println(getRandomGenderF());
        System.out.println(getRandomSubjectF());


        // Сначала генерируем месяц и год, чтобы передать их в метод для дня
        String monthSelectF = getRandomCalendarMonth();
        String yearSelectF = getRandomCalendarYear();
        String day = getRandomCalendarDay(monthSelectF, yearSelectF);

        System.out.println(day);
        System.out.println(monthSelectF);
        System.out.println(yearSelectF);
    }



    // Faker

    public static String getRandomAddress() {
        Faker faker = new Faker();
        // Возвращаем сгенерированный адрес напрямую
        return faker.address().fullAddress();
    }

    public static String getRandomPermamentAddress() {
        Faker faker = new Faker();
        // Возвращаем сгенерированный адрес напрямую
        return faker.address().fullAddress();
    }


    public static String getRandomFirstNameF() {
        Faker faker = new Faker();
        // Возвращаем сгенерированный адрес напрямую
        return faker.name().firstName();
    }


    public static String getRandomLastNameF() {
        Faker faker = new Faker();
        // Возвращаем сгенерированный адрес напрямую
        return faker.name().lastName();
    }

    public static String getRandomEmailF() {
        Faker faker = new Faker();
        // Возвращаем сгенерированный адрес напрямую
        return faker.internet().emailAddress();
    }

    public static String getRandomNumberF() {
        Faker faker = new Faker();
        // Возвращаем сгенерированный адрес напрямую
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getRandomGenderF() {
        Faker faker = new Faker();
        // Возвращаем сгенерированный адрес напрямую
        return faker.options().option("Male", "Female", "Other");
    }


    public static String getRandomHobbieF() {
        Faker faker = new Faker();
        // Возвращаем сгенерированный адрес напрямую
        return faker.options().option("Sports", "Reading", "Music");
    }


    public static String getRandomSubjectF() {
        Faker faker = new Faker();
        // Возвращаем сгенерированный адрес напрямую
        return faker.options().option("Maths", "Physics", "Chemistry",
                "Biology", "Computer Science", "English", "Hindi", "History",
                "Geography", "Arts", "Social Studies", "Civics", "Economics", "Commerce");
    }



    //--------------------------------------------------------------

    public static String getRandomFirstName(int length){

        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        Random rnd = new SecureRandom();

        for (int i = 0; i < length; i++) {
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));
        }

        return result.toString();
    }


    public static String getRandomLastName(int length){

        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        SecureRandom rnd = new SecureRandom();

        for (int i = 0; i < length; i++) {
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));
        }

        return result.toString();
    }

    public static String getRandomEmail (int length){

       // return getRandomString(8)+ "@" + getRandomString(8) + ".com";
        return format("%s@%s.com",  getRandomFirstName(8), getRandomFirstName(8));
    }

    public static String getRandomNumber (int length){

        String LETTERS = "0123456789";
        StringBuilder result = new StringBuilder();
        Random rnd = new SecureRandom();

        for (int i = 0; i < length; i++) {
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));
        }

        return result.toString();
    }


    public static int getRandomInt (int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max+1);
    }

     // +3 (263) 345 - 77 - 80
    public static String getRandomPhone (){
       String phoneTemplate = "+%s (%s) %s - %s - %s";
       return format(phoneTemplate,  getRandomInt(1, 9), getRandomInt(111, 999), getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }



    public static String getRandomGender (){
        String[] genders = {"Male", "Female", "Other"};
        int randomIndex = getRandomInt(0, 2);
        return getRandomGenderItemFromStringArray(genders);
    }

    public static String getRandomGenderItemFromStringArray( String[] stringArray){
      int arrayLenght = stringArray.length;
      int randomIndex = getRandomInt(0, arrayLenght - 1);
      return stringArray[randomIndex];
    }

    public static String getRandomSubject (){
        String[] subject = {"Maths", "Physics", "Chemistry", "Biology", "Computer Science", "English", "Hindi", "History", "Geography", "Arts", "Social Studies", "Civics", "Economics", "Commerce"};
        int randomIndex = getRandomInt(0, 13);
        return getRandomGenderItemFromStringArray(subject);
    }

    public static String getRandomCalendarMonth (){
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int randomIndex = getRandomInt(0, 11);
        return getRandomGenderItemFromStringArray(months);
    }

    public static String getRandomCalendarYear (){
        int years  = getRandomInt(1950, 2020);
        return String.valueOf(years);
    }


    public static String getRandomCalendarDay(String month, String yearStr) {
        int year = Integer.parseInt(yearStr);
        int maxDays;

        switch (month) {
            case "February":
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    maxDays = 29;
                } else {
                    maxDays = 28;
                }
                break;
            case "April":
            case "June":
            case "September":
            case "November":
                maxDays = 30;
                break;
            default:
                maxDays = 31;
                break;
        }

        int day = getRandomInt(1, maxDays);
        return (day < 10) ? "0" + day : String.valueOf(day);
    }

    public static String getRandomHobbie(){
        String[] subject = {"Sports", "Reading", "Music"};
        int randomIndex = getRandomInt(0, 2);
        return getRandomGenderItemFromStringArray(subject);
    }


    public static String getRandomState() {
        String[] subject = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        // Переменная randomIndex у вас объявлена, но метод ниже использует весь массив. Оставляем вашу логику:
        int randomIndex = getRandomInt(0, 3);
        return getRandomGenderItemFromStringArray(subject);
    }


    public static String getRandomCity(String state) {

        String[] subject = switch (state) {
            case "NCR" -> new String[]{"Delhi", "Gurgaon", "Noida"};
            case "Uttar Pradesh" -> new String[]{"Agra", "Lucknow", "Meerut"};
            case "Haryana" -> new String[]{"Karnal", "Panipat"};
            case "Rajasthan" -> new String[]{"Jaipur", "Jaiselmer"};
            default -> new String[]{};
        };

        return getRandomGenderItemFromStringArray(subject);
    }
}