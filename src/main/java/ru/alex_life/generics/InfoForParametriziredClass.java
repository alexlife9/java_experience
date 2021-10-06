package ru.alex_life.generics;

/**
 * Видео-курс Черный пояс.
 * 3. Generics
 * 3.2. Parameterized class
 *
 * Изучаем для чего в классе нужны дженерики с параметрами
 *
 * @author Alex_life
 * @version 1.0
 * @since 04.10.2021
 */
public class InfoForParametriziredClass<T> {

    private T value; //переменная value типа Т. Тип Т может быть заменен на множество других типов.

    public InfoForParametriziredClass(T value) { //создали конструктор
        this.value = value;
    }

    @Override
    public String toString() { //в метод можно запихать возврат не сгенерированный по-умолчанию, а другой шаблон.
//        return "InfoForParametriziredClass{" +
//                "value=" + value +
//                '}';
        return "{{{[[[" + value + "]]]}}}"; // напрмиер такой
    }

    public T getValue() {
        return value;
    }
}
