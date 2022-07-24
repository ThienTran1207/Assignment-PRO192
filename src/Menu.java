import java.util.Scanner;

public class Menu {
    public static int getChoice (String[] ops){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ops.length; i++) {
            System.out.println("\n" + (i+1) + "-" + ops[i]);           
        }
        System.out.println("\n Choose 1..." + ops.length + ": ");
        return Integer.parseInt(sc.nextLine());
    }
}
