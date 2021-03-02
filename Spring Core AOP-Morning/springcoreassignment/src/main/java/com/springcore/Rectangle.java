package com.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Rectangle {

	@Autowired
	private Point point1;

	@Autowired
	private Point point2;

	@Autowired
	private Point point3;

	@Autowired
	private Point point4;

	private int height;
	private int width;

	public Rectangle(Point point1, Point point2, Point point3, Point point4, int height, int width) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
		this.point4 = point4;
		this.height = height;
		this.width = width;
	}

	public void draw() {
		System.out.println("Point 1 is " + "(" + point1.getX() + "," + point1.getY() + ")");
		System.out.println("Point 2 is " + "(" + point2.getX() + "," + point2.getY() + ")");
		System.out.println("Point 3 is " + "(" + point3.getX() + "," + point3.getY() + ")");
		System.out.println("Point 4 is " + "(" + point4.getX() + "," + point4.getY() + ")");
		System.out.println("Height is " + height);
		System.out.println("Width is " + width);
	}

	public Point getPoint1() {
		return point1;
	}

	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public void setPoint2(Point point2) {
		this.point2 = point2;
	}

	public Point getPoint3() {
		return point3;
	}

	public void setPoint3(Point point3) {
		this.point3 = point3;
	}

	public Point getPoint4() {
		return point4;
	}

	public void setPoint4(Point point4) {
		this.point4 = point4;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
