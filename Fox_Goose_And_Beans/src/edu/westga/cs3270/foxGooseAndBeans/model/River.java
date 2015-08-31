/**
 * 
 */
package edu.westga.cs3270.foxGooseAndBeans.model;

import java.util.ArrayList;

/**
 * The river class.
 * 
 * @author danielburkhart
 * @version Fall 2015
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
	 * @return returns true if all the items are on the west side of the bank.
	 */
	public boolean solved() {

		return !this.fox && !this.beans && !this.goose && !this.farmer;
	}

	/**
	 * The method that takes the farmer and one item across the river
	 * 
	 * @param anItem
	 *            The item that is passed in to be transported across the river.
	 */
	public void transportItem(Item anItem) {
		switch (anItem) {
			
			case GOOSE:

				this.goose = this.moveItem(this.goose);
				this.checkIfFoxEatsGoose();
				this.checkIfGooseEatsBeans();
				break;

			case FOX:

				this.fox = this.moveItem(this.fox);
				this.checkIfFoxEatsGoose();
				this.checkIfGooseEatsBeans();
				this.goose = true;
				break;
				
			case BEANS:

				this.beans = this.moveItem(this.beans);
				this.checkIfGooseEatsBeans();
				this.checkIfFoxEatsGoose();
				this.goose = true;
				break;

			case NOTHING:
				this.farmer = true;
				break;

			default:
				break;

		}
	}

	/**
	 * Moves the passed in item from one side to the other
	 * 
	 * @param currentItem
	 *            the passed in item: fox, goose, or beans.
	 * @return returns the boolean value to be assigned to the item.
	 */
	private boolean moveItem(boolean currentItem) {

		boolean resultVal = false;

		if (currentItem == this.farmer) {
			this.farmer = false;
			resultVal = false;
		} else {
			throw new IllegalArgumentException("The current item and the farmer are not on the same side.");
		}
		return resultVal;
	}

	/**
	 * Checks to see that the goose and beans are not alone on the same side.
	 */
	private void checkIfGooseEatsBeans() {
		if ((this.goose == this.beans) && (this.goose != this.farmer)) {
			throw new IllegalStateException("The goose will eat the beans. Try again.");
		}
	}

	/**
	 * Checks to see if the fox and the goose are not alone on the same side.
	 */
	private void checkIfFoxEatsGoose() {

		if ((this.goose == this.fox) && (this.goose != this.farmer)) {
			throw new IllegalStateException("The fox will eat the goose. Try again.");
		}

	}

	/**
	 * Returns the status of all the items concerned.
	 * 
	 * @return A string location of all the items and their loation
	 */
	public String toString() {

		return "The items' current location is:\n" + "The Farmer: " + this.farmer + "\n" + "The Goose: " + this.goose
				+ "\n" + "The Beans: " + this.beans + "\n" + "The Fox: " + this.fox
				+ "\nThe goal value for all four items is false.";
	}

	/**
	 * Returns the number of moves.
	 * 
	 * @return An arrayList of the current valid moves
	 */
	public ArrayList<Item> getMoves() {
		ArrayList<Item> numberOfMoves = new ArrayList<Item>();

		if (this.farmer == this.fox) {
			this.addFox(numberOfMoves);
		}
		if (this.farmer == this.goose) {
			numberOfMoves.add(Item.GOOSE);
		}
		if (this.farmer == this.beans) {
			this.addBeans(numberOfMoves);
		}
		if ((this.goose != this.beans) || (this.goose != this.fox)) {

			numberOfMoves.add(Item.NOTHING);

		}

		return numberOfMoves;
	}

	/**
	 * Adds beans to list after making sure that goose and fox are not on the
	 * same side alone.
	 * 
	 * @param numberOfMoves
	 *            The list of items
	 */
	private void addBeans(ArrayList<Item> numberOfMoves) {
		if (this.goose != this.fox) {
			numberOfMoves.add(Item.BEANS);
		}
	}

	/**
	 * Adds fox to list after making sure that goose and beans are not on the
	 * same side alone.
	 * 
	 * @param numberOfMoves
	 *            the list of items
	 */
	private void addFox(ArrayList<Item> numberOfMoves) {
		if (this.goose != this.beans) {
			numberOfMoves.add(Item.FOX);
		}
	}
}
