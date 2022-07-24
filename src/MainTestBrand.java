
import java.util.Scanner;

public class MainTestBrand {
    public static void main(String[] args) throws InterruptedException {
        BrandList list = new BrandList();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. List all brands");
            System.out.println("2. Add a new brand");
            System.out.println("3. Search a brand based on its ID");
            System.out.println("4. Update a brand");
            System.out.println("5. Exit");
            
            System.out.print("input your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    list.listBrands();
                    break;
                case 2:
                    list.addBrand();
                    break;
                case 3:
                    list.searchID();
                    break;
                case 4:
                    list.updateBrand();
                    break;
                
                
            }
        } while (choice <= 4);
    }
    
}
