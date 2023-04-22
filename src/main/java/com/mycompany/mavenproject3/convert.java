/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 *
 * @author eanosov
 */
public class convert {

    public static void convert(String s) throws FileNotFoundException, IOException {
        String line1, line2;
        File file = new File(s);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileS(s)), "UTF-8"));
//        HashMap<String, String> maps = new HashMap<>();
        HashMap<String, String[]> maps2 = new HashMap<>();
        maps2.put("Бабушку Марию", new String[]{"Gran Maria", "Гран Мария"});
        maps2.put("Бабушки Марии", new String[]{"Gran Maria", "Гран Мария"});
        maps2.put("Бабушка Мария", new String[]{"Gran Maria", "Гран Мария"});
        maps2.put("бабушка", new String[]{"Gran Maria", "Гран Мария"});
        maps2.put("Таер", new String[]{"Tier", "Тир"});
        maps2.put("Таера", new String[]{"Tier", "Тир"});
        maps2.put("Таером", new String[]{"Tier", "Тир"});
        maps2.put("Таеру", new String[]{"Tier", "Тир"});
        maps2.put("зверюги", new String[]{"beastboys", "зверобои"});
        maps2.put("Бистбои", new String[]{"beastboys", "зверобои"});
        maps2.put("бистбои", new String[]{"beastboys", "зверобои"});
        maps2.put("зверюг", new String[]{"beastboys", "зверобоев"});
        maps2.put("зверобойцев", new String[]{"beastboys", "зверобоев"});
        maps2.put("зверобойцами", new String[]{"beastboys", "зверобоями"});

//        maps.put("Бабушку Марию", "Gran Maria");
//        maps.put("Бабушки Марии", "Gran Maria");
//        maps.put("Бабушка Мария", "Gran Maria");
//        maps.put("бабушка", "Gran Maria");
//        maps.put("Таер", "Tier");
//        maps.put("Таера", "Tier");
//        maps.put("Таером", "Tier");
//        maps.put("Таеру", "Tier");
//        maps.put("Бистбои", "beastboys");
//        maps.put("бистбои", "beastboys");
        int i = 1;
        if ((line1 = br.readLine()) != null) {
            wr.write(line1 + "\n");
            while ((line2 = br.readLine()) != null) {

                if (line2.contains("<book-title>")) {
                    line2 = titleName(line2, Paths.get(s).getFileName().toString());
                }

                for (HashMap.Entry<String, String[]> entry : maps2.entrySet()) {
                    if (line1.contains(entry.getValue()[0]) && line2.contains(entry.getKey())) {
                        if ("Gran Maria".equals(entry.getValue()[0])) {
                            line2 = line2.replace(entry.getKey(), entry.getValue()[1]);
                            System.out.println(i + " --- " + entry.getValue()[1] + " --- " + s);
                        }
                        if ("Tier".equals(entry.getValue()[0])) {
                            line2 = line2.replace(entry.getKey(), entry.getValue()[1]);
                            System.out.println(i + " --- " + entry.getValue()[1] + " --- " + s);
                        }
                        if ("beastboys".equals(entry.getValue()[0])) {
                            line2 = line2.replace(entry.getKey(), entry.getValue()[1]);
                            System.out.println(i + " --- " + entry.getValue()[1] + " --- " + s);
                        }
                    }
                }

                wr.write(line2 + "\n");
                line1 = line2;
                i++;
            }
        }

//        int i = 1;
//        if ((line1 = br.readLine()) != null) {
//            wr.write(line1 + "\n");
//            while ((line2 = br.readLine()) != null) {
//
//                for (HashMap.Entry<String, String> entry : maps.entrySet()) {
//                    if (line1.contains(entry.getValue()) && line2.contains(entry.getKey())) {
//                        if ("Gran Maria".equals(entry.getValue())) {
//                            line2 = line2.replace(entry.getKey(), "Гран Мария");
//                            System.out.println(i + " --- " + entry.getValue() + " --- " + s);
//                        }
//                        if ("Tier".equals(entry.getValue())) {
//                            line2 = line2.replace(entry.getKey(), "Тир");
//                            System.out.println(i + " --- " + entry.getValue() + "       --- " + s);
//                        }
//                        if ("beastboys".equals(entry.getValue())) {
//                            line2 = line2.replace(entry.getKey(), "зверобои");
//                            System.out.println(i + " --- " + entry.getValue() + "       --- " + s);
//                        }
//                    }
//                }
//
//                wr.write(line2 + "\n");
//                line1 = line2;
//                i++;
//            }
//        }
    }

    private static String fileS(String s) {
        String time = "";
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '\\') {
                break;
            }
            time = chars[i] + time;
        }
        return s.replace(time, "convJava\\" + time);
    }

    private static String titleName(String s, String name) {
        String time = "";
        int check = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '<') {
                check++;
            }
            if (check == 2) {
                time = time + chars[i];
            }
            if (chars[i] == '>') {
                check++;
            }
        }

        return s.replace(time, "ferma:" + name);
    }

}
