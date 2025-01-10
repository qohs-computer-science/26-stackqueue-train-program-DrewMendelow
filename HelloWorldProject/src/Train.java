public class Train {
    private String name, product, origin, destination;
    private int weight, miles;
    private boolean isEngine;
    
    public Train(String Name, String Product, String Origin, String Destination, int Weight, int Miles, boolean IsEngine){
        name = Name;
        product = Product;
        origin = Origin;
        destination = Destination;
        weight = Weight;
        miles = Miles;
        isEngine = IsEngine;
    }

    public String getName(){
        return name;
    }

    public void setName(String val){
        name = val;
    }

    public String getProduct(){
        return product;
    }

    public void setProduct(String val){
        product = val;
    }

    public String getOrigin(){
        return origin;
    }

    public void setOrigin(String val){
        origin = val;
    }

    public String getDestination(){
        return destination;
    }

    public void setDestination(String val){
        destination = val;
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int val){
        weight = val;
    }

    public int getMiles(){
        return miles;
    }

    public void setMiles(int val){
        miles = val;
    }

    public boolean getIsEngine(){
        return isEngine;
    }

    public void setIsEngine(boolean val){
        isEngine = val;
    }
}
