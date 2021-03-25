package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    List<String> fizzBuzzList;

    public Solution() {
        this.fizzBuzzList = new ArrayList<>();
    }

    public int takeMax(String max) {
        int n = -1;
        try {
            n = Integer.valueOf(max);
            if (n < 0) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid argument. Must provide an integer!");
            n = -1;
        }
        return n;
    }

    public List<String> processFizzBuzz(int size, String fizzString, String buzzString) {
        this.fizzBuzzList = new ArrayList<>(size);

        if (fizzString.isEmpty() || fizzString.equals("")) fizzString = "Fizz";
        if (buzzString.isEmpty() || buzzString.equals("")) buzzString = "Buzz";

        for (int i = 1; i <= size; i++) {
            fizzBuzzList.add(this.fizzBuzz(i, fizzString, buzzString));
        }

        return fizzBuzzList;
    }

    public String fizzBuzz(int num, String fizzString, String buzzString) {
        StringBuilder sb = new StringBuilder();

        if (isMultipleOf(num, 3)) sb.append(fizzString);
        if (isMultipleOf(num, 5)) sb.append(buzzString);
        if (sb.length() == 0) sb.append(Integer.toString(num));

        return sb.toString();
    }

    public boolean isMultipleOf(int digit, int modulo) {
        return digit % modulo == 0;
    }

    public void printFizzBuzzList() {
        for (String s : this.fizzBuzzList) {
            System.out.println(s);
        }
    }

    public void runFizzBuzz(String[] args) {
        int len = args.length;

        if (len > 0) {
            int n = this.takeMax(args[0]);

            if (n != -1) {
                if (len == 3) {
                    this.processFizzBuzz(n, args[1], args[2]);
                    this.printFizzBuzzList();
                } else if (len == 2) {
                    this.processFizzBuzz(n, args[1], "");
                    this.printFizzBuzzList();
                } else {
                    this.processFizzBuzz(n, "", "");
                    this.printFizzBuzzList();
                }

            } else {
                System.out.println("No integer argument provided!");
            }
        }
    }
}
