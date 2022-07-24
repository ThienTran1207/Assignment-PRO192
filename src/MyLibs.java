/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MyLibs {

    public static final String capitalize(String str) {

        if (str == null || str.length() == 0) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);

    }

    public static double inputdouble() {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();
        double number;
        while (true) {
            try {
                number = Double.parseDouble(n);
                break;
            } catch (Exception e) {
                System.err.println("do again:");
                n = sc.nextLine();
            }
        }
        return number;
    }

    public static int inputint() {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();
        int number;
        while (true) {
            try {
                number = Integer.parseInt(n);
                break;
            } catch (Exception e) {
                System.err.println("do again:");
                n = sc.nextLine();
            }
        }
        return number;
    }

    public static String inputstr() {
        Scanner sc = new Scanner(System.in);
        String str = new String();
        str = sc.nextLine();
        return str;
    }

    public static String inputStr(int len) {
        //phuong thuc nhap chuoi cho do dai xac dinh
        Scanner sc = new Scanner(System.in);
        System.out.print("please input a string with length: " + len + " char(s): ");

        String input = sc.nextLine();

        while (true) {
            if (input.length() == len) {
                break;
            } else {
                System.out.println("you've enter wrong input with length: " + input.length() + " characters!");
                input = sc.nextLine();
            }
        }
        return input;
    }

    public static boolean isIncludeDigits(String input) {
        //xem trong chuoi co cac ky tu kia ko; - dung tra true, sai tra false
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIncludeAlphabet(String input) {

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIncludeSpecialchars(String input) {
        //xem trong chuoi co cac ky tu kia ko; - dung tra true, sai tra false
        String check = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            for (int j = 0; j < check.length(); j++) {
                if (ch == check.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String inputStr(int len, boolean isInlcludeDigit) {
        String result = inputStr(len);

        while (true) {
            if (isIncludeDigits(result) == isInlcludeDigit) {
                break;
            } else {
                System.err.println("you've enter wrong input with no digit!");
                System.out.println("try again!");
                result = inputStr(len);
            }

        }
        return result;
    }

    public static String inputStr(int len, boolean isInlcludeDigit, boolean isIncludeAlphabet) {
        String result = inputStr(len, true);

        while (true) {
            if (isIncludeAlphabet(result) == isIncludeAlphabet) {
                break;
            } else {
                System.err.println("you've enter wrong input with no letter!");
                System.out.println("try again!");
                result = inputStr(len, true);
            }

        }
        return result;
    }

    public static String inputStr(int len, boolean isInlcludeDigit, boolean isIncludeAlphabet, boolean isIncludeSpecialchars) {
        String result = inputStr(len, true, true);

        while (true) {
            if (isIncludeSpecialchars(result) == isIncludeSpecialchars) {
                break;
            } else {
                System.err.println("you've enter wrong input with no Special character!");
                System.out.println("try again!");
                result = inputStr(len, true, true);
            }

        }
        return result;
    }

    public static int inputInt() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter an integer number: ");
//int number = sc.nextInt();
        String input = sc.nextLine();
        int number;
        while (true) {
            try {
                if (input.length() >= 10) {
                    throw new InputMismatchException("Too long number (greater or equal 10 digits).");
                }
                number = Integer.parseInt(input);
                break; //đã nhập 1 số nguyên hợp lệ thì break: thoát khỏi vòng lặp while true
            } catch (Exception e) {
                System.err.println("You've entered a wrong integer number.");
                System.err.println("Reason: " + e.getMessage());
                System.out.print("Please enter an integer number again: ");
                input = sc.nextLine();
            }
        }
        return number;
    }

    public static int getRandomInt() {
        Random rand = new Random();
        return rand.nextInt(Integer.MAX_VALUE);
    }

    public static int getRandomIntInRange(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static int getRandomIntInRange2(int min, int max) {
        int randomNum = java.util.concurrent.ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }

    public static String getRandomMaterial() {
        String[] Cor = {"Chalk", "chert", "coal", "flint", "granite", "limestone",
             "sandstone", "slate", "Chalk", "coal", "granite", "limestone",
             "sandstone", "Chert", "flint", "Amethyst", "carnelian", "diamond",
             "emerald", "ruby", "sapphire", "Slate", "Asphalt; concrete", "Brick",
             "chimney pot", "tile", "Earthenware", "porcelain", "refined earthenware",
             "stoneware", "terracotta", "Pewter", "Aluminium", "Furnace lining", "slag",
             "Clinker", "hammerscale", "Plastic", "nylon", "Human bone", "human hair",
             "Cess", "Coprolite", "Faecal matter (unspecified)", "Eggshell", "fat",
             "fish-scales", "fur", "gut", "hair", "skin", "Bone", "claws", "toliths",
             "teeth", "Red deer antler", "Cow horn", "Walrus ivory", "Turtle shell",
             "Beetle", "crab", "flea", "fly", "lobster", "Mussel", "oyster", "snail",
             "Eggshell", "fur", "horn", "Silk", "wool", "Worked antler", "worked bone",
             "worked ivory", "Cess", "coprolite", "faecal matter (unspecified)", "Chaff",
             "flower", "leaf", "phytolith", "seed", "wood", "burnt wood", "Cotton", "hemp (rope)",
             "jute", "linen", "rattan", "Amber", "jet", "pearl"};
        return Cor[getRandomIntInRange(0, Cor.length - 1)];
    }

    public static String genRandomHexa() {
        Random rand = new Random();
        int randHexVal = Math.abs(rand.nextInt(Integer.MAX_VALUE) % 16);//lay phan du phep chia nguyencho 16
        return Integer.toHexString(randHexVal).toUpperCase();
        //input 13 : D
        //inpput 14: E
    }

    public static String genRandomHexaColor() {
        //RGB 00DD32
        //mau sac tren cacs trang web dc cau thanh boi RR GG BB tu 00 - FF
        String result = "#";
        int N = 6;
        for (int i = 0; i < N; i++) {
            result += MyLibs.genRandomHexa();
        }
        return result;
    }

//    public static Item getRandomItem(){
//        int value = MyLibs.getRandomIntInRange(30, 3000);
//        String Creator = MyLibs.getRandomFullname();
//        return new Item(value,Creator);
//    }
}
