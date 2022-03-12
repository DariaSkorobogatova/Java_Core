package Homework_4.Task_2;

public class ManagingPhoneBook {
    public static void main(String[] args) {

        PhoneBook phonebook = new PhoneBook();
        phonebook.add("Rachel Green-Geller", "111-11-11");
        phonebook.add("Monica Geller-Bing", "222-22-22");
        phonebook.add("Monica Geller-Bing", "222-22-23");
        phonebook.add("Phoebe Buffay-Hannigan", "333-33-33");

        System.out.println(phonebook.get("Monica Geller-Bing"));
    }
}
