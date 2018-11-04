package com.company;

import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBook {
   private String name;
   private String phoneNumber;
   private  String buff ;
   private String checkBuff;
   private  File file = new File("callNumber.txt");

    public  boolean checkRepeat(String currentValue) throws IOException{
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            checkBuff = scanner.nextLine();
            if (checkBuff.equals(currentValue)){
                scanner.close();
                return true;
            }

        }
        scanner.close();
        return false;

    }

    public void enterData() throws IOException,RepeatExсeption {

        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the name: ");
            name = scan.nextLine();
            System.out.println("Enter  the phone number: ");
            phoneNumber = scan.nextLine();
            buff = name + " " + phoneNumber;
            System.out.println(buff);
            if (checkRepeat(buff)){
                throw (new RepeatExсeption());
            }
            FileWriter fw = new FileWriter(file);
            fw.write(buff);
            fw.close();


        }
    }

    }

  class RepeatExсeption extends Exception{
       public  String toString(){
           return "This contact already exists";
        }



}
