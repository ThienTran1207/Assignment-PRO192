import java.util.ArrayList;
public class CarList extends ArrayList<Car>{
    public BrandList blist;
    public CarList(BrandList bList){
        this.blist = bList;
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
    private boolean isExistBrandID(String code, BrandList t){
        boolean check = false;
        code = code.trim().toUpperCase();
        for (int i = 0; i < t.size(); i++) {
            if(t.get(i).getBrandID().compareToIgnoreCase(code) == 0){
                check = true;
                break;
            }
        }
        return check;
    }
    private int BrandIndex(String code, BrandList t){
        int result = 0;
        for (int i = 0; i < t.size(); i++) {
            if(t.get(i).getBrandID().compareTo(code) == 0){
                result = i;
            }
        }
        return result;
    }
    public void addCar(){
        String newId, brandID, newColor, newFrameID, newEngineID = null;
        Brand brand;
        int brandIndex = 0;
        boolean isExist = false, isDuplicate = true;
        do{
            newId = Inputter.inputString("Enter Car Id: ");
            newId = newId.trim().toUpperCase();
            isDuplicate = isCodeDupplicated(newId);
            brandID = Inputter.inputString("Enter Brand Id: ");
            brandID = brandID.toUpperCase();
            isExist = isExistBrandID(brandID, this.blist);
            brandIndex = BrandIndex(brandID, this.blist);
            if(isDuplicate){
                System.out.println("Car ID is dupplicate");
            }
            else if(isExist == false){
                System.out.println("Brand ID is not exist");
            }
            
        } while(isExist == false || isDuplicate == true);
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
    public boolean removeCar(){
        String removedID = Inputter.inputString("Enter the car's ID want to remove: ");
        int pos = searchID(removedID);
        if(pos < 0){
            System.out.println("Not found!");
            return false;
        }
        else {
            this.remove(pos);
            System.out.println("The car with ID: " + removedID + " has been removed");
            return true;
        }
    }
    public boolean updateCar(){
        String updateID = Inputter.inputString("Enter the car's ID want to update: ");
        int pos = searchID(updateID);
        if(pos < 0){
            System.out.println("Not found!");
            return false;
        }
        else{
            Menu mn = new Menu();
            Brand b = (Brand)mn.ref_getChoice(this.blist);
            String updateColor = Inputter.inputNonNlankStr("Enter the new Color for car:");
            String updateFrameID = Inputter.inputFrameID("Enter the new Frame ID for car:");
            String updateEngineID = Inputter.inputEngineID("Enter the new Engine ID for car:");
            this.set(pos, new Car(updateID, b, updateColor, updateID, updateID));
            System.out.println("The car with ID: " + updateID + " has been updated!" );
        }
        return true;
    }
    // use for updateCar();
    public int searchID(String carID){
        carID = carID.trim().toUpperCase();
        int index = -1;
        int n = this.size();
        for (int i = 0; i < n; i++) {
            if(this.get(i).getCarID().compareToIgnoreCase(carID) == 0){
                index = i;
            }
        }
        return index;
    }
}
