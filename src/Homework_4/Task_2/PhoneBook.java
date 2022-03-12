package Homework_4.Task_2;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBook;
    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }
    //добавить записи в телефонную книгу
    public void add(String name, String phoneNumber) {
        ArrayList<String> phoneNumbers = phoneBook.get(name);
        if(phoneNumbers == null) {
            phoneNumbers = new ArrayList<String>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        } else {
            if(!phoneNumbers.contains(phoneNumber)) phoneNumbers.add(phoneNumber);
        }
    }
    //вывести все телефонные номера, соответствующие имени
    public ArrayList<String> get(String name) {
        return phoneBook.get(name);
    }
}
