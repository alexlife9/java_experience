package ru.alex_life;

/**
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2021
 */
public class Test {
    public static void main(String[] args) {
        String s1 = new String("Privet");
        String s2 = new String("Privet");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
