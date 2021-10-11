package ru.alex_life.cycles;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 1.6. Шифр строки
 *
 * Если посмотреть в чек после оплаты банковской картой, то там никогда не отражается номер карты полностью -
 * отражаются только последние четыре символа, все остальные зашифрованы.
 * Необходимо реализовать метод, который принимает строку, которую необходимо зашифровать таким образом,
 * чтобы на выходе отражались только 4 последних элемента, все остальные были заменены на #. При этом соблюсти условия:
 * 1. Если входная строка пустая - необходимо вернуть строку "empty";
 * 2. Если входная строка содержит больше 0 и не более 4 символов - метод должен вернуть исходную строку.
 * Для решения используйте StringBuilder и его метод setCharAt().
 *
 * @author Alex_life
 * @version 1.0
 * @since 11.10.2021
 */
public class Cryptography {
    public static String code(String s) {
        if (s.isEmpty()) {
            return "empty";
        }
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < s.length() - 4; i++) {
            if (s.length() <= 4) {
                return s;
                }
            builder.setCharAt(i, '#');
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String c1 = Cryptography.code("4556364607935616"); //is ###########5616
        String c2 = Cryptography.code("1234"); //is 1234
        String c3 = Cryptography.code(""); //is "empty"

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
}
