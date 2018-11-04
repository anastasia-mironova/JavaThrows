package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class PhoneBook {
   private String name;
   private String phoneNumber;
   private  String buff ;
   private String checkBuff;
   private  File file = new File("callNumber.txt");

    public  boolean checkRepeat(String currentValue) throws Exception{
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            checkBuff = scanner.nextLine();
            System.out.println(checkBuff.equals(buff));
            if (checkBuff.equals(currentValue)){
                scanner.close();
                return true;
            }

        }
        scanner.close();
        return false;

    }

    public void enterData() throws Exception {
        try{
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
        catch (RepeatExсeption e){
            e.toString();
        }
    }

  class RepeatExсeption extends Exception{
       public  String toString(){
           return "This contact already exists";
        }

       }

}
