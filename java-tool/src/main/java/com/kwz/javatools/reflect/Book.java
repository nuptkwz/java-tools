package com.kwz.javatools.reflect;

import lombok.Data;

/**
 * Description
 * Date 2020/8/22 0:04
 * Created by kwz
 */
@Data
public class Book {
    private final static String TAG = "BookTag";

    private String name;
    private String author;

    public Book() {
    }

    private Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    private String declaredMethod(int index) {
        String string = null;
        switch (index) {
            case 0:
                string = "I am declaredMethod 1 !";
                break;
            case 1:
                string = "I am declaredMethod 2 !";
                break;
            default:
                string = "I am declaredMethod 1 !";
        }

        return string;
    }
}