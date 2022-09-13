package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс.
 * Thread name и Thread priority
 *
 * @author Alex_life
 * @version 1.0
 * @since 13.09.2022
 */
public class Ex5 {
    public static void main(String[] args) {
        MyThread5 myThread5 = new MyThread5();
        System.out.println("Name of myThread5 = " + myThread5.getName()
                + " Priority of myThread5 = " + myThread5.getPriority());


        MyThread5 myThread6 = new MyThread5();
        myThread6.setName("moy_potok6");
        myThread6.setPriority(9); /* сами устанавливаем приоритет */
        myThread6.setPriority(Thread.MIN_PRIORITY); /* установить приоритет = 1 */
        myThread6.setPriority(Thread.NORM_PRIORITY); /* установить приоритет = 5 */
        myThread6.setPriority(Thread.MAX_PRIORITY); /* установить приоритет = 10 */
        System.out.println("Name of myThread6 = " + myThread6.getName()
                + " Priority of myThread6 = " + myThread6.getPriority());
    }

    /* в консоли видим дефолтное имя потока - Thread-0. И дальше по порядку создания -1, -2, 3 и тд.
    * Дефолтный приоритет потока - 5. Наивысший приоритет - 10. Его можно задать вручную как и имя.
    * Но нет никакой гарантии что поток с высшим приоритетом запустится быстрее чем потом с низшим приоритетом
    */
}

class MyThread5 extends Thread {
    public void run() {
        System.out.println("privet");
    }
    /* метод run не надо запускать вручную. вместо этого надо запускать метод start, который под капотом запустит run*/
}
