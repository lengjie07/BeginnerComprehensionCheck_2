package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentScores {

  List<Student> studentList = new ArrayList<>();
  Scanner scanner = new Scanner(System.in);

  // 1. 学生を追加
  public void addStudent() {
    System.out.print("追加する学生の名前を入力してください: ");
    String nameToRegister = scanner.next();

    System.out.print(nameToRegister + "の点数を入力してください: ");
    // 点数が0以上100以下の整数以外のときにエラーを返す
    try {
      int scoreToRegister = scanner.nextInt();
      if (scoreToRegister >= 0 && scoreToRegister <= 100) {
        studentList.add(new Student(nameToRegister, scoreToRegister));
      } else {
        System.out.println("エラー: 点数は0～100の整数で入力してください。");
      }
    } catch (InputMismatchException e) {
      System.out.println("エラー: 点数は0～100の整数で入力してください。");
      scanner.next();
    }
  }

  // 2. 学生を削除
  public void deleteStudent() {
    System.out.print("削除する学生の名前を入力してください: ");
    String nameToDelete = scanner.next();

    Iterator<Student> iterator = studentList.iterator();

    // 該当する学生がいるかチェック
    boolean found = false;

    while (iterator.hasNext()) {
      Student student = iterator.next();
      if (student.getName().equals(nameToDelete)) {
        iterator.remove();
        found = true;
        break;
      }
    }
    if (!found) {
      System.out.println("エラー:該当する学生がいません。");
    }
  }


  // 3. 点数を更新
  public void updateScore() {
    System.out.print("更新する学生の名前を入力してください: ");
    String nameToUpdate = scanner.next();

    // 該当する学生がいるかチェック
    boolean found = false;

    for (Student student : studentList) {
      if (student.getName().equals(nameToUpdate)) {
        found = true;
        break;
      }
    }

    if (!found) {
      System.out.println("エラー: 該当する学生がいません。");
      return;
    }

    System.out.print(nameToUpdate + "の点数を入力してください: ");
    // 点数が0以上100以下の整数以外のときにエラーを返す
    try {
      int newScore = scanner.nextInt();
      if (newScore < 0 || newScore > 100) {
        System.out.println("エラー: 点数は0～100の整数で入力してください。");
        return;
      }

      for (Student student : studentList) {
        if (student.getName().equals(nameToUpdate)) {
          student.setScore(newScore);
          break;
        }
      }

    } catch (InputMismatchException e) {
      System.out.println("エラー: 点数は0～100の整数で入力してください。");
      scanner.next();
    }
  }

  // 4. 平均点を計算
  public void calcAverage() {
    // リストが空だったらエラーを返す
    if (studentList.isEmpty()) {
      System.out.println("エラー: 登録されている学生がいません。");
      return;
    }

    int totalScore = 0;
    for (Student student : studentList) {
      totalScore += student.getScore();
    }

    double averageScore = (double) totalScore / studentList.size();

    System.out.println("平均点: " + averageScore + "点");
  }

  // 5. 全学生の情報を表示
  public void displayList() {
    // リストが空だったらエラーを返す
    if (studentList.isEmpty()) {
      System.out.println("エラー: 登録されている学生がいません。");
      return;
    }

    for (Student student : studentList) {
      System.out.println(student);
    }
  }
}
