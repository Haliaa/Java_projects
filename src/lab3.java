import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;


class lab3 {
  public static void main(String[] args) throws IOException {
    //task1();
    task2();
  }

  public static void task1() throws NumberFormatException, IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintStream ps = new PrintStream(System.out, true, "UTF-8");
    new Locale("uk", "UA");

    //a) з використанням циклу while;
    ps.println("Введіть число N for 'while' cycle");

    try {

      int N =  Integer.parseInt(input.readLine());
      if (N<0) {
        ps.println("Число N має бути натуральним!");
        return;
      }

      float S = 0;
      float A_k = 2;
      int counter = 0;

      ps.println("Отримані суми:");

      while (counter < N) {
        S += A_k;
        System.out.println(S);

        A_k = 2 + 3 / A_k;
        counter++;
      }

      //b) з використанням циклу do;
      ps.println("Введіть число N for 'do while' cycle");
      N = Integer.parseInt(input.readLine());
      if (N<0) {
        ps.println("Число N має бути натуральним!");
        return;
      }
      S = 0;
      A_k = 2;
      counter = 0;
      ps.println("Отримані суми:");

      do {
        S += A_k;
        System.out.println(S);

        A_k = 2 + 3 / A_k;
        counter++;
      }
      while (counter < N);

      //c) з використанням циклу for;
      ps.println("Введіть число N for 'for' cycle");
      N = Integer.parseInt(input.readLine());
      if (N<0) {
        ps.println("Число N має бути натуральним!");
        return;
      }
      S = 0;
      counter = 0;
      ps.println("Отримані суми:");

      for (A_k = 2; counter < N; A_k = 2 + 3 / A_k) {
        S += A_k;
        System.out.println(S);

        counter++;
      }

    }
    catch (NumberFormatException nfe){
      ps.println("Число N має бути натуральним!");
      return;
    }
  }

  public static void task2() throws IOException {
    PrintStream ps = new PrintStream(System.out, true, "UTF-8");
    new Locale("uk", "UA");

    Scanner scanner = new Scanner(System.in);
    double x, u, s = 1, eps = 0.00001;
    System.out.println("Enter x value");
    x = scanner.nextDouble();
        System.out.printf("x", x);

    u = -x/3; int n = 2;

    while(Math.abs(u)>eps) {
      s += u; u *= -x*(3*n+2)/(3*n);
      n++;
    }
    System.out.printf("\nSum value s = %.6f\n", s);
    System.out.printf("Function value: %.6f\n", Math.pow(1+x,-1/3));
    System.out.println("Number of additions " + (n - 1));
  }

}


