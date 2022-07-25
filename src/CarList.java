

import java.io.*;
import java.util.*;
import java.lang.*;

public class CarList extends ArrayList<Car> {

    public BrandList blist;

    public CarList(BrandList bList) {
        this.blist = bList;
    }

    public boolean loadFromFile(String filename) {
        try {
            File f = new File(filename);
            if (!f.exists()) {
                System.err.println("Error: file doesnt exist");
                return false;
            } else {
                //System.out.println("Load from file success!");

                FileReader fd = new FileReader(f);
                BufferedReader bf = new BufferedReader(fd);
                String line;

                while ((line = bf.readLine()) != null) {
                    String[] ls = line.split(",");
                    Car cr = new Car();
                    int pos = blist.searchID(ls[1].substring(1));
                    Brand b = blist.get(pos);
                    cr.setBrand(b);
                    cr.setCarID(ls[0]);
                    cr.setColor(ls[2].substring(1));
                    cr.setFrameID(ls[3].substring(1));
                    cr.setEngineID(ls[4].substring(1));
                    this.add(cr);
                    //System.out.println(line);
                }
                fd.close();

            }
            return true;
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
            return false;
        }

    }

    public boolean saveToFile(String filename) {
        try {
            File f = new File(filename);
            if (!f.exists()) {
                System.err.println(f.getCanonicalFile() + " does not exists to write");
                return false;
            }
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < this.size(); i++) {
                Car p = this.get(i);
                pw.println(p);
            }
            pw.close();
            fw.close();
            System.out.println("succeed!");
            return true;
        } catch (Exception e) {
            System.err.println("Error: cannot write data to file " + filename);
            System.err.println("Reason: " + e.getMessage());
            return false;
        }

    }

    // use for isCodeDupplicated()
    public Car search(String ID) {
        ID = ID.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCarID().equals(ID)) {
                return this.get(i);
            }
        }
        return null; // not found
    }

    private boolean isCodeDupplicated(String code) {
        code = code.trim().toUpperCase();
        return search(code) != null;
    }

    private boolean isExistBrandID(String code, BrandList t) {
        boolean check = false;
        code = code.trim().toUpperCase();
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i).brandID.compareTo(code) == 0) {
                check = true;
                break;
            }
        }
        return check;
    }

    private int BrandIndex(String code, BrandList t) {
        int result = 0;
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i).getBrandID().compareTo(code) == 0) {
                result = i;
            }
        }
        return result;
    }

    public void addCar() {
        Menu mn = new Menu();
        Brand brand = (Brand)mn.ref_getChoice(blist);
        String newId, brandID, newColor, newFrameID, newEngineID = null;
        int brandIndex = 0;
        boolean isExist = false, isDuplicate = true;
        do {
            newId = Inputter.inputString("Enter Car Id: ");
            newId = newId.trim().toUpperCase();
            isDuplicate = isCodeDupplicated(newId);
            brandID = Inputter.inputString("Enter Brand Id: ");
            brandID = brandID.toUpperCase();
            isExistBrandID(brandID, this.blist);
            brandIndex = BrandIndex(brandID, blist);
            if (isDuplicate) {
                System.out.println("Car ID is dupplicate");
            } else if (!isExist) {
                System.out.println("Brand ID is not exist");
            }
        } while (isExist == false || isDuplicate == true);
        brand = this.blist.get(brandIndex);
        newColor = Inputter.inputNonNlankStr("Enter Car color: ");
        newColor = newColor.trim().toUpperCase();
        newFrameID = Inputter.inputFramdID("Enter Frame ID of Car: ", this);
        newEngineID = Inputter.inputEngineID("Enter the Engine ID of Car: ", this);
        //creat new Car
        Car temp = new Car(newId, brand, newColor, newFrameID, newEngineID);
        // add to the list
        this.add(temp);
        System.out.println("Car " + newId + " has been added.");
    }

    public boolean removeCar() {
        String removedID = Inputter.inputString("Enter the car's ID want to remove: ");
        int pos = searchID(removedID);
        if (pos < 0) {
            System.out.println("Not found!");
            return false;
        } else {
            this.remove(pos);
            System.out.println("The car with ID: " + removedID + " has been removed");
            return true;
        }
    }

    public boolean updateCar() {
        String updateID = Inputter.inputString("Enter the car's ID want to update: ");
        int pos = searchID(updateID);
        if (pos < 0) {
            System.out.println("Not found!");
            return false;
        } else {
            Menu mn = new Menu();
            Brand b = (Brand) mn.ref_getChoice(this.blist);
            //Brand b = new Brand();
            String updateColor = Inputter.inputNonNlankStr("Enter the new Color for car:");
            String updateFrameID = Inputter.inputFrameID("Enter the new Frame ID for car:");
            String updateEngineID = Inputter.inputEngineID("Enter the new Engine ID for car:");
            this.set(pos, new Car(updateID, b, updateColor, updateID, updateID));
        }
        return true;
    }

    // use for updateCar();
    public int searchID(String carID) {
        carID = carID.trim().toUpperCase();
        int index = -1;
        int n = this.size();
        for (int i = 0; i < n; i++) {
            if (this.get(i).getCarID().compareToIgnoreCase(carID) == 0) {
                index = i;
            }
        }
        return index;
    }

    public void printBasedBrandName(String code) {
        code = code.trim();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getBrand().brandID.contains(code)) {
                System.out.println(this.get(i).toString());
            }
        }
    }
    
    public void listCars() {
        Collections.sort(this, new Comparator<Car>() {
            @Override
            public int compare(Car t, Car t1) {
                return t.getBrand().getBrandName().compareTo(t1.getBrand().getBrandName());
            }
        });
        for(Car i : this){
            System.out.println(i.ScreenString());
        }
    }

    @Override
    public String toString() {
        return "CarList{" + "blist=" + blist + '}';
    }
}

