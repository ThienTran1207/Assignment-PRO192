
import java.io.*;
import java.util.*;
import java.lang.*;

public class CarManager {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("\n\nMINH TRANG BMW - car showroom");
        System.out.println("Showroom's service: ");
        ArrayList<String> options = new ArrayList<String>();
        options.add("List all brands");
        options.add("Add a new brand");
        options.add("Search a brand based on its ID");
        options.add("Update a brand");
        options.add("Save brands to the file, named brands.txt");
        options.add("List all cars in ascending order of brand names");
        options.add("List cars based on a part of an input brand name");
        options.add("Add a car");
        options.add("Remove a car based on its ID");
        options.add("Update a car based on its ID");
        options.add("Save cars to file, named cars.txt");
        options.add("exit");

        BrandList brandList = new BrandList();
        brandList.loadFromFile("brands.txt");
        CarList carList = new CarList(brandList);
        carList.loadFromFile("cars.txt");

        int Choice;
        Menu mn = new Menu();
        do {
            Choice = mn.int_getChoice(options);
            switch (Choice) {
                case 1:
                    brandList.listBrands();
                    System.out.println("");
                    break;
                case 2:
                    brandList.addBrand();
                    System.out.println("");
                    break;
                case 3:
                    if(brandList.searchID(MyLibs.inputstr()) == -1){
                        System.out.println("Brand can't be found!");
                    }else{
                        int i = brandList.searchID(MyLibs.inputstr());
                        System.out.println(brandList.get(i).toString());
                    }
                    System.out.println("");
                    break;
                case 4:
                    brandList.updateBrand();
                    System.out.println("");
                    break;
                case 5:
                    brandList.saveToFile("brands.txt");
                    System.out.println("");
                    break;
                case 6:
                    carList.listCars();
                    break;
                case 7:
                    System.out.print("Enter the brand name: ");
                    carList.printBasedBrandName(MyLibs.inputstr());
                    break;
                case 8:
                    carList.addCar();
                    System.out.println("");
                    break;
                case 9:
                    if(carList.removeCar())
                        System.out.println("");
                    break;
                case 10:
                    if(carList.updateCar())
                        System.out.println("");
                    break;
                case 11:
                    carList.saveToFile("cars.txt");
                    break;

            }
        } while (Choice > 0 && Choice <= options.size()-1);

    }
}
