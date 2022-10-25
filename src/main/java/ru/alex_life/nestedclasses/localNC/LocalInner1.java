package ru.alex_life.nestedclasses.localNC;

/**
 * Local Inner классы
 * Это локальный класс внутри метода или какого-либо блока кода.
 * Local Inner классы не может быть static!
 * Область видимости Local Inner класса - это блок в котором он находится
 * Local Inner класс может обращаться даже к private элементам внешнего класса
 * Local Inner класс может обращаться даже к элементам блока, в котором он написан при условии,
 * что они final или effective final
 *
 * @author Alex_life
 * @version 1.0
 * @since 25.10.2022
 */
public class LocalInner1 {
    public static void main(String[] args) {
        Math math = new Math();
        math.getResult();
    }
}

class Math {
    public void getResult() { /* есть метод для получения результата */

        class Delenie { /* к методе getResult создаем класс Деление */
            private int delimoe;
            private int delitel;

            public int getDelimoe() {
                return delimoe;
            }

            public void setDelimoe(int delimoe) {
                this.delimoe = delimoe;
            }

            public int getDelitel() {
                return delitel;
            }

            public void setDelitel(int delitel) {
                this.delitel = delitel;
            }

            public int getchastnoe() { /* класс Delenie в свою очередь содержит метод chastnoe */
                return delimoe / delitel;
            }

            public int getOstatok() {
                return delimoe % delitel;
            }

        }

        Delenie delenie = new Delenie(); /* содаем объект класса */
        delenie.setDelimoe(21);
        delenie.setDelitel(4);
        System.out.println("Delimoe = " + delenie.getDelimoe());
        System.out.println("Delitel = " + delenie.getDelitel());
        System.out.println("Chastnoe = " + delenie.getchastnoe());
        System.out.println("Ostatok = " + delenie.getOstatok());
    }
}
