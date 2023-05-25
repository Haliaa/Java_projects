import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class lab1 {
    public static void main(String[] args) throws IOException {
        task1();
        task2();
    }

    public static void task1() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is your name?");
        String userName = input.readLine();
        System.out.println("Hello, " + userName + "!");

        int now = 2023;
        System.out.println("How old are you?");
        int age = Integer.parseInt(input.readLine());
        System.out.println("You were born in " + (now - age) + " age.");
    }

    public static void task2() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the first distance traveled:");
        float S1 = Float.parseFloat(input.readLine());
        System.out.println("Enter the time (first distance traveled):");
        float t1 = Float.parseFloat(input.readLine());
        System.out.println("Enter the second distance traveled:");
        float S2 = Float.parseFloat(input.readLine());
        System.out.println("Enter the time (second distance traveled):");
        float t2 = Float.parseFloat(input.readLine());

        System.out.println("General pedestrian moment time: " + (t1 + t2) + " h");
        System.out.println("Pedestrian average speed: " + (S1 + S2) / (t1 + t2) + " km/h");
    }
}


