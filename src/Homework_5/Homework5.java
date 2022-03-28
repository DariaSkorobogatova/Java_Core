package Homework_5;

import java.io.*;
import java.util.*;

//1. Реализовать сохранение данных в csv файл;
//2. Реализовать загрузку данных из csv файла. Файл читается целиком.
//        Структура csv файла:
//        | Строка заголовок с набором столбцов |
//        | Набор строк с целочисленными значениями |
//        | * Разделитель между столбцами - символ точка с запятой (;) |
//
//        Пример:
//        Value 1;Value 2;Value 3
//        100;200;123
//        300;400;500
//        Для хранения данных использовать класс вида:
//    public class AppData {
//    private String[] header;
//    private int[][] data;
//
//    // ...
//}

public class Homework5 {

    public static final String CSVtitle = "Value1" + ";" + "Value2" + ";" + "Value3" + ";" + System.getProperty("line.separator");
    public static ArrayList<CSVcontent> CSVcontent = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        fillCSVcontent();
        write();
        AppData appData = readToAppData();
    }
    //создание тела файла
    public static void fillCSVcontent() {
        Random random = new Random();
        for(int i = 1; i< 100; i++){
            CSVcontent.add(new CSVcontent(i, random.nextInt(1000), random.nextInt(1000)));
        }
    }
    //запись заголовка и тела файла в файл .csv
    public static void write() throws IOException {
        try (FileWriter writer = new FileWriter("file.csv")) {
            writer.write(CSVtitle);
            for (CSVcontent content : CSVcontent) {
                writer.write(content.getValue1() + ";" + content.getValue2() + ";" + content.getValue3() + ";" + System.getProperty("line.separator"));
            }
        }
    }
    //загрузка данных из файла .csv
    public static AppData readToAppData() throws IOException {
        AppData appData = new AppData();
        List<List<String>> contentLines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("file.csv"))) {
            String line = br.readLine();
            //заполнение заголовка AppData
            appData.setHeader(line.split(";"));
            //запись тела файла в отдельный массив
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                contentLines.add(Arrays.asList(values));
            }
        }
        int[][] finalData = new int[contentLines.size()][3];

        for (int i = 0; i < contentLines.size(); i++){
            for (int j = 0; j < contentLines.get(i).size(); j++) {
                finalData[i][j] = Integer.valueOf(contentLines.get(i).get(j));
            }
        }
        //заполнение тела AppData
        appData.setData(finalData);
        return appData;
    }
}
