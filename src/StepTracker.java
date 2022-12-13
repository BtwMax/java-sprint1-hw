import java.util.Arrays;
import java.util.Scanner;

/*Основной класс, реализующий большенство методов приложения*/
public class StepTracker {

    int[][] monthToData;
    int goalBySteps = 10000;
    Scanner scanner;
    Converter converter = new Converter();

    public StepTracker(Scanner scanner) {
        this.scanner = scanner;
        monthToData = new int[12][30];
        for (int[] row : monthToData) {
            Arrays.fill(row, 0);
        }
    }

    /*Метод сохранения шагов в переданный день, переданного месяца*/
    void saveSteps() {
        System.out.println("Введите месяц:");
        int mouth = scanner.nextInt();
        if (mouth < 0 || mouth > 11) {
            System.out.println("Введите месяц от 0 до 11");
        } else {
            System.out.println("Введите день:");
            int day = scanner.nextInt();
            if (day < 0 || day > 29) {
                System.out.println("Введите день от 0 до 29");
            } else {
                System.out.println("Введите количество шагов:");
                int steps = scanner.nextInt();
                if (steps < 0) {
                    System.out.println("Нельзя вводить отрицательное число шагов");
                } else {
                    monthToData[mouth][day] = steps;
                    System.out.println("Значение шагов изменено на " + steps + " в " + mouth + " месяце, в " + day + " дне.");
                }
            }
        }
    }

    /*Метод вывода статистики по переданному месяцу*/
    void monthStats() {
        int allMonthSteps = 0;
        int maxMonthSteps = 0;
        int averageMonthSteps = 0;
        int bestStepSeries = 0;
        int maxStepSeries = 0;

        System.out.println("Введите месяц, за который хотите получить статистику:");
        int month = scanner.nextInt();

        if (month < 0 || month > 11) {
            System.out.println("Введите месяц от 0 до 11");
            return;
        }
        for (int i = 0; i < monthToData[month].length; i++) {
            allMonthSteps = allMonthSteps + monthToData[month][i];
            if (monthToData[month][i] > maxMonthSteps) {
                maxMonthSteps = monthToData[month][i];
            }
            if (monthToData[month][i] >= goalBySteps) {
                bestStepSeries++;
                if(bestStepSeries > maxStepSeries) {
                    maxStepSeries = bestStepSeries;
                }
            } else {
                bestStepSeries = 0;
            }
        }
        averageMonthSteps = allMonthSteps / monthToData[month].length;
        for (int l = 0; l < monthToData[month].length - 1; l++) {
            System.out.print(l + 1 + " День: " + monthToData[month][l] + ", ");
        }
        System.out.print("30 День: " + monthToData[month][29] + "\n"); /*Придумал только так вынести последний день месяца*/
        System.out.println("Общее колличество шагов за месяц: " + allMonthSteps);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxMonthSteps);
        System.out.println("Среднее количество шагов за месяц: " + averageMonthSteps);
        System.out.println("Пройденная дистанция в км: " + converter.stepsConvertToKm(allMonthSteps));
        System.out.println("Количество сожженых килокалорий: " + converter.stepsToCalories(allMonthSteps));
        System.out.println("Максимальная серия: " + maxStepSeries);
    }

    /*Метод изменения цели по шагам*/
    void changeGoalBySteps() {
        System.out.println("Текущая цель по шагам: " + goalBySteps);
        System.out.println("Введите новую цель:");
        goalBySteps = scanner.nextInt();
        while (goalBySteps < 0) {
            System.out.println("Нельзя вводить отрицательное число");
            goalBySteps = scanner.nextInt();
        }
        System.out.println("Цель по шагам изменена на " + goalBySteps);
    }
}
