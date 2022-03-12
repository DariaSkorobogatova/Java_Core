package Homework_4.Task_1;

import java.util.HashMap;

public class Task1 {
    public static void main(String[] args) {
        // 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово
        String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "January", "February", "March", "April"};
        HashMap<String, Integer> items = new HashMap<>();
        for (int i = 0; i < months.length; i++) {
            if (items.get(months[i]) == null) {
                items.put(months[i], 1);
            }
            else  {
                items.put(months[i], items.get(months[i]) + 1);
            }
        }
        //Пересчитать все слова
        for (HashMap.Entry<String, Integer> item : items.entrySet()) {
            System.out.print(item.getKey() + ": " + item.getValue() + "; ");
        }
        //Вывести все уникальные слова
        System.out.println();
        System.out.println("Уникальные слова:");
        for (HashMap.Entry<String, Integer> item : items.entrySet()) {
            if (item.getValue() == 1) {
                System.out.println(item.getKey());
            }
        }
    }
}
