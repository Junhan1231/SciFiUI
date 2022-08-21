package ie.tudublin;

public class Airship {

    NewUI ui;

    public Airship(NewUI ui){
        this.ui=ui;
    }

    public void drawAirship(){

        
        ui.translate(900,-450);
        ui.noStroke();
        ui.fill(175);
        ui.rect(410,209,127,304);
        ui.fill(120,180,250);
        ui.ellipse(474,225,129,401);
        ui.fill(175);
        ui.rect(302,281,48,255);
        ui.ellipse(326,286,48,226);
        ui.rect(598,281,48,255);
        ui.ellipse(622,286,48,226);
    
        ui.fill(16,20,25, 30);
        ui.triangle(532,22,556,519,357,533);
    
        ui.fill(16,20,25, 20);
        ui.triangle(399,375,252,529,434,537);
        ui.triangle(543,367,516,543,712,537);    
    
        ui.noStroke();
        ui.fill(200);
        ui.triangle(435,367,252,540,434,537);
        ui.triangle(516,367,516,537,697,537);  
    
        ui.noStroke();
        ui.fill(248);
        ui.rect(432,308,85,229);
        ui.ellipse(474,317,86,262);
    
        ui.noStroke();
        ui.fill(68, 101, 120);
        ui.circle(475, 294, 20);
        ui.circle(475, 327, 20);
        ui.circle(475, 398, 20);
    
        ui.fill(160, 10, 10);
        ui.circle(444, 408, 7);
        ui.circle(444, 394, 7);
    
        ui.strokeWeight(7);
        ui.stroke(66, 70, 73);
        ui.line(444,476,444,518);
    
        ui.strokeWeight(7);
        ui.stroke(206, 207, 207);
        ui.line(310,269,310,473);
        ui.line(308,561,343,561);
        ui.line(605,561,638,561);
        ui.line(308,548,343,548);
        ui.line(605,548,638,548);
    
        ui.strokeWeight(7);
        ui.stroke(162, 162, 162);   
        ui.line(445,552,502,552);
        ui.line(445,543,502,543);
    
        ui.noStroke();
        ui.fill(16,20,25, 20);
        ui.triangle(655,324,707,538,461,537);
        
        ui.fill(156, 30);
        ui.triangle(476,199,507,270,476,494);


    }
    
}
