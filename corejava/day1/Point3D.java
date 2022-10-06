package com.valtech.training.corejava.day1;

public class Point3D extends Point implements Comparable <Point>  {

	
	private int z;
	
	public Point3D (int x, int y, int z) {
		super(x,y);
		this.z=z;
	}
	
	@Override
	public double distance(){
		System.out.println("distance of point 3d");
		return Math.sqrt(x*x+y*y+z*z);
	}
	
	public double distance(int x,int y,int z) {
		int dx=this.x-x;
		int dy=this.y-y;
		int dz=this.z-z;
		return Math.sqrt(dx*dx+dy*dy+dz*dz);
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
this.z = z;
}
public static void main(String[] args) {
		final Point p = new Point3D(10,20,30);
		System.out.println(p.distance());
	}
}



