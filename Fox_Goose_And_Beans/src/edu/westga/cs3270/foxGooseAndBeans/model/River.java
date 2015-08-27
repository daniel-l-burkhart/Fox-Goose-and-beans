/**
 * 
 */
package edu.westga.cs3270.foxGooseAndBeans.model;

import java.util.ArrayList;

/**
 * @author danielburkhart
 *
 */
public class River {

	private boolean fox;
	private boolean goose;
	private boolean beans;
	private boolean farmer;

	/**
	 * Constructor of class that initializes private instance variables to true
	 * signifying the west side of the bank.
	 */
	public River() {
		this.fox = true;
		this.goose = true;
		this.beans = true;
		this.farmer = true;
	}

	/**
	 * Copy Constructor of class that initializes private instance variables to
	 * true signifying the west side of the bank.
	 * 
	 * @param aRiver
	 *            The passed in river.
	 */
	public River(River aRiver) {
		this.fox = true;
		this.goose = true;
		this.beans = true;
		this.farmer = true;
	}

	/**
	 * Returns true if all four values return false.
	 * 
	 * @return
	 */
	public boolean solved() {
		if ((this.fox && this.goose && this.beans && this.farmer) == false) {
			return true;
		}
		return false;
	}

	/**
	 * The method that takes the farmer and one item across the river
	 * 
	 * @param anItem
	 *            The item that is passed in to be transported across the river.
	 */
	public void transportItem(Item anItem) {

		this.checkIfFoxEatsGoose();
		this.checkIfGooseEatsBeans();

		switch (anItem) {

		case GOOSE:

			this.moveItem(this.goose);

			this.checkIfFoxEatsGoose();
			this.checkIfGooseEatsBeans();

			break;

		case FOX:

			this.moveItem(this.fox);
			this.checkIfFoxEatsGoose();

			break;

		case BEANS:

			this.moveItem(this.beans);
			this.checkIfGooseEatsBeans();

			break;

		case NOTHING:
			break;
		}
	}

	/**
	 * Moves the passed in item from one side to the other
	 * 
	 * @param currentItem
	 *            the passed in item: fox, goose, or beans.
	 */
	private void moveItem(boolean currentItem) {
		if ((currentItem && this.farmer) || !(currentItem && this.farmer)) {
			this.farmer = false;
			currentItem = false;
		} else {
			throw new IllegalArgumentException("The current item and the farmer are not on the same side.");
		}
	}

	/**
	 * Checks to see that the goose and beans are not alone on the same side.
	 */
	private void checkIfGooseEatsBeans() {
		if ((this.goose == false && this.beans == false && this.farmer == true)
				|| (this.goose == true && this.beans == true && this.farmer == false)) {
			throw new IllegalStateException("The goose will eat the beans. Try again.");
		}
	}

	/**
	 * Checks to see if the fox and the goose are not alone on the same side.
	 */
	private void checkIfFoxEatsGoose() {
		if ((this.goose == false && this.fox == false && this.farmer == true)
				|| (this.goose == true && this.fox == true && this.farmer == false)) {
			throw new IllegalStateException("The fox will eat the goose. Try again.");
		}
	}

	/**
	 * Returns the status of all the items concerned.
	 */
	public String toString() {

		return "The items' current location is:\n" + this.farmer + "\n" + this.goose + "\n" + this.beans + "\n"
				+ this.fox + "\nThe items are on the east side" + "if the value is false and west if true";
	}

	/**
	 * Returns the number of moves.
	 * 
	 * @return
	 */
	public ArrayList<Item> getMoves() {
		ArrayList<Item> numberOfMoves = new ArrayList<Item>();

		return numberOfMoves;
	}
}
