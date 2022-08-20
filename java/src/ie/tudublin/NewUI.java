package ie.tudublin;

import processing.core.PApplet;

public class NewUI extends PApplet{

    float speed;
    float xPos, yPos, w, h;
    String label;
    int i;
    float resolution;
    float circleX;
    float circleY;
    float offset;
    float radius = 20;
    boolean authorPanelPop = false;
    float authorPanelOffset = 0;


    float qw;
    float as;
    String zx;
    float dir;


    float u= 150;
    float update = 5;
    private int y;

    public void settings(){
        fullScreen();
    }

    public void draw(){


      resolution = map(sin((float) (offset*0.02)), -1, 1, 0, 4);
    
    
      for (int i = 0; i < resolution; i++) {
        
        float angle = (float) (map(i, 0, resolution, 0, TWO_PI*2) +frameCount/10.0);
        //float waveOffset = sin(angle*circles) * 200;
    

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
        

  
        //Draw the circle
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
          //point(sin(i*PI/5)*50, cos(i*PI/5)*50);
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
          
          stroke(2120,180,250, 150);
          strokeWeight(1);
          vertex(i-width/2, (float) (height/3.0 + sin((float) (i/100.0 - offset/50.0 + speed))*30));
        }
        vertex(width/2-10, height/3);
        vertex(width/2-10, height/2-10);
        vertex(10-width/2, height/2-10);
        
        endShape(); 


        fill(120, 220, 200);
        stroke(220, 120, 200);
        textSize(6);
        for(int i=0; i<height; i+=20){
          text(i*(int)random(0,5), -width/2+12, i-height/2);
        }


        


        


    
    }


    



    

    
  
  }
