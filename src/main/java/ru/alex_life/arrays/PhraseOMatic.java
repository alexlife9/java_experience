package ru.alex_life.arrays;

/**
 * Изучаем Java. Бейтс
 * Генератор фраз на основе массивов
 *
 * @author Alex_life
 * @version 1.0
 * @since 02.12.2021
 */
public class PhraseOMatic {
    public static void main(String[] args) {
        String[] wordListOne = {"круглосуточный", "трёх-звёздный", "30000-футовый", "взаимный",
                "обоюдный выигрыш", "фронтэнд", "на основе веб-технологий", "проникащий", "умный", "шесть сигм",
                "метод критического пути", "динамичный"};
        String[] wordListTwo = {"уполномоченный", "трудный", "чистый продукт", "ориентированный", "центральный",
                "распределённый", "кластеризованный", "фирменный", "нестандартный ум", "позиционированный", "сетевой",
                "сфокусированный", "использованный с выгодой", "выровненный", "нацеленный на", "общий", "совместный", "ускоренный"};
        String[] wordListThree = {"процесс", "пункт загрузки", "выход из положения", "тип структуры", "талант",
                "подход", "уровень завоёванного внимания", "портал", "период времени", "обзор", "образец", "пункт следования"};
        int oneLength = wordListOne.length; //длина массива равна кол-ву слов в нём
        int twoLength = wordListTwo.length;
        int treeLength = wordListThree.length;
        int rand1 = (int) (Math.random() * oneLength); //генерируем три случайных числа и приводим их к инту
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * treeLength);
        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3]; //создаем фразу
        System.out.println("Всё что нам нужно это " + phrase); //выводим ее на экран
    }
}
