package edu.iastate.cs2280.hw2;

import java.util.Comparator;

public class XComparator implements Comparator<Point>{
	@Override
	public int compare(Point a, Point b) {
		Point.xORy = true;
		return a.compareTo(b);
	}
}
