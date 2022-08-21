package ie.tudublin.D18123630;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;


public class NewUI extends PApplet{

  ArrayList<Energy> Energy  = new ArrayList<Energy>();

    float speed;
    String label;
    int i;
    float resolution;
    float circleX;
    float circleY;
    float offset;
    float radius = 20;
    boolean authorPanelPop = false;
    float authorPanelOffset = 0;
    Airship A;
    Starmap S;
    int val;



    float qw;
    float as;
    String zx;
    float dir;


    float u= 150;
    float update = 5;
    private int y;


    public void setup(){

      A = new Airship(this);
      S = new Starmap(this);
    }

    public void settings(){
      loadEnergy();
      printEnergy();
      fullScreen();
    }

    public void loadEnergy()
    {
        Table table = loadTable("Ship.csv", "header");
        for(TableRow tr : table.rows())
        {
            Energy a = new Energy(tr);
            Energy.add(a);
            
        }   

    }
  
    public void printEnergy() 
    {
          for (Energy a : Energy) 
          {
              System.out.println("Energy:" + a);
          }
    
    }

    public void printEnergyInfo(int j)
    {   

        for (int i = 0; i < Energy.size(); i++) {
            text(Energy.get(j).getpower(),750, 60);
            text(Energy.get(j).getpeople(),750,100);
        }
    }




