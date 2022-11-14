package com.karolina.educative;

import java.util.ArrayList;
import java.util.Arrays;

public class EducativeSandbox {
    public static void main(String[] args) {
        printPascalTri(5);
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
