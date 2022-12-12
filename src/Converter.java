public class Converter {

    /*Метод для конвертации шагов в километры*/
    double stepsConvertToKm (int steps) {
        return  (steps * 75) / 100000;
    }

    /*Метод для конвертации шагов в килокалории*/
    int stepsToCalories (int steps) {
        return (steps * 50) / 1000;
    }
}
