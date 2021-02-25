package com.company;

public class StringHelper {
     public static String multiply(String s, int count) {
         String string = s;
         if (count <= 0) {
             return "";
         } else {
             for (int i = 1; i < count; ++i) {
                 s += string;
             }
             return s;
         }
     }
    public static String multiply(String s) {
        String string = s;
        for (int i = 1; i < 5; ++i) {
            s += string;
        }
        return s;
    }
}
