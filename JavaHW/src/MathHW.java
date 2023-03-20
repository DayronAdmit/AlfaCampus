public class MathHW {
    public static void main(String[] args) {
        int sideAOfTriangle = 30;
        int sideBOfTriangle = 60;
        int angleBetweenAB = 45;
        int radius = 6;
        int maxRandomValue = 100;
        int areaOfTriangle = calcAreaOfTriangle(sideAOfTriangle, sideBOfTriangle, angleBetweenAB);
        System.out.printf("Площадь треугольника со сторонами %d и %d и углом %d градусов равна %d; %n",
                Integer.valueOf(sideAOfTriangle), Integer.valueOf(sideBOfTriangle),
                Integer.valueOf(angleBetweenAB), areaOfTriangle);
        System.out.printf("Площадь круга с радиусом %d равна %d; %n", Integer.valueOf(radius), calcAreaOfCircle(radius));
        System.out.printf("Случайное целое число от 0 до %d: %d. %n", Integer.valueOf(maxRandomValue),
                (int) Math.round((double) maxRandomValue * Math.random()));

        int[][] matrix = new int[5][5];
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                matrix[i][j] = (int) Math.round(9 * Math.random());
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

    }

    public static double degreesToRadians(int degrees) {
        return (double) degrees * Math.PI / 180;
    }

    public static int calcAreaOfTriangle(int sideA, int sideB, int angle) {
        return (int) Math.round(0.5 * (double) sideA * (double) sideB * Math.sin(Math.toRadians((double) angle)));
    }

    public static int calcAreaOfCircle(int radius) {
        return (int) Math.round(Math.PI * Math.pow((double) radius, 2));
    }
}
