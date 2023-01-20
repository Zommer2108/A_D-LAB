package de.hska.iwi.ads.solution.interfaces;

import de.hska.iwi.ads.interfaces.*;

public class Circle extends AbstractCircle  {

	public Circle(double radius) {
		super(radius);
		// TODO Auto-generated constructor stub
	}

	public Circle(Vector middlePoint, double radius) {
		super(middlePoint, radius);
		
		
	}
	
	@Override
	public void scale(double factor) {
		// Radius größer als 1
		if(factor>1) {
			radius = super.getRadius()*factor;
		}
		// Radius zwischen 0 und 1 (1 nicht mit eingeschlossen)
		else if(factor >= 0 & factor < 1){
			radius = super.getRadius()*factor;
		}
		// "sonst, mache nichts"
		else; 
	}

	@Override
	public double getDimension() {
		
		return super.getRadius();
	}

	@Override
	public double area() {
		return Math.PI*(super.getRadius()*super.getRadius());
	}

}
