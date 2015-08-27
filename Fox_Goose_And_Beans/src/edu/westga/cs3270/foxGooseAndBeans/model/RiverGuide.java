package edu.westga.cs3270.foxGooseAndBeans.model;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author danielburkhart
 *
 */
public class RiverGuide {

	private River aRiver;
	private HashSet<String> closed;
	private ArrayList<Item> solution;

	public RiverGuide() {
		this.aRiver = new River();
		this.closed = new HashSet<String>();
		this.solution = new ArrayList<Item>();
	}

	private boolean solve(River aRiver) {
		return false;
	}

	public ArrayList<Item> getSolution() {
		return this.solution;
	}
}
