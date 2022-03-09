package Homework_3.Task_2;

import Homework_3.Task_2.Apple;
import Homework_3.Task_2.Box;
import Homework_3.Task_2.Orange;

public class PackingFruits {
    public static void main(String[] args) {

//        a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
//        b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу
//        фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        c. Для хранения фруктов внутри коробки можно использовать ArrayList (ArrayList обсудим
//        на следующем уроке);
//        d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта
//        и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
//        e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую
//        коробку с той, которую подадут в compare() в качестве параметра. true – если их массы
//        равны, false в противоположном случае. Можно сравнивать коробки с яблоками и
//        апельсинами;
//        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
//        Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
//                Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются
//        объекты, которые были в первой;
//        g. Не забываем про метод добавления фрукта в коробку.

        Apple apples = new Apple("apples");
        Orange oranges = new Orange("oranges");
//создать коробки: box с 3 аблоками каждое весом 1.0, box1 с 5 яблоками каждое весом 1.0, box2 с 2 апельсинами каждый весом 1.5
        Box box = new Box(apples, 3);
        Box box1 = new Box(apples, 5);
        Box box2 = new Box(oranges, 2);
//рассчитать вес каждой коробки (box = 3, box1 = 5, box2 = 3)
        System.out.println(box.getWeight());
        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());
//проверить, равен ли вес коробки box весу коробки box2
        if(box.compare(box2)) {
            System.out.println("равны");
        }
        else {
            System.out.println("не равны");
        }
//пересыпать яблоки из коробки box1 в коробку box
        box.join(box1);
//количество фруктов в коробках box и box1
        System.out.println(box.getNumber());
        System.out.println(box1.getNumber());
//добавить фруктов в коробку box2 и вывести новое количество
        box2.addFruit(23);
        System.out.println(box2.getNumber());
    }
}
