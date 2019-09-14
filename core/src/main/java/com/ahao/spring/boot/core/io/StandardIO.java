package com.ahao.spring.boot.core.io;

import java.io.*;
import java.util.Scanner;

/**
 * @author ahao
 * @since 2019/8/26 20:38
 **/
public class StandardIO {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            String s = bufferedReader.readLine();
            if ("e".equals(s)) {
                break;
            }
            System.out.println(s);
        }
    }
}
