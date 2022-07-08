package ru.alex_life.collections.linkedlist;

/**
 * как работает Linked List - односвязный список
 *
 * @author Alex_life
 * @version 1.0
 * @since 08.07.2022
 */
public class LinkedList<T> {

    private Node<T> head; //голова списка - по сути Нода из элемента и ссылки на следующий элемент

    /**
     * определяем контракт нашего Linked List
     * создаем методы
     */

    public void addFirst(T t) { //добавляет элементы в начало (в голову) списка
        Node<T> firstNode = new Node<>(t); //создаем объект и передаем в него значение элемента t
        firstNode.next = head; //ссылку на следующий элемент приравниваем к ссылке на голову
        head = firstNode; //и теперь элемент который хранится в голове будет равен новому объекту
    }

    public void addLast(T t) { //добавляет элементы в конец (в хвост) списка
        if (head == null) { //если голова null, значит элементов нет
            head = new Node<>(t); //поэтому создаем новый элемент и суем его в голову
            return;
        }
        Node<T> currentNode = head; //если же элементы уже были, то создаем локальную переменную currentNode и сохраняем в нее значение головы
        while (currentNode.next != null) { // и пока наша переменная (с сохраненным значением) не перестанет ссылаться на null (что будет означать конец списка
            currentNode = currentNode.next; //мы будем идти дальше по списку по всем элементам
        }
        currentNode.next = new Node<>(t); //после того как следующая ссылка будет равно null - записываем вместо null новую ноду с элементом t
    }

    public int get(T t) { //ищем элемент по значению и возвращаем псевдоиндекс нашего элемента
        if (head == null) { //если в голове null, то элементов нет
            return -1; // и возвращаем условный -1
        }
        if (head.value == t) { //если значение элемента головы равно элементу который мы ищем, то
            return 0; //то возвращем индекс 0, потому что элемент является первым
        }
        Node<T> currentNode = head; //если два условия выше не выполнились то создаем новую ноду и сохраняем в нее значение головной ноды
        int rsl = 0; //создаем переменную-счетчик нашего индекса
        while (currentNode.next != null) { //и пока следующая ссылка не станет равной null
            rsl++; //увеличиваем индекс
            if (currentNode.next.value == t) { //если значение после следующей ссылки на элемент будет равно искомому
                return rsl; //то возвращаем получившийся итоговый индекс
            }
            currentNode = currentNode.next; //а если этого не произшло - передвигаем указаетель дальше по списку и повторяем цикл
        }
        return -1; //и если в итоге всё равно не нашли искомое значение, то возвращаем условный -1
    }

    public void remove(T t) { //ищем и удаляем элемент по значению
        if (head == null) { //если в голове пусто, то и удалять нечего
            return;
        }
        Node<T> currentNode = head; //если голова не пустая, то записываем значение головы в нашу переменную
        while (currentNode.next != null) { //и идем по списку пока следующая ссылка не станет равной null
            if (currentNode.next.value == t) { //и в случае если значение элемента совпадет с искомым
                currentNode.next = currentNode.next.next; //переводим указатель на следующий элемент
                return;
            }
            currentNode = currentNode.next; //передвигаемся на следующую ноду
        }
    }

    @Override
    public String toString() {
        return "LinkedList{"
                + "head=" + head
                + '}';
    }

    /**
     * Linked List состоит из Нод
     * каждая нода содержит элемент и ссылку на следующий элемент
     * @param <T>
     */
    private static class Node<T> {
        private final T value; //текущий элемент
        private Node<T> next; //ссылка на следующий элемент

        private Node(T value) { //конструктор ноды
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{"
                    + "value=" + value
                    + ", next=" + next
                    + '}';
        }
    }

    public static void main(String[] args) {
        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.addLast("B");
        stringLinkedList.addLast("C");
        stringLinkedList.addLast("D");
        stringLinkedList.addLast("E");
        System.out.println(stringLinkedList);

        stringLinkedList.addFirst("A");
        System.out.println(stringLinkedList);

        System.out.println("индекс элемента В - " + stringLinkedList.get("B"));
        System.out.println("индекс элемента X - " + stringLinkedList.get("X"));

        stringLinkedList.remove("C");
        System.out.println(stringLinkedList);
    }

}
