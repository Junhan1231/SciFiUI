package ie.tudublin.D18123630;

public class Starmap {

    
    NewUI ui;

    public Starmap(NewUI ui){
        this.ui=ui;
    }

    public void drawstarmap(){

        ui.translate(-1300,-10);
        ui.noFill();
        ui.stroke(255,255,255);
        ui.circle(600,300,230);
        ui.circle(600,300,280);
        ui.circle(600,300,330);
        ui.circle(600,300,380);
        ui.circle(600,300,430);
        ui.circle(600,300,480);
        ui.circle(600,300,530);
        ui.fill(255,224,14);
        ui.circle(600,300,100);
        ui.fill(159,104,59);
        ui.circle(400,210,30);
        ui.fill(68,175,224);
        ui.circle(740,300,40);
        ui.fill(235,0,0);
        ui.circle(470,360,50);
        ui.fill(255,131,0);
        ui.circle(550,500,70);


    }


    
}
