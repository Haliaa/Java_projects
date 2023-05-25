import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;

class lab4 {
  public static void main(String[] args) throws IOException {
    task1();
    task2();
  }

  public static void printArray(double[] ar){
    String s="";
    for(int i=0; i<ar.length;i++)s+=(ar[i]+", ");
      System.out.println(s);
  }

  public static float searchInArray(double[] ar){
    float k =0;
    for(int i=0; i<ar.length;i++)
      if(ar[i]<0)k += ar[i];
    return k;
  }

  public static void sortArray(double[] ar) {
    for(int k=0; k<ar.length-1; k++) {
      double min = ar[k];
      int iMin = k;

      for (int i = k; i < ar.length; i++) {
        if (min > ar[i]) {
          min = ar[i];
          iMin = i;
        }
      }

      for (int i = iMin; i > k; i--) ar[i] = ar[i - 1];
      ar[k] = min;
    }
  }

  public static int factorial(int n){
  if (n == 0)
    return 1;
  else
    return(n * factorial(n-1));
 }

  public static void task1() throws IOException {
    PrintStream ps = new PrintStream(System.out, true, "UTF-8");
    new Locale("uk", "UA");

    double[] a = {2.1,0.4,0.1,-0.5,0.6,7.1,-2.4,-1.3,-0.7,-9};
    double b[] = new double[10];
    double c[] = new double[10];

    for(int i=0; i<10;i++) b[i]=i*Math.sin(2*i)/factorial(i+1);
    for(int i=0; i<10;i++) c[i] = 2*a[i]+b[i];

    ps.println("Початкові масиви");
    ps.println("Масив а: "); printArray(a);
    ps.println("Масив b: "); printArray(b);
    ps.println("Масив c: "); printArray(c);

    ps.println("Сортовані масиви");
    sortArray(a);
    sortArray(b);
    sortArray(c);

    ps.println("Масив а: "); printArray(a);
    ps.println("Масив b: "); printArray(b);
    ps.println("Масив c: "); printArray(c);

    ps.println("Сума від’ємних елементів масивів");
    ps.println("Масив а: " + searchInArray(a));
    ps.println("Масив b: " + searchInArray(b));
    ps.println("Масив c: " + searchInArray(c));
  }

  public static void task2() throws IOException {
    PrintStream ps = new PrintStream(System.out, true, "UTF-8");
    new Locale("uk", "UA");

    FileReader fA;
    File fB = new File("src/lab4B.txt");
    int[][] A = new int[5][5];
    int[][] B = new int[5][5];
    try {
      fA = new FileReader("src/lab4A.txt");
      Scanner input = new Scanner(fA);
      for (int i = 0; i < 5; i++)
        for (int j = 0; j < 5; j++)
          A[i][j] = input.nextInt();
      input.close();
    } catch (FileNotFoundException e){
      ps.println("Файл з елементами масиву А не створено");
      return;
    } catch (InputMismatchException e){
      ps.println("Перевірте запис елементів масиву А у файлі");
      return;
    } catch (NoSuchElementException e){
      ps.println("У файлі недостатньо елементів для масиву 5×5");
      return;
    }
    float sumOverDiagonal = 0;
    float sumUnderDiagonal = 0;
    int min = A[1][1];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (i < j) sumOverDiagonal += A[i][j];
        if (i > j) sumUnderDiagonal += A[i][j];
      }
    }

    ps.println("Середнє арифметичне елементів, розташованих над головною діагоналлю масиву А: " + (sumOverDiagonal / 10) );
    ps.println("Середнє елементів, розташованих під головною діагоналлю масиву А: " + (sumUnderDiagonal / 10) );

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
         B[j][i] = A[i][j];
      }
    }

    try {
      FileWriter fileWriter = new FileWriter(fB);
      BufferedWriter writeBufer = new BufferedWriter(fileWriter);
      PrintWriter printB =new PrintWriter(writeBufer);
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) printB.print(B[i][j]+ " ");
        printB.println();
      }
      printB.close();
    }catch (IOException e){
      ps.println("Помилка при створенні файлy з масивом В");
    }
  }

}


