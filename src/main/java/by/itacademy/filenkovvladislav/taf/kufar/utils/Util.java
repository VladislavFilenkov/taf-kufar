package by.itacademy.filenkovvladislav.taf.kufar.utils;

import com.github.javafaker.Faker;

public class Util {
    public static String correctEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String incorrectEmail() {
        Faker faker = new Faker();
        return faker.toString();
    }

    public static String anyPassword() {
        Faker faker = new Faker();
        return faker.internet().password();
    }
}
