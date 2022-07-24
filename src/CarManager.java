import java.util.ArrayList;
import java.util.Scanner;

public class CarManager {
    public static void main(String[] args)  throws InterruptedException{
        BrandList list = new BrandList();
        CarList t = new CarList(list);
        Scanner sc = new Scanner(System.in);
        String[] ops = {"List all brands", "Add a new brand", "Search a brand based on its ID",
                        "Update a brand", "Save brands to the file, named brands.txt", 
                        "List all cars in ascending order of brand names", "List cars based on a part of an input brand name",
                        "Add a car", "Remove a car based on its ID", "Update a car based on its ID", "Save cars to file, named cars.txt"};
        int choice = 0;
        do{
            choice = Menu.getChoice(ops);
            switch (choice) {
                case 1:
                    if(list.loadFromFile("File_brands.txt")){
                    list.listBrands();
                    }
                    break;
                case 2:
                    do{
                        list.addBrand();
                    } while(!list.saveToFile("File_brands.txt"));
                    break;
                case 3:
                    System.out.print("Enter the ID: ");
                    list.searchID(sc.nextLine());
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
                    t.addCar();
                    break;
                case 9:
                    if(t.removeCar());
                    break;
                case 10:
                    if(t.updateCar());
                    break;
                case 11:
                    
                    break;  
            }
        } while (choice >0  && choice <= 11);
    }
}

