package ie.tudublin;

import processing.data.*;

public class Energy {

    private String power;
    private String people;

    public Energy(String power,String people){
        this.power =power;
        this.people= people;
    }

    public String toString(){
        return "\n" + power + "\n" + people + "\n";

    }

    public Energy(TableRow tr)
    {
        
        power = tr.getString("power");
        people = tr.getString("people");
    }

    public String getpower() {
        return power;
    }

    public void setpower(String power) {
        this.power = power;
    }

    public String getpeople(){
        return people;
    }

    public void setpeople(String people){
        this.people = people ;
    }


    
}
