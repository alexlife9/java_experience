package ru.alex_life.cycles;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 1.7. Симметричное число
 *
 * Метод принимает целочисленное значение. Необходимо проверить является ли оно симметричным или нет.
 * Симметричным считается число которое в котором числа идущие по порядку в прямом и обратном порядке равны друг другу.
 * Для решения можете преобразовать число в строку. Проходите по полученной строке в цикле до середины
 * и сравниваете символ который стоит на первой позиции с символом на последней,
 * второй позиции с символом на предпоследней и т.д.
 * Для извлечения символов используйте метод charAt().
 * Метод должен вернуть true, если число симметричное.
 *
 * @author Alex_life
 * @version 1.0
 * @since 11.10.2021
 */
public class Symmetry {
    public static boolean check(int i) {
        String str = Integer.toString(i);
        for (int x = 0; x < str.length() / 2; x++) {
            if (str.charAt(x) != str.charAt(str.length() - 1 - x)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean s1 = Symmetry.check(1112111);
        boolean s2 = Symmetry.check(11122111);
        boolean s3 = Symmetry.check(123421);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
