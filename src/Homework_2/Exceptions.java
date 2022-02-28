package Homework_2;

/*  1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
    2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
    3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException, и вывести результат расчета.
*/

public class Exceptions {

    public static void main(String[] args) {
        String [][] initialArray = {{"6","2","3","1"}, {"7","0","1","7"}, {"9","1","2","3"}, {"6","3","3","1"}};
//      String [][] initialArray = {{"6","2","3","1"}, {"7","0","1","bar"}, {"8","1","2","3"}, {"6","3","10","1"}};
//      String[][] initialArray = {{"8", "1"}, {"1", "2"}, {"7", "0"}};
//      String[][] initialArray = {{"8", "1", "7", "0"}, {"1", "2"}, {"7", "0"}, {"2", "3"}};
        try {
            System.out.println(sumStringArray(initialArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int sumStringArray(String[][] initialArray) throws MyArraySizeException, MyArrayDataException {
        if (initialArray.length != 4) {
            throw new MyArraySizeException("Первое измерение массива не равно 4");
        } else {
            for (int i = 0; i < initialArray.length; i++) {
                if (initialArray[i].length != 4) {
                    throw new MyArraySizeException("Второе измерение массива не равно 4");
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < initialArray.length; i++) {
            for (int j = 0; j < initialArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(initialArray[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException("Преобразовать данные в ячейке (" + (i + 1) + ";" + (j + 1) + "): " + initialArray[i][j] + " в число не удалось");
                }
            }
        }
        return sum;
    }
}




