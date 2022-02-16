package com.example.hello.service;

import java.io.*;

public class JavaRunCommand {
    private static final String CMD =
            "netsh int ip set address name = \"Local Area Connection\" source = static addr = 192.168.222.3 mask = 255.255.255.0";
    public static void main(String args[]) {

//        runCommand("cmd.exe /c start dir ");
        String searchWording = "java";
        String cmd = "cmd.exe /c start robot -v search_wording:"+searchWording+"  test_script01.txt";
        runCommand(cmd);

    }

    public static void runCommand(String cmd){
        try {
            String ss = null;
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedWriter writeer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            writeer.write("dir");
            writeer.flush();
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            System.out.println("Here is the standard output of the command:\n");
//            while ((ss = stdInput.readLine()) != null) {
//                System.out.println(ss);
//            }
//            System.out.println("Here is the standard error of the command (if any):\n");
//            while ((ss = stdError.readLine()) != null) {
//                System.out.println(ss);
//            }

        } catch (IOException e) {
            System.out.println("FROM CATCH" + e.toString());
        }

    }
}