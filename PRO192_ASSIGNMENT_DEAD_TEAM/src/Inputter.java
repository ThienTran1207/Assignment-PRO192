import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputter {

    public static Scanner sc = new Scanner(System.in);

    //Get an integer between min...max
    
    public static int inputInt(String msg, int min, int max) {
        if (min > max) {
            int t = min;
            min = max;
            max = t;
        }
        int data;
        do{
            System.out.println(msg);
            data = Integer.parseInt(sc.nextLine());
        }while(data<min || data>max);
        return data;
    }
    
    
    public static double inputDouble() throws InterruptedException {
        // method chuyen dam nhiem viec nhap vao va tra ve
        // phai chac chan la 1 so nguyen
        // useful, reusable, stable, strong
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter price (real number) (maximum 4 digits): ");
        String input = sc.nextLine();
        double number;
        while (true) {
            try {
                if (input.length() >= 6) {
                    throw new InputMismatchException("Too long number (greater or equal to 6 digits).");
                }
                if(Double.parseDouble(input) <= 0){
                    throw new InputMismatchException("The price need to be a positive real number.");
                }
                number = Double.parseDouble(input);
                break;
            } catch (Exception e) {
                System.err.println("You've entered a wrong real number.");
                System.err.println("Reason: " + e.getMessage());
                Thread.sleep(100);
                System.out.print("Please enter a real number again: ");
                input = sc.nextLine();
            }
        }
        return number;
    }
    
    //Get a string with no condition
    public static String inputString(String msg){
        System.out.println(msg);
        String data = sc.nextLine().trim();
        return data;
    }
    
    //Get a non-blank string
    public static String inputNonNlankStr(String msg){
        String data;
        do{
            System.out.println(msg);
            data = sc.nextLine().trim();
        }while(data.length()==0);
        return data;
    }
    
    //Get a string following a pattern
    public static String inputPattern(String msg, String pattern){
        String data;
        do{
            System.out.println(msg);
            data = sc.nextLine().trim();
        }while(!data.matches(pattern));
        return data;
    }
}