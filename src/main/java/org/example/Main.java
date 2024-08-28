package org.example;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    StudentScores studentScores = new StudentScores();
    Scanner scanner = new Scanner(System.in);

    int choices = 0;

    while (choices != 6) {
      System.out.println("1. 学生を追加");
      System.out.println("2. 学生を削除");
      System.out.println("3. 点数を更新");
      System.out.println("4. 平均点を計算");
      System.out.println("5. 全学生の情報を表示");
      System.out.println("6. 終了");
      System.out.print("選択してください: ");

      // 1～6以外の数字のときエラーを返す
      try {
        choices = scanner.nextInt();
        System.out.println();

        switch (choices) {
          case 1 -> {
            studentScores.addStudent();
            System.out.println();
          }
          case 2 -> {
            studentScores.deleteStudent();
            System.out.println();
          }
          case 3 -> {
            studentScores.updateScore();
            System.out.println();
          }
          case 4 -> {
            studentScores.calcAverage();
            System.out.println();
          }
          case 5 -> {
            studentScores.displayList();
            System.out.println();
          }
          case 6 -> System.out.println("プログラムを終了します。");
          default -> {
            System.out.println("エラー: 1～6の数字を入力してください。");
            System.out.println();
          }
        }
      } catch (InputMismatchException e) {
        System.out.println("エラー: 1～6の数字を入力してください。");
        System.out.println();
        scanner.next();
      }
    }
  }
}
