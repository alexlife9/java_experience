package ru.alex_life.collections.arraylist;

import java.util.ArrayList;

/**
 * Видео-курс UDEMY Java для начинающих
 * 20. Всё о классе ArrayList. Методы
 *
 * @author Alex_life
 * @version 1.0
 * @since 10.04.2022
 */
public class ArrayListMethod {
    public static void main(String[] args) {
        // add(DataType element) -> boolean - добавляет новый элемент в конец списка
        // add(int index, DataType element) -> boolean - добавляет новый элемент в вказанный индекс списка, раздвигая его
        ArrayList<String> list = new ArrayList<>();
        list.add("poka");   // 0 index
        list.add("ok");     // 1 index
        list.add("privet"); // 2 index
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
        list.add(1, "hello"); // добавялем элемент на 1 индекс
        for (String s2 : list) {
            System.out.print(s2 + " ");
        }
        System.out.println(list.size()); // показывает кол-во элементов находящихся в АЛ
        //но нельзя добавить сразу на index которого еще нет, например на 5-й, потому что в данном примере size = 4

        // get(int Index) -> DataType
        System.out.println(list.get(1)); //выводим элемент под индексом 3
        System.out.println();

        //set(int Index, DataType element) -> DataType
        //заменяет уже имеющийся элемент на указанном индексе на тот который мы хотим поместить на этот индекс
        list.set(0, "&&&");
        for (String s3 : list) {
            System.out.println(s3 + " "); //видим что элемент на 1 индексе "poka" - затерся
        }
        System.out.println();

        //append - добавляем к элементу что-то еще
        ArrayList<StringBuilder> list3 = new ArrayList<>();
        StringBuilder sb1 = new StringBuilder("sb1");
        StringBuilder sb2 = new StringBuilder("sb2");
        StringBuilder sb3 = new StringBuilder("sb3");
        list3.add(sb1);
        list3.add(sb2);
        list3.add(sb3);
        for (int i = 0; i < list3.size(); i++) {
            list3.get(i).append("!!!");
        }
        for (StringBuilder sb : list3) {
            System.out.print(sb + " ");
        }
        System.out.println();

        //remove(Object element) -> boolean   удаление по значению объекта
        //remove(int index) -> DataType       удаление по индексу
        list3.remove(2); //удаляем "privet"
        for (StringBuilder sb : list3) {
            System.out.print(sb + " ");
        }
        System.out.println();

        list3.remove(sb1); //поскольку это стрингбилдер, надо указать ссылку на объект для корректного удаления
        for (StringBuilder sb : list3) {
            System.out.print(sb + " ");
        }
        System.out.println();
        list.remove("ok"); //удалили "ok" именно по значению Элемента
        for (String s3 : list) {
            System.out.print(s3 + " ");
        }

        //add.All(int index, ArrayList Al) -> boolean    добавляет еще один АЛ (такаго же типа) с указанного индекса
        //list.clear  полностью очищает указанный АЛ

        //indexOf(Object element) -> int   возвращает индекс указанного эелемента (по его значению, например "ок")
        //isEmpty() -> boolean     проверяет не пустой ли АЛ

        //contains(Object element) -> boolean     проверяет есть ли такой элемент в АЛ

    }
}
