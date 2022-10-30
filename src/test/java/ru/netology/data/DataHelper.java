package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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

    public static String thirteenthMonth() {
        LocalDate currentMonth = LocalDate.now();
        int between = (12 - currentMonth.getMonthValue()) + 1;
        int month = currentMonth.getMonthValue() + between;
        return String.format("%02d", month);
    }

    public static String zeroMonth() {
        LocalDate currentMonth = LocalDate.now();
        int month = currentMonth.getMonthValue()-currentMonth.getMonthValue();
        return String.format("%02d", month);
    }

    public static String nextMonth() {
        LocalDate currentMonth = LocalDate.now();
        int month = currentMonth.getMonthValue() + 1;
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

    public static String nextYear() {
        LocalDate currentYear = LocalDate.now();
        int year = currentYear.getYear() - 1999;
        return Integer.toString(year);
    }

    public static String moreThenFiveYear() {
        LocalDate currentYear = LocalDate.now();
        int year = currentYear.getYear() - 1994;
        return Integer.toString(year);
    }

    public static String owner() {
        return faker.name().fullName();
    }

    public static String CVC() {
        return faker.number().digits(3);
    }

    public static String wrongCvc() {
        return faker.number().digits(2);
    }

    public static String randomCardNumber() {
        return Long.toString(faker.number().randomNumber(16, true));
    }

    public static cardInfo randomField() {
        return new cardInfo(randomCardNumber(), randomMonth(), currentYear(), owner(), CVC());
    }

    public static cardInfo approvedField() {
        return new cardInfo(cardNumberApproved(), currentMonth(), currentYear(), owner(), CVC());
    }

    public static cardInfo declinedField() {
        return new cardInfo(cardNumberDeclined(), currentMonth(), currentYear(), owner(), CVC());
    }

    public static cardInfo approvedFieldAndNextMonth() {
        return new cardInfo(cardNumberApproved(), nextMonth(), currentYear(), owner(), CVC());
    }

    public static cardInfo approvedFieldAndPastMonth() {
        return new cardInfo(cardNumberApproved(), pastMonth(), currentYear(), owner(), CVC());
    }

    public static cardInfo approvedFieldAndNextYear() {
        return new cardInfo(cardNumberApproved(), currentMonth(), nextYear(), owner(), CVC());
    }

    public static cardInfo approvedFieldAndPastYear() {
        return new cardInfo(cardNumberApproved(), currentMonth(), pastYear(), owner(), CVC());
    }

    public static cardInfo approvedFieldAndWrongCvc() {
        return new cardInfo(cardNumberApproved(), currentMonth(), currentYear(), owner(), wrongCvc());
    }

    public static cardInfo emptyCardField() {
        return new cardInfo("", currentMonth(), currentYear(), owner(), CVC());
    }

    public static cardInfo emptyMonthField() {
        return new cardInfo(cardNumberApproved(), "", currentYear(), owner(), CVC());
    }

    public static cardInfo emptyYearField() {
        return new cardInfo(cardNumberApproved(), currentMonth(), "", owner(), CVC());
    }

    public static cardInfo emptyOwnerField() {
        return new cardInfo(cardNumberApproved(), currentMonth(), currentYear(), "", CVC());
    }

    public static cardInfo emptyCvcField() {
        return new cardInfo(cardNumberApproved(), currentMonth(), currentYear(), owner(), "");
    }

    public static cardInfo emptyFields() {
        return new cardInfo("", "", "", "", "");
    }

    public static cardInfo approvedFieldAndZeroMonth() {
        return new cardInfo(cardNumberApproved(), zeroMonth(), nextYear(), owner(), CVC());
    }

    public static cardInfo approvedFieldAndThirteenthMonth() {
        return new cardInfo(cardNumberApproved(), thirteenthMonth(), currentYear(), owner(), CVC());
    }

    public static cardInfo approvedFieldAndZeroCvc() {
        return new cardInfo(cardNumberApproved(), currentMonth(), currentYear(), owner(), "000");
    }

    public static cardInfo shortCard() {
        return new cardInfo("444444444444444", currentMonth(), currentYear(), owner(), CVC());
    }

    public static cardInfo approvedFieldAndRussiaName() {
        return new cardInfo(cardNumberApproved(), currentMonth(), currentYear(), "Андрей Бородин", CVC());
    }

    public static cardInfo approvedFieldAndMoreThanFiveYear() {
        return new cardInfo(cardNumberApproved(), currentMonth(), moreThenFiveYear(), owner(), CVC());
    }

}

