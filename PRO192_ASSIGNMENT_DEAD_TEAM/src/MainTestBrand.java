import java.util.Scanner;

public class MainTestBrand {
    public static void main(String[] args) throws InterruptedException {
        BrandList list = new BrandList();
        Scanner sc = new Scanner(System.in);
        list.loadFromFile("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\New Folder\\Assignment-PRO192\\PRO192_ASSIGNMENT_DEAD_TEAM\\brands.txt");
        int choice;
        do {
            System.out.println("1. List all brands");
            System.out.println("2. Add a new brand");
            System.out.println("3. Search a brand based on its ID");
            System.out.println("4. Update a brand");
            System.out.println("5. Save Brand to file");
            System.out.println("6. Exit");
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
                case 5:
                    list.saveToFile("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\New Folder\\Assignment-PRO192\\PRO192_ASSIGNMENT_DEAD_TEAM\\brands.txt");          
            }
        } while (choice <= 5);
    }
    
}
