
import java.io.*;
import java.util.*;
import java.lang.*;

public class BrandList extends ArrayList<Brand> {

    public BrandList() {
        super();
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
                    String[] ls = line.split(",|:");
                    Brand br = new Brand();
                    br.setBrandID(ls[0]);
                    br.setBrandName(ls[1].substring(1));
                    br.setSoundBrand(ls[2].substring(1));
                    br.setPrice(Double.parseDouble(ls[3].substring(1)));
                    this.add(br);
                    //System.out.println(line);
                }
                fd.close();
                return true;
            }

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
                Brand p = this.get(i);
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

    public int searchID(String brandID) {
//        if (this.isEmpty()) {
//            System.out.println("Empty list. Cannot search any brand");
//        } else {
//            String sID = Inputter.inputString("Input brand id to search:");
//            Brand br = this.search(sID);//search brand base on code
//            if(br == null)
//                System.out.println("Brand " + sID + " doesn't exist.");
//            else
//                System.out.println("Brsnd found: " + br);
//        }
        brandID = brandID.trim().toUpperCase();
        int index = -1;
        int n = this.size();
        for (int i = 0; i < n; i++) {
            if (this.get(i).getBrandID().compareToIgnoreCase(brandID) == 0) {
                index = i;
            }
        }
        return index;
    }

    public Brand getUserChoice() {
        Menu mnu = new Menu();
        return (Brand) mnu.ref_getChoice(this);

    }

    public Brand search(String ID) {
        ID = ID.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getBrandID().equals(ID)) {
                return this.get(i);
            }
        }
        return null; // not found
    }

    private boolean isCodeDupplicated(String code) {
        code = code.trim().toUpperCase();
        return search(code) != null;
    }

    public void addBrand() throws InterruptedException {
        //input data of new brand
        String newID, newName, newSoundBrand = null;
        double newPrice;
        boolean codeDupplicated = false;
        do {
            newID = Inputter.inputString("Brand ID: ");
            newID = newID.trim().toUpperCase();
            codeDupplicated = isCodeDupplicated(newID);
            if (codeDupplicated) {
                System.out.println("Code is Dupplicated!");
            }
        } while (codeDupplicated == true);
        newName = Inputter.inputNonNlankStr("Name of new brand: ");
        newName = newName.toUpperCase();
        newSoundBrand = Inputter.inputNonNlankStr("Sound brand of new brand: ");
        newSoundBrand = newSoundBrand.toUpperCase();
        newPrice = Inputter.inputDouble();
        // create new brand
        Brand br = new Brand(newID, newName, newSoundBrand, newPrice);
        //Add new brand to the list
        this.add(br);
        System.out.println("Brand " + newID + " has been added.");
    }

    public void updateBrand() throws InterruptedException {
        if (this.isEmpty()) {
            System.out.println("Empty list. No update can be performed!");
        } else {
            String uID = Inputter.inputString("Input ID of updated brand:");
            Brand br = this.search(uID);//search brand
            if (br == null) {
                System.out.println("Brand " + uID + " doesn't existed!");
            } else {
                //update brand id
                String oldID = br.getBrandID();
                String msg = "Old ID: " + oldID + ", new ID: ";
                String newID = Inputter.inputNonNlankStr(msg);
                br.setBrandID(newID);
                //update brand name
                String oldName = br.getBrandName();
                msg = "Old name: " + oldName + ", new name: ";
                String newName = Inputter.inputNonNlankStr(msg);
                br.setBrandName(newName);
                //update sound brand
                String oldSoundBrand = br.getSoundBrand();
                msg = "Old sound brand: " + oldSoundBrand + ", new sound brand: ";
                String newSoundBrand = Inputter.inputNonNlankStr(msg);
                br.setSoundBrand(newSoundBrand);
                //update brand's price
                double oldPrice = br.getPrice();
                msg = "Old price: " + oldPrice + ", new price 0..1000: ";
                double newPrice = Inputter.inputDouble();
                br.setPrice(newPrice);
                System.out.println("Brand " + uID + " has been updated.");

            }
        }
    }

    public void listBrands() {
        if (this.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            System.out.println("Brand list: ");
            for (Brand br : this) {
                System.out.println(br);
            }
            System.out.println("Total: " + this.size() + " brand(s).");
        }
    }

}
