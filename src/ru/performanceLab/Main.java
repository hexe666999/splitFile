package ru.performanceLab;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Введено неправильное количество аргументов.");
        } else {
            splitFile(new File(args[0]), args[1], Integer.parseInt(args[2]));
        }
    }

    private static void splitFile (File file, String fileName, int rawCount) {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            for (int countFiles = 0; ; countFiles++ ){
                System.out.println("Запись файла №" + countFiles + ".");
                String name = fileName + countFiles + ".txt";
                try (FileWriter writer = new FileWriter(name, true)) {
                    for (int i = 0; i < rawCount; i++) {
                        if ((line = reader.readLine()) != null) {
                            writer.write(line + " \r\n");
                        } else {
                            System.out.println("Запись закончена");
                            return;
                        }
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}