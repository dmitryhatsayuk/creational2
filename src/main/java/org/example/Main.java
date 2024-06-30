package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        int listSize = 0;
        int maxValue = 0;
        int filterKey = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        while (listSize <= 0) {
            System.out.print("Введите размер списка:");
            listSize = scanner.nextInt();
            if (listSize <= 0) {
                System.out.println("Введен некорректный размер списка");
                logger.log("Пользователь ввел не корректный размер списка:" + listSize);
            }
        }
        //int listSize = scanner.nextInt();
        logger.log("Пользователь ввел размер списка:" + listSize);

        while (maxValue <= 0) {
            System.out.print("Введите верхнюю границу для значений:");
            maxValue = scanner.nextInt();
            if (maxValue <= 0) {
                System.out.println("Введена некорректная верхняя границу");
                logger.log("Пользователь ввел не корректную верхнюю границу:" + maxValue);
            }
        }
        logger.log("Пользователь ввел верхнюю границу значений:" + maxValue);

        while (filterKey <= 0 || filterKey > maxValue) {
            System.out.print("Введите порог для фильтра:");
            filterKey = scanner.nextInt();
            if (filterKey <= 0 || filterKey > maxValue) {
                System.out.println("Введен некорректный порог для фильтра:");
                logger.log("Пользователь ввел не корректный порог для фильтра::" + filterKey);
            }
        }
        logger.log("Пользователь ввел порог для фильтра:" + filterKey);


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(maxValue));
        }
        logger.log("Создан изначальный список:" + list);
        Filter filter = new Filter(filterKey);
        list = filter.filterOut(list);
        logger.log("Выводим результат:");
        System.out.println(list);
        logger.log("Завершаем программу");
    }
}