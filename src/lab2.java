import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;


class lab2 {
    public static void main(String[] args) throws IOException {
        task1();
        task2();
    }

    public static void task1() throws IOException {
      BufferedReader input = new BufferedReader(new    InputStreamReader(System.in));

      System.out.println("Please enter the first number:");
      float number1 = Float.parseFloat(input.readLine());
      System.out.println("Please enter the second number:");
      float number2 = Float.parseFloat(input.readLine());

      //знаходимо суму, різницю та добуткок введених чисел
      float sum  = number1 + number2;
      float difference = number1 - number2;
      float product = number1 * number2;

      float maxValue = Math.max(product, Math.max(sum, difference));

      System.out.println("The largest value among two numbers " +
       "\nsum " + sum +
       "\ndifference " + difference +
       "\nproduct " + product +
       "\nis: " + maxValue);
    }

public static void task2() throws IOException {
    double a,b,c,d;
    PrintStream ps = new PrintStream(System.out, true, "UTF-8");
    new Locale("uk", "UA");

    Scanner scanner = new Scanner(System.in);
    int i=0;
    while(i<7) {
      ps.println("Введіть коефіцієнти нерівності:");

      a = scanner.nextDouble();
      b = scanner.nextDouble();
      c = scanner.nextDouble();
      d = b * b - 4 * c; //дискримінант

      if (d < 0 || d == 0) ps.println("Розв'язок: " +  "( -inf; " + a + ")");
      else {
          double x1 = (-b - Math.sqrt(d))/2;
          double x2 = (-b + Math.sqrt(d))/2;
          if (a > x2) ps.println("Нерівність не має коренів при x є (a; +inf)");
          else {
            if (x1 < a && a < x2) ps.println("Розв'язок: " +  "(" + a + "; " + x2 + ")");
            if (a < x1) ps.println("Розв'язок: " +  "(" + x1 + "; " + x2 + ")");
          }
          if (a < x1) ps.println("Нерівність не має коренів при x є (-inf; a)");
          else {
            if (x1 < a && a < x2) ps.println("Розв'язок: " +  "(" + x1 + "; " + a + ")");
            if (a > x2) ps.println("Розв'язок: " +  "(" + x1 + "; " + x2 + ")");
          }
      }
      i+=1;
    }
}
}


