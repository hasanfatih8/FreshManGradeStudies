package sýnav;

public class SimpleItem implements Item {
    private String name;
    public double price;

    public SimpleItem(String aName, double aPrice){
        name = aName;
        price = aPrice;
    }

    public String getName(){return name;}
    public double getPrice(){return price;}

    public String toString(){
        return (getName() + "$" + getPrice());
    }
}
