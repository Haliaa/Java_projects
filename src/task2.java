public class task2 {
    public static void main(String[] args) {
        double step = 0.5;

        double startOfIterval = -10.0;
        double endOfInterval = 10.0;

        // задання заголовку таблиці
        System.out.printf("%-10s | %-10s\n", "x", "y");
        System.out.println("------------------------");

        for (double x = startOfIterval; x <= endOfInterval; x += step) {
            double p, q, y;

            // Обчислення p (система нерівностей)
            if (x < 0) {
                p = 5 * Math.sin(x);
            } else {
                p = Math.sin(5 * x);
            }

            // Обчислення q (система нерівностей)
            if (x < 5) {
                q = -Math.log10(Math.abs(x)) / Math.log10(5);
            } else {
                q = Math.log10(x) / Math.log10(5);
            }

            y = Math.pow(Math.abs(p), 5) - Math.pow(Math.abs(q), 1.0 / 5);

            // Виведення результату в консоль
            System.out.printf("%-10.2f | %-10.2f\n", x, y);
        }
    }
}