    public void draw(){


      resolution = map(sin((float) (offset*0.02)), -1, 1, 0, 4);
    
    
      for (int i = 0; i < resolution; i++) {

        float angle = (float) (map(i, 0, resolution, 0, TWO_PI*2) +frameCount/10.0);

    

        float circleOffsetX = cos(angle) * (radius); //xposition
        float circleOffsetY = sin(angle) * (radius); //yposition  
    
    
        float x = circleX + circleOffsetX;
        float y = circleY + circleOffsetY;

        
        offset++;

    
        ellipse(x, y, 5, 5);
      }


        background(10,10,30, 25);

        pushMatrix();
        translate(width/2, height/2);
        

  
    
        noFill();
        stroke(255, 100);
        strokeWeight(1);
        ellipse(0, 0, 30, 30);
        ellipse(0, 0, 60, 60);
        ellipse(0, 0, 90, 90);
        ellipse(0, 0, 120, 120);
        ellipse(0, 0, 160, 160);
        ellipse(0, 0, 185, 185);
        //----------------------//
        stroke(33, 211, 219);
        strokeWeight(5);
        strokeCap(SQUARE);
        noFill();
        rotate(radians(frameCount*2));
        arc(0, 0, 50, 50, radians(0), radians(50));
        arc(0, 0, 50, 50, radians(180), radians(230));
        //---------------------//;
        stroke(33, 211, 219);
        strokeWeight(5);
        strokeCap(SQUARE);
        noFill();
        rotate(-radians(frameCount*10));
        arc(0, 0, 75, 75, radians(0), radians(180));
        arc(0, 0, 75, 75, radians(90), radians(270));
    
        stroke(33, 211, 219);
        strokeWeight(5);
        strokeCap(SQUARE);
        noFill();
        rotate(radians(frameCount*7));
        arc(0, 0, 100, 100, radians(0), radians(50));
        arc(0, 0, 100, 100, radians(60), radians(110));
        arc(0, 0, 100, 100, radians(120), radians(170));
        arc(0, 0, 100, 100, radians(180), radians(230));
        arc(0, 0, 100, 100, radians(240), radians(290));
        arc(0, 0, 100, 100, radians(300), radians(350));
    
        //-----------------------//
        stroke(33, 211, 219);
        strokeWeight(5);
        strokeCap(SQUARE);
        noFill();
        rotate(radians(frameCount/5));
        arc(0, 0, 175, 175, radians(0), radians(60));
        arc(0, 0, 175, 175, radians(72), radians(132));
        arc(0, 0, 175, 175, radians(144), radians(204));
        arc(0, 0, 175, 175, radians(216), radians(276));
        arc(0, 0, 175, 175, radians(288), radians(348));



    
        popMatrix();
    
        pushMatrix();
        translate(width/2, height/2);
        strokeWeight(8);
        stroke(219, 29, 29,150);
        y+=update;
        println(mouseX,mouseY);
        arc(0, 0, 140, 140, radians(90), radians(y));
        stroke(48, 143, 224);
        arc(0, 0, 140, 140, -radians(y-180), radians(90));
        if(y >= 270){
          y = 100;
        }
    
        popMatrix();



        translate(width/2, height/2);


        //Circle Ring
        noFill();
        stroke(120,180,250, 150);
        strokeWeight(16);
        ellipse(0 ,0 , 250, 250);
        stroke(216,138,61, 150);
        strokeWeight(1);
        ellipse(0 ,0 , 280, 280);
        for(int i=0; i< 10; i++){
          float offsect = (float) (i*PI/5 + offset/100.0);
          stroke(10,10,30);
          strokeWeight(1);
          line(sin(offsect)*110, -cos(offsect)*110, sin(offsect)*135, -cos(offsect)*135);
          
          
          stroke(255, 255, 255, 150);
          strokeWeight(2);
          line(sin(offsect)*140, cos(offsect)*140, sin(offsect)*150, cos(offsect)*150);
        }
        
        for(int i=0; i< 50; i++){
          float offsect = (float) (i*PI/25 + offset/100.0);
          stroke(255, 255, 255, 150);
          strokeWeight(1);
          line(sin(offsect)*140, cos(offsect)*140, sin(offsect)*145, cos(offsect)*145);
          
          strokeWeight(1);
          point(sin(offsect)*50, -cos(offsect)*50);
          if(i%2==0){
            strokeWeight(2);
            point(sin(offsect)*60, cos(offsect)*60);
          }        



        }

        //wave
        beginShape();  
        vertex(10-width/2, (float) (height/3.0+ sin( (float) (-offset/50.0 + speed))*30));
        fill(220, 120, 200, 10);
        for(int i=10; i<width; i+=30){
          
          stroke(210,180,250, 150);
          strokeWeight(1);
          vertex(i-width/2, (float) (height/3.0 + sin((float) (i/100.0 - offset/50.0 + speed))*30));
        }
        vertex(width/1-10, height/3);
        vertex(width/2-10, height/2-10);
        vertex(10-width/1, height/2-10);
        
        endShape(); 

        //number
        fill(120, 220, 200);
        stroke(220, 120, 200);
        textSize(6);
        for(int i=0; i<height; i+=20){
          text(i*(int)random(0,5), -width/2+12, i-height/2);
        }

        //Author
        if(mouseX-width/2> width/2-90 && mouseY-height/2>height/3-120 && mouseX-width/2< width/2-90+60 && mouseY-height/2<height/3-110 +60){
          authorPanelPop = true;
          authorPanelOffset = min(200, authorPanelOffset+5);
          cursor(HAND);
        }else{
          authorPanelPop = false;
          authorPanelOffset = max(0, authorPanelOffset-8);
          cursor(ARROW);
        }

        fill(0);
        rect(width/2 -authorPanelOffset, height/3-260, 250, 40, 5);textSize(10);
        
        fill(120, 220, 0);
        text("Design By Junhan Dang 2022", width/2 -authorPanelOffset+50, height/3-240);
        textSize(20);

        noStroke();
        if(authorPanelPop){
          fill(216, 138, 61, 120);
          ellipse(width/2 -60, height/3-80, 70, 70);
        }else{
          fill(216, 138, 61, 10);
          ellipse(width/2 -60, height/3-80, 50, 50);
        }
        
        for(int i=0; i< 50; i++){
          float offsect = (float) (i*PI/25 + offset/100.0);
          stroke(255, 255, 255, 150);
          strokeWeight(1);
          point(width/2-60+ sin(offsect)*40, height/3-80-cos(offsect)*40);
        }


        translate(-800, 150);
        fill(255);
        stroke(0);
        rect(600, 40, 400, 100);

        fill(0);
        text("Airship:",640,60);
        text("Power:",640,100);
        printEnergyInfo(val);
        textSize(56);


        A.drawAirship();
        S.drawstarmap();


        
        
        

        

        


    
    }




    

    
  
  }