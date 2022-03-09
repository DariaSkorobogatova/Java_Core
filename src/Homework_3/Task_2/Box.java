package Homework_3.Task_2;

public class Box<T extends Fruit>{
    private T fruit;
    private int number;

    public Box(T fruit, int number) {
        this.fruit = fruit;
        this.number = number;
    }

    public float getWeight () {
        return this.fruit.weight * this.number;
    }
    public boolean compare (Box<?> a) {
        if (this.getWeight() == a.getWeight()) return true;
        return false;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void join (Box<T> another) {
        if (this.fruit == another.fruit) {
            this.setNumber(this.getNumber() + another.getNumber());
            another.setNumber(0);
        }
        else {
            System.out.println("Нельзя смешивать фрукты");
        }
    }

    public void addFruit(int number) {
        this.number += number;
    }

}
