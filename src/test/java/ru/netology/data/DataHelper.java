package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class DataHelper {

    private DataHelper() {
    }

    private static Faker faker = new Faker(new Locale("en"));

    public static class cardInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String cvc;

        public cardInfo(String cardNumberApproved, String currentMonth, String currentYear, String owner, String cvc) {
        }

        public static String CardNumberApproved() {
            return "4444444444444441";
        }

        public static String CardNumberDeclined() {
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

        public static String lastMonth() {
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

        public static String lastYear() {
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

        public static cardInfo approvedCard() {
            return new cardInfo(CardNumberApproved(), currentMonth(), currentYear(), owner(), CVC());
        }

        public static cardInfo DeclinedCard() {
            return new cardInfo(CardNumberDeclined(), currentMonth(), currentYear(), owner(), CVC());
        }

        public static cardInfo approvedCardAndLastMonth() {
            return new cardInfo(CardNumberApproved(), lastMonth(), currentYear(), owner(), CVC());
        }

        public static cardInfo approvedCardAndRandomMonth() {
            return new cardInfo(CardNumberApproved(), randomMonth(), currentYear(), owner(), CVC());
        }

        public static cardInfo approvedCardAndLastYear() {
            return new cardInfo(CardNumberApproved(), currentMonth(), lastYear(), owner(), CVC());
        }

        public static cardInfo approvedCardAndRandomYear() {
            return new cardInfo(CardNumberApproved(), currentMonth(), randomYear(), owner(), CVC());
        }

        public static cardInfo approvedCardAndMistakeCVC() {
            return new cardInfo(CardNumberApproved(), currentMonth(), currentYear(), owner(), mistakeCvc());
        }

    }

}
