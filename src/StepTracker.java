import java.util.Arrays;
import java.util.Scanner;

/*Основной класс, реализующий большенство методов приложения*/
public class StepTracker {

    int[][] monthToData;
    int goalBySteps = 10000;
    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();

    public StepTracker() {
        monthToData = new int[12][30];
        for (int[] row: monthToData) {
        Arrays.fill(row, 0);
        }
    }

    /*Метод сохранения шагов в переданный день, переданного месяца*/
    void saveSteps () {
        System.out.println("Введите месяц:");
        int mouth = scanner.nextInt();
        if (mouth < 0 || mouth > 11) {
            System.out.println("Введите месяц от 0 до 11");
        } else {
            System.out.println("Введите день:");
            int day = scanner.nextInt();
            if(day < 0 || day > 29) {
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
    void monthStats (int mouth) {
        int allMouthSteps = 0;
        int maxMouthSteps = 0;
        int averageMouthSteps = 0;
        int bestStepSeries = 0;

        if (mouth < 0 || mouth > 11) {
            System.out.println("Введите месяц от 0 до 11");
        } else {
            for (int i = 0; i < monthToData[mouth].length; i++){
                allMouthSteps = allMouthSteps + monthToData[mouth][i];
                if(monthToData[mouth][i] > maxMouthSteps) {
                    maxMouthSteps = monthToData[mouth][i];
                }
                if(monthToData[mouth][i] >= goalBySteps) {
                    bestStepSeries++;
                } else {
                    bestStepSeries = 0;
                }
            }
            averageMouthSteps = allMouthSteps / monthToData[mouth].length;
            for (int l = 0; l < monthToData[mouth].length; l++) {
                System.out.print(l + 1 + " День: " + monthToData[mouth][l] + ", ");
            }
            System.out.println("Общее колличество шагов за месяц: " + allMouthSteps);
            System.out.println("Максимальное пройденное количество шагов в месяце: " + maxMouthSteps);
            System.out.println("Среднее количество шагов за месяц: " + averageMouthSteps);
            System.out.println("Пройденная дистанция в км: " + converter.stepsConvertToKm(allMouthSteps));
            System.out.println("Количество сожженых килокалорий: " + converter.stepsToCalories(allMouthSteps));
            System.out.println("Максимальная серия: " + bestStepSeries);
        }
    }

    /*Метод изменения цели по шагам*/
    void changeGoalBySteps() {
        System.out.println("Текущая цель по шагам: " + goalBySteps);
        System.out.println("Введите новую цель");
        goalBySteps = scanner.nextInt();
        while (goalBySteps < 0) {
            System.out.println("Нельзя вводить отрицательное число");
            goalBySteps = scanner.nextInt();
        }
        System.out.println("Цель по шагам изменена на " + goalBySteps);
    }


}
