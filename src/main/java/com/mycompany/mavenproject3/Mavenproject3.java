/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject3;

import static com.mycompany.mavenproject3.convert.convert;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author eanosov
 */
public class Mavenproject3 {

    public static void main(String[] args) {
        // Корневая директория
        String rootDir = "D:\\time silver\\ferma\\ebook.online-conv";
        try {
            // используя метод `Files.walk()`
            Files.walk(Paths.get(rootDir))
                    .filter(Files::isRegularFile)
                    .forEach(s -> {
                        if (s.toString().contains(".fb2")){
                            try {
                                System.out.println(s);
                                convert(s.toString());
                            } catch (IOException ex) {}
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
