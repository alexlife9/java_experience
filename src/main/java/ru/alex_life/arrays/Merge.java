package ru.alex_life.arrays;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 0.3. Объединить два отсортированных массива
 *
 * Даны два отсортированных по возрастанию массива. Как без сортировки их объединить в третий массив?
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.10.2021
 */
public class Merge {

    public static int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length]; //создаем новый массив, равный сумме длин 2 начальных массивов
        int leftIndex = 0, rightIndex = 0; //создаем начальные индексы двух начальных массивов
        for (int i = 0; i < rsl.length; i++) { //проходим циклом по всему созданному массиву
            if (leftIndex > left.length - 1) { //сравниваем текущий индекс левого массива с его длиной
                rsl[i] = right[rightIndex]; //если он больше, то записываем значение ячейки в итоговый массив
                rightIndex++; //и переходим на следущий индекс правого начального массива
            } else if (rightIndex > right.length - 1) { //сравниваем текущий индекс правого массива с его длиной
                rsl[i] = left[leftIndex]; //если он больше, то записываем значение ячейки в итоговый массив
                leftIndex++; //и переходим на следущий индекс левого начального массива
            } else if (left[leftIndex] < right[rightIndex]) { //если значение ячейки левого массива меньше значения ячейки правого массива,
                rsl[i] = left[leftIndex]; //то записываем в итоговый массив это значение ячейки левого массива
                leftIndex++; //и переходим на следущий индекс левого начального массива
            } else { //иначе вариантов больше нет - значение текущей ячейки правого массива больше левой -
                rsl[i] = right[rightIndex]; //поэтому записываем в итоговый массив значение ячейки правого массива
                rightIndex++; // и переходим на следущий индекс правого начального массива
            }
        }
        return rsl;
    }
}