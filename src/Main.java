import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        printMenu();

        while (true) {
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                stepTracker.saveSteps();
            } else if (userInput == 2) {
                stepTracker.monthStats();
            } else if (userInput == 3) {
                stepTracker.changeGoalBySteps();
            } else if (userInput == 4) {
                break;
            } else
                System.out.println("Данная команда не поддерживается");
            printMenu();
        }
        System.out.println("Программа завершена");
    }

    /*Метод показывающий меню приложения*/
    private static void printMenu() {
        System.out.println("1. Ввести количество шагов за определенный день");
        System.out.println("2. Напечатать статистику за определенный месяц");
        System.out.println("3. Изменить цель по колличеству шагов");
        System.out.println("4. Выйти из приложения");
    }
}
