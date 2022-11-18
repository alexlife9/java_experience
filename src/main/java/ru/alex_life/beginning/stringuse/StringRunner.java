package ru.alex_life.beginning.stringuse;

/**
 * Математические операторы и составные операторы присваивания
 *
 * @author Alex_life
 * @version 1.0
 * @since 18.11.2022
 */
public class StringRunner {
    public static void main(String[] args) {
        String idea = "I like Java!";
        System.out.println(idea);
        idea += " But I am a newbie. ";
        int year = 2022;
        idea += year;
        System.out.println(idea);
    }
}
