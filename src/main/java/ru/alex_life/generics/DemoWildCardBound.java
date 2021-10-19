package ru.alex_life.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Видео-курс Черный пояс.
 * 3. Generics
 * 3.7. Wildcards
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.10.2021
 */
public class DemoWildCardBound {
    public static void main(String[] args) {
        List<? extends Number> list1 = new ArrayList<Integer>(); //Integer расширяется от Number - это bound Wild Card "Ограничение сверху"
        List<? super Number> list2 = new ArrayList<Object>(); // вместо ? можно использовать любой класс,
         // который является суперклассом для Number, например Object - и это будет unbound Wild Card "Ограничение снизу"

        ArrayList<Double> arListDouble = new ArrayList<>();
        arListDouble.add(3.14);
        arListDouble.add(3.15);
        arListDouble.add(3.16);
        System.out.println(summ(arListDouble)); //вызываем метод summ для нашего листа даблов

        ArrayList<Integer> arListInteg = new ArrayList<>();
        arListInteg.add(3);
        arListInteg.add(5);
        arListInteg.add(10);
        System.out.println(summ(arListInteg));
    }
    public static double summ(ArrayList<? extends Number> arrayList) {
        double sum = 0;
        for (Number n : arrayList) {
            sum += n.doubleValue();
        }
        return sum;
    }
}
