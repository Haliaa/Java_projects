import java.util.Random;

public class task3 {
    public static void main(String[] args) {
        //Оголошення масиву
        Random rand = new Random();
        int[] A = new int[10];
        int sum = 0;

        for(int i = 0; i < 10; i++) {
            // Генеруємо двоцифрові числа випадковим чином
            A[i] = rand.nextInt(90) + 10; 
            sum += A[i];

            System.out.println("A[" + i + "] = " + A[i]);
        }
        //обчислення Середнього значення
        double avg = (double)sum / 10;
        System.out.println("Середнє значення: " + avg);
    }
}
