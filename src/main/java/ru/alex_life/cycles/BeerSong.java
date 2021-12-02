package ru.alex_life.cycles;

/**
 * Изучаем Java. Бейтс
 * Песенка про 99 бутылок пива
 * Корректное написание бутылки при разных числительных
 *
 * @author Alex_life
 * @version 1.0
 * @since 02.12.2021
 */
public class BeerSong {

    public static void main(String[] args)  {
        int beerNum = 99;
        String word = "бутылок";
        while (beerNum > 0) {
            System.out.println(beerNum + " " + word + " пива на стене.");
            System.out.println(beerNum + " " + word + " пива.");
            System.out.println("Возьми одну. Пусти её по кругу.");
            beerNum--;

            if ((beerNum % 10) > 1 && (beerNum % 10) < 5) {
                word = "бутылки";
            }

            if ((beerNum % 10) == 1) {
                word = "бутылка";
            }

            if (((beerNum % 10) >= 5) || ((beerNum % 10) == 0) || (beerNum > 10 && beerNum < 20)) {
                word = "бутылок";
            }

            if (beerNum > 0) {
                System.out.println(beerNum + " " + word + " пива на стене осталось.");
                System.out.println();
            } else {
                System.out.println("Нет бутылок пива на стене.");
            }
        }
    }
}
