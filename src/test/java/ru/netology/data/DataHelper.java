package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class DataHelper {

    private DataHelper() {
    }

    private static Faker faker = new Faker(new Locale("en"));

    @Value
    public static class cardInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String cvc;
    }

    public static String cardNumberApproved() {
        return "4444444444444441";
    }

    public static String cardNumberDeclined() {
        return "4444444444444442";
    }

    public static String randomMonth() {
        Random random = new Random();
        int i = random.nextInt(10);
        LocalDate DataMonth = LocalDate.now().plusMonths(i);
        int month = DataMonth.getMonthValue();
        return String.format("%02d", month);
    }

    public static String currentMonth() {
        LocalDate currentMonth = LocalDate.now();
        int month = currentMonth.getMonthValue();
        return String.format("%02d", month);
    }

    public static String pastMonth() {
        LocalDate currentMonth = LocalDate.now();
        int month = currentMonth.getMonthValue() - 1;
        return String.format("%02d", month);
    }

    public static String randomYear() {
        Random random = new Random();
        int i = random.nextInt(10);
        LocalDate DataYear = LocalDate.now().plusYears(i);
        int year = DataYear.getYear() - 2000;
        return Integer.toString(year);
    }

    public static String currentYear() {
        LocalDate currentYear = LocalDate.now();
        int year = currentYear.getYear() - 2000;
        return Integer.toString(year);
    }

    public static String pastYear() {
        LocalDate currentYear = LocalDate.now();
        int year = currentYear.getYear() - 2001;
        return Integer.toString(year);
    }

    public static String owner() {
        return faker.name().firstName();
    }

    public static String CVC() {
        return faker.number().digits(3);
    }

    public static String mistakeCvc() {
        return faker.number().digits(2);
    }

    public static String randomCardNumber() {
        return Long.toString(faker.number().randomNumber(16, true));
    }

    public static cardInfo randomField() {
        return new cardInfo(randomCardNumber(), randomMonth(), randomYear(), owner(), CVC());
    }

    public static cardInfo approvedField() {
        return new cardInfo(cardNumberApproved(), randomMonth(), randomYear(), owner(), CVC());
    }

    public static cardInfo declinedField() {
        return new cardInfo(cardNumberDeclined(), randomMonth(), randomYear(), owner(), CVC());
    }

    public static cardInfo approvedFieldAndCurrentMonth() {
        return new cardInfo(cardNumberApproved(), currentMonth(), randomYear(), owner(), CVC());
    }

    public static cardInfo approvedFieldAndPastMonth() {
        return new cardInfo(cardNumberApproved(), pastMonth(), randomYear(), owner(), CVC());
    }

    public static cardInfo approvedFieldAndCurrentYear() {
        return new cardInfo(cardNumberApproved(), randomMonth(), currentYear(), owner(), CVC());
    }

    public static cardInfo approvedFieldAndPastYear() {
        return new cardInfo(cardNumberApproved(), randomMonth(), pastYear(), owner(), CVC());
    }

    public static cardInfo approvedFieldAndMistakeCvc() {
        return new cardInfo(cardNumberApproved(), randomMonth(), randomYear(), owner(), mistakeCvc());
    }

    @Value
    @AllArgsConstructor
    public static class CardInfo {
        ???
    }


}

