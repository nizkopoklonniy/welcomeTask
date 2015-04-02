package com.springapp.utils;

/**
 * Text utils for work with string.
 */
public class TextUtils {

    /**
     * Checks string on letter symbols.
     * @param name String for check.
     * @return True if only letter symbols, false another.
     */
    public static boolean isLetterSymbols(String name){
        return name.matches("[a-zA-ZА-Яа-яёЁ]+");
    }
}