package edu.westga.cs3270.foxGooseAndBeans.model;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * The river guide class.
 * 
 * @author danielburkhart
 * @version Fall 2015
 */
public class RiverGuide {

	private River aRiver;
	private HashSet<String> closed;
	private ArrayList<Item> solution;

	/**
	 * Constructor for RiverGuide class that instantiates variables.
	 */
	public RiverGuide() {
		this.aRiver = new River();
		this.closed = new HashSet<String>();
		this.solution = new ArrayList<Item>();
	}

	/**
	 * Method recursively search until it finds the solution.
	 * 
	 * @param aRiver
	 *            The current river scenario
	 * 
	 * @return True once a solution is found. False otherwise.
	 */
	private boolean solve(River aRiver) {
		return false;
	}

	/**
	 * The solution path.
	 * 
	 * @return An arraylist containing the order in which to reach the solution.
	 */
	public ArrayList<Item> getSolution() {
		if (this.solution.isEmpty()) {
			this.solve(this.aRiver);
		}
		return this.solution;
	}
}
