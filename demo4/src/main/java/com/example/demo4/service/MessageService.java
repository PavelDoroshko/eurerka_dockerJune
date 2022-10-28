package com.example.demo4.service;

import com.example.demo4.config.MessageManager;

import java.io.IOException;

public class MessageService {
    public static void getMessage(){
        System.out.println("1 — eng\n 2 — bel\n any — default");
        char i = 0;
        try {
            i = (char)System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String country = "";
        String language = "";
        MessageManager messageManager;
        switch (i) {
            case '1':
                country = "US";
                language = "en";
                messageManager = MessageManager.EN;
                break;
            case '2':
                country = "BY";
                language = "be";
                messageManager = MessageManager.BY;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + i);
        }
        // Locale current = new Locale(language, country);
        //  ResourceBundle rb = ResourceBundle.getBundle("property.text", current);
        String s1 = messageManager.getString("str1");
        System.out.println(s1);
        String s2 = messageManager.getString("str2");
        System.out.println(s2);
    }

    public static void reversePolidrom(Integer a) {

        int k = 0;
        while (true) {
            k++;
            StringBuilder stringBuilder = new StringBuilder(a.toString());
            System.out.println(stringBuilder);
            StringBuilder reverseStringBuilder = new StringBuilder(stringBuilder);
            System.out.println(reverseStringBuilder.reverse());
            int sum = Integer.parseInt(stringBuilder.toString()) + Integer.parseInt(reverseStringBuilder.toString());

            System.out.println("сумма" + sum);
            if (sum > 1000) {
                StringBuilder stringBuilderPolindrom = new StringBuilder(Integer.toString(sum));
                System.out.println(stringBuilderPolindrom);
                StringBuilder stringBuilderPolindromReverse = new StringBuilder(stringBuilderPolindrom);

                if (Integer.parseInt(stringBuilderPolindrom.toString()) == Integer.parseInt(stringBuilderPolindromReverse.reverse().toString())) {
                    System.out.println("число полидром "+stringBuilderPolindrom+" количество раз "+k);
                    break;
                }
            }
            a = sum;
        }
    }
}
