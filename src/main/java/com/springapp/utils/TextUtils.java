package com.springapp.utils;

public class TextUtils {

    public static boolean isLetterSymbols(String name){
        return name.matches("[a-zA-ZА-Яа-яёЁ]+");
    }
}