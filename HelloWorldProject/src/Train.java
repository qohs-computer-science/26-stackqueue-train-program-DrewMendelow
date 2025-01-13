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
    }//end Train

    public String getName(){
        return name;
    }//end getName

    public void setName(String val){
        name = val;
    }//end setName

    public String getProduct(){
        return product;
    }//end getProduct

    public void setProduct(String val){
        product = val;
    }//end setProduct

    public String getOrigin(){
        return origin;
    }//end getOrigin

    public void setOrigin(String val){
        origin = val;
    }//end setOrigin

    public String getDestination(){
        return destination;
    }//end getDestination

    public void setDestination(String val){
        destination = val;
    }//end setDestination

    public int getWeight(){
        return weight;
    }//end getWeight

    public void setWeight(int val){
        weight = val;
    }//end setWeight

    public int getMiles(){
        return miles;
    }//end getMiles

    public void setMiles(int val){
        miles = val;
    }//end setMiles

    public boolean getIsEngine(){
        return isEngine;
    }//end getIsEngine

    public void setIsEngine(boolean val){
        isEngine = val;
    }//end setIsEngine
}//end class
