package com.company.Exercise;

import com.company.Set.Set;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lotto {
    private static Set<Integer> list;

    public static void Run() {
        list = new Set<>();

        try {
            BufferedReader read = new BufferedReader(new FileReader("lottosz.dat"));
            String line = read.readLine();
            while(line != null) {
                String[] lineArr = line.split(" ");
                for (String s: lineArr) {
                    int e = Integer.parseInt(s);
                    list.add(e);
                }

                line = read.readLine();
            }



            read.close();
        } catch(IOException e) {
            System.out.println(e.toString());
        }
    }
}
