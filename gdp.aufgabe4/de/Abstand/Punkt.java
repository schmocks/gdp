package de.Abstand;

import java.text.DecimalFormat;

public class Punkt {
int xpos;
int ypos;
int index;



public String toString(){
	return "P"+index+ " = ("+xpos+"|"+ypos+")";

}


Punkt(int i, int x, int y){
	xpos=x;ypos=y;index=i;
}

public String getAbstand(Punkt punkt){
	int x = punkt.getX();
	int y = punkt.getY();
	DecimalFormat df = new DecimalFormat("0.00");
	double d = Math.sqrt((x-xpos)*(x-xpos)+(y-ypos)*(y-ypos));
	return df.format(d);
	
	
}

public int getX(){
	return xpos;
}

public int getY(){
	return ypos;
}

public int getIndex(){
	return index;
}


}

