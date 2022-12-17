package com.karolina.educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

class FindMax {
    public static <T extends Comparable<T>> T array_max(T data[], int n) {
        T max = data[0];
        for (T value : data) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }

}

public class EducativeSandbox {

    public static void main(String[] args) {
        ArrayList<Character> arrList = new ArrayList<>();
        arrList.add('5');
        arrList.add('5');
        arrList.add('5');
        arrList.add('2');
        arrList.add('0');
        arrList.add('0');
        arrList.add('5');
        arrList.add('7');
        arrList.add('0');
        arrList.add('0');
        arrList.add('0');
        arrList.add('0');
        for (Character item : arrList) {
            System.out.println(item);
        }
        System.out.println("---");
        removeDuplicates(arrList);
        for (Character item : arrList) {
            System.out.println(item);
        }

    }

    public static void removeDuplicates(ArrayList<Character> arrList) {
        arrList.sort(null);
        int currentArrListSize = arrList.size();
        int i = 1;
        do {
            if (arrList.get(i - 1) == arrList.get(i)) {
                arrList.remove(i - 1);
                currentArrListSize = arrList.size();
                i = 1;
                continue;
            }
            i++;
        } while (i != currentArrListSize);

    }

    public static void removeDuplicatesSecondVersion(ArrayList<Character> arrList) {
        HashMap<Character, Character> hashMapToRemoveDuplicates = new HashMap<>();
        for (Character item : arrList) {
            hashMapToRemoveDuplicates.put(item, item);
        }

        arrList.clear();
        arrList.addAll(hashMapToRemoveDuplicates.keySet());
    }

    public static void zerosToStart(ArrayList<Integer> arrList) {

        int occurencies = Collections.frequency(arrList, 0);
        int iterationNumber = 1;
        int lastIndex = arrList.size() - 1;
        while (iterationNumber <= occurencies) {

            for (int i = lastIndex; i >= iterationNumber; i--) {
                int number = arrList.get(i);
                if (number == 0) {
                    arrList.set(i, arrList.get(i - 1));
                    arrList.set(i - 1, 0);
                }
            }
            iterationNumber++;
        }

    }

    static class Animal {

        private String name;
        private int age;
        protected String origin;

        void set_data(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

    }

    // define derived class named "Zebra" here
    static class Zebra extends Animal {

        public Zebra(int age, String name) {
            super.set_data(age, name);
            super.origin = "Africa";
        }

        String message_zebra() {
            return "The zebra named " + super.name + " is " + super.age + " years old. The zebra comes from "
                    + super.origin;
        }
    }

    // define derived class named "Dolphin" here

    class Dolphin extends Animal {

        public Dolphin(int age, String name) {
            super.set_data(age, name);
            super.origin = "New Zealand";
        }

        String message_dolphin(String str) {
            return "The dolphin named " + super.name + " is " + super.age + " years old. The dolphin comes from "
                    + super.origin;
        }
    }

    public static void printPascalTri(int size) { // define your function
        int[][] pascalTriangle = new int[size][size];

        for (int r = 0; r < size; r++) {
            for (int c = 0; c <= r; c++) {
                if (r <= 1) {
                    pascalTriangle[r][c] = 1;
                    if (r == c) {
                        break;
                    }
                } else {
                    if (c == 0) {
                        pascalTriangle[r][c] = 1;
                    } else if (r == c) {
                        pascalTriangle[r][c] = 1;
                        break;
                    } else {
                        pascalTriangle[r][c] = pascalTriangle[r - 1][c] + pascalTriangle[r - 1][c - 1];
                    }
                }

            }
        }

        for (int[] row : pascalTriangle) {
            for (int value : row) {
                if (value == 0) {
                    break;
                }
                System.out.print(value + " ");
            }
            System.out.println("");
        }
    }

