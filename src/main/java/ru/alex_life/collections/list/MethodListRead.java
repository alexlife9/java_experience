package ru.alex_life.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Теория. Интерфейс List
 * В этом уроке мы познакомимся со структурой данных – список, который описывается интерфейсом List.
 * В такой структуре в определенной последовательности хранятся элементы одного типа.
 * Очень важная особенность данной структуры – мы всегда можем пронумеровать элементы списка,
 * т.е. проводя аналогию с массивом – у каждого элемента есть свой индекс.
 * Если проводить параллель из жизни – у нас есть, к примеру, склад строительных материалов,
 * на котором пронумерованы стеллажи, и чтобы не бегать по всему складу сотрудники необходимое могут найти по номеру.
 * При этом у нас может быть один и тот же материал, но разного производителя, т.е. одинаковые элементы.
 *
 * Самым важным для работы с коллекциями является набор CRUD – операций которые мы можем с ними сделать
 * (CRUD – сокращение от слов create, read, update and delete).
 * Т.е. нас в первую очередь интересует набор методов, которые объявлены в интерфейсе List<E> и как они работают.
 * Для рассмотрения будем использовать средства обобщенного программирования, т.е. везде используем generics,
 * вместо E в объявлении интерфейса может быть определен любой тип ссылочных данных.
 *
 * @author Alex_life
 * @version 1.0
 * @since 01.11.2021
 */
public class MethodListRead {
    public static void main(String[] args) {
        //READ - Чтение элементов из списка
        //Прочитать элементы из списка можно двумя способами:

        //1. Использование метода get():
        //E get(int index) – метод возвращает элемент, который находится в позиции index в этом списке.
        //Метод может кинуть исключение класса IndexOutOfBoundsException, если будет выполнено условие index < 0 || index > size().
        List<String> rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
        for (int i = 0; i < rsl.size(); i++) {
            System.out.println("Читаем добавленные элементы через get: " + rsl.get(i));
        }
        System.out.println();

        //2. использовать итератор для доступа к элементам.
        //Для того чтобы получить экземпляр итератора в интерфейсе List<E> определены 3 метода:
        //2.1 Iterator<E> iterator() – метод возвращает объект Iterator, который содержит в себе все элементы исходной коллекции.
        List<String> rsl1 = new ArrayList<>();
        rsl1.add("one");
        rsl1.add("two");
        rsl1.add("three");
        Iterator<String> iterator = rsl1.iterator();
        while (iterator.hasNext()) {
            System.out.println("Читаем добавленные элементы через объект Iterator: " + iterator.next());
        }
        System.out.println();

        //2.2 ListIterator<E> listIterator() – возвращает итератор списка для элементов в этом списке.
        List<String> rsl2 = new ArrayList<>();
        rsl2.add("one");
        rsl2.add("two");
        rsl2.add("three");
        ListIterator<String> iterator2 = rsl2.listIterator();
        while (iterator2.hasNext()) {
            System.out.println("Читаем добавленные элементы через объект ListIterator: " + iterator2.next());
        }
        System.out.println();

        //ListIterator<E> listIterator(int index) – возвращает итератор списка для элементов в этом списке,
        // начиная с элемента индекс которого равен index.
        List<String> rsl3 = new ArrayList<>();
        rsl3.add("one");
        rsl3.add("two");
        rsl3.add("three");
        ListIterator<String> iterator3 = rsl3.listIterator(1);
        while (iterator3.hasNext()) {
            System.out.println("Читаем добавленные элементы через объект ListIterator по индексу: " + iterator3.next());
        }
        System.out.println();

        //ListIterator имеет несколько отличий от Iterator:
        //1. ListIterator может использоваться только со списками, т.е. реализациями интерфейса List<E>,
        //тогда как Iterator<E> применим к любым наследникам и реализациям интерфейса Collection<E>.
        //2. ListIterator позволяет перебирать список в обоих направлениях, Iterator<E> только в прямом порядке.
        //3. ListIterator допускает модификацию списка, за счет его дополнительного метода add. Iterator<E> такой возможности не имеет.
    }
}
