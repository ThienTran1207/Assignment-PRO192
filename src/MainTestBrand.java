import java.util.ArrayList;
import java.util.Scanner;

public class MainTestBrand {
    public static void main(String[] args)  throws InterruptedException{
        BrandList list = new BrandList();
        Scanner sc = new Scanner(System.in);
        String[] ops = {"List all brands", "Add a new brand", "Search a brand based on its ID",
                        "Update a brand", "Save brands to the file, named brands.txt", 
                        "List all cars in ascending order of brand names", "List cars based on a part of an input brand name",
                        "Add a car", "Remove a car based on its ID", "Update a car based on its ID", "Save cars to file, named cars.txt"};
        int choice = 0;
        do{
            choice = 1;
            switch (choice) {
                case 1:
                    list.listBrands();
                    break;
                case 2:
                    list.addBrand();
                    break;
                case 3:
                    //list.searchID();
                    break;
                case 4:
                    list.updateBrand();
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                case 9:
                    
                    break;
                case 10:
                    
                    break;
                case 11:
                    
                    break;  
            }
        } while (choice >0  && choice <= 11);
    }
    
}
