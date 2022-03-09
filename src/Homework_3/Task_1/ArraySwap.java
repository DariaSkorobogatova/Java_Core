package Homework_3.Task_1;

import java.util.Arrays;

public class ArraySwap {
    public static void main(String[] args) {

//       Написать метод, который меняет два элемента массива местами (массив может быть любого
//       ссылочного типа);
        Integer [] arr_1 = { 1, 5, 3, 2, 11 };
        swapArr(arr_1, 0,1);
        System.out.println(Arrays.toString(arr_1));
    }

    public static <T> void swapArr(T[] x, int ind1, int ind2) {
        int m = x.length;
        if (ind1 < m && ind2 < m) {
           T n = x[ind1];
            x[ind1] = x[ind2];
            x[ind2] = n;
        }
        else {
            System.out.println("Неверные индексы, поменять местами элементы массива не удалось");
        }
    }
}
