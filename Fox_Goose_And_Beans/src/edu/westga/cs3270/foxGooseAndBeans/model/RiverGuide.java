package edu.westga.cs3270.foxGooseAndBeans.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * The river guide class. Searches through the available river states to build
 * the solution set using a breadth-first search algoithm.
 *
 * @author danielburkhart
 * @version Fall 2015
 */
public class RiverGuide {

	private River aRiver;
	private HashSet<String> closed;
	private LinkedList<Item> solution;

	/**
	 * Constructor for RiverGuide class that instantiates variables.
	 */
	public RiverGuide() {
		this.aRiver = new River();
		this.closed = new HashSet<String>();
		this.solution = new LinkedList<Item>();
		this.closed.add(this.aRiver.toString());
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
		boolean solved;
		ArrayList<Item> items = aRiver.getMoves();

		for (Item anItem : items) {

			River nextState = aRiver.transportItem(anItem);

			if (!this.closed.contains(nextState.toString())) {
				this.closed.add(nextState.toString());
				solved = this.solve(nextState);
			}

			if (aRiver.solved()) {
				this.solution.addFirst(anItem);
				return true;
			}
		}

		return false;

	}

	/**
	 * The solution path.
	 *
	 * @return An arraylist containing the order in which to reach the solution.
	 */
	public LinkedList<Item> getSolution() {
		if (this.solution.isEmpty()) {
			this.solve(this.aRiver);
		}
		return this.solution;
	}
}