    public static void printMat(int n) {
        int[][] matrix = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (c < r) {
                    matrix[r][c] = -1;
                } else if (c > r) {
                    matrix[r][c] = 1;

                } else {
                    matrix[r][c] = 0;
                }
            }
        }
        int value;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                value = matrix[r][c];
                System.out.print(value + " ");
            }
            System.out.println("");
        }

    }

    public static void sortAsc(int[] arr) {
        System.out.println("In method 1: " + arr.hashCode());
        // Arrays.sort(arr);
        arr = Arrays.stream(arr).sorted().toArray();
        System.out.println("In method: " + arr.hashCode());
    }

    public static int findMaxVal(int[] arr) {
        int maxVal = arr[0];
        for (int value : arr) {
            if (value > maxVal) {
                maxVal = value;
            }
        }

        return maxVal;
    }

    public static String UpperOrLowerCases(String x) {

        return (x.length() % 2 == 0) ? x.toUpperCase() : x.toLowerCase();
    }

    public static int sumOfDig(int var) {
        int sum = 0;
        // int length = (int) (Math.log10(var) + 1);
        // for (int i = 1; i <= length; i++) {
        // int digit = var % 10;
        // sum += digit;
        // var = var / 10;
        // System.out.println("i: " + i + " var: " + var);
        // }
        while (var != 0) {
            int digit = var % 10;
            sum += digit;
            var = var / 10;
        }

        return sum; // return the resultant sum
    }

    public static double letterToGPA(String grade) {
        double GPAPoint;
        grade = grade.toUpperCase();
        switch (grade) {
            case "A+":
            case "A":
                GPAPoint = 4;
                break;
            case "A-":
                GPAPoint = 3.7;
                break;
            case "B+":
                GPAPoint = 3.3;
                break;
            case "B":
                GPAPoint = 3;
                break;
            case "B-":
                GPAPoint = 2.8;
                break;
            case "C+":
                GPAPoint = 2.5;
                break;
            case "C":
                GPAPoint = 2;
                break;
            case "C-":
                GPAPoint = 1.8;
                break;
            case "D":
                GPAPoint = 1.5;
                break;
            case "F":
                GPAPoint = 0;
                break;
            default:
                GPAPoint = -1;
                break;
        }
        return GPAPoint;
    }

    public static int checkSum(int one, int two) {
        int check;
        if (one + two < 100) {
            check = 0;
        } else if (one + two > 100) {
            check = 1;
        } else {
            check = 2;
        }
        return check;
    }

    public static void hashPyramid(int rows) {
        for (int row = 1; row <= rows; row++) {
            for (int hashID = 1; hashID <= row; hashID++) {
                System.out.print("# ");
            }
            System.out.println("");
        }
    }

    public String week_day(int x) {
        String weekDayOrDefault;
        switch (x) {
            case 1:
                weekDayOrDefault = "Monday";
                break;
            case 2:
                weekDayOrDefault = "Tuesday";
                break;
            case 3:
                weekDayOrDefault = "Wednesday";
                break;
            case 4:
                weekDayOrDefault = "Thursday";
                break;
            case 5:
                weekDayOrDefault = "Friday";
                break;
            case 6:
                weekDayOrDefault = "Saturday";
                break;
            case 7:
                weekDayOrDefault = "Sunday";
                break;
            default:
                weekDayOrDefault = "invalid input";
                break;
        }

        return weekDayOrDefault;
    }

    public static String FibonacciSeries(int n) {
        StringBuilder fibString = new StringBuilder();
        ArrayList<Integer> fibNumbers = new ArrayList<>();
        if (n == 1) {
            fibNumbers.add(0);
        } else if (n == 2) {
            fibNumbers.add(0);
            fibNumbers.add(1);
        } else {
            fibNumbers.add(0);
            fibNumbers.add(1);
            for (int i = 2; i < n; i++) {
                int nextFibNumber = fibNumbers.get(i - 1) + fibNumbers.get(i - 2);
                fibNumbers.add(nextFibNumber);
            }
        }

        for (Integer fibNumber : fibNumbers) {
            fibString.append(fibNumber + " ");
        }

        return fibString.toString();
    }

}
