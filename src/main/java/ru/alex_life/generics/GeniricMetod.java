package ru.alex_life.generics;

import java.util.ArrayList;

/**
 * Видео-курс Черный пояс.
 * 3. Generics
 * 3.3. Parameterized method
 *
 * Параметрезированные методы нужны для написания и использования методов с очень широким выбором типов данных
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2021
 */
public class GeniricMetod {
    /**
     * Создаем метод в параметрах которого ArrayList типа Т с именем al
     * В параметре ArrayList<T> будет просто Т для того чтобы в дальнейшем
     *   его можно было поменять на нужный тип - reUsable помнишь? - и на Стринг и на Интежер
     * @param al
     * @param <T>
     * @return постоянно возвращаем второй элемент нашего листа. Этот элемент будет типа Т.
     * просто Т перед именем метода это Return Type
     * а <T> перед Т означает что мы используем дженерик в данном методе
     */
    public static <T> T getSecondElement(ArrayList<T> al) {
        return al.get(1);

    }
}
