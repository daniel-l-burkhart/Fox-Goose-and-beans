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

	private final boolean hasWestFox;
	private final boolean hasWestGoose;
	private final boolean hasWestBeans;
	private final boolean hasWestFarmer;

	/**
	 * Constructor of class that initializes private instance variables to true
	 * signifying the west side of the bank.
	 */
	public River() {
		this.hasWestFox = true;
		this.hasWestGoose = true;
		this.hasWestBeans = true;
		this.hasWestFarmer = true;
	}

	/**
	 * Initialization constructor for all four variables
	 *
	 * @param hasWestFarmer
	 *            The farmer parameter
	 * @param hasWestGoose
	 *            the goose parameter
	 * @param hasWestFox
	 *            the fox parameter
	 * @param hasWestBeans
	 *            the beans parameter
	 */
	public River(boolean hasWestFarmer, boolean hasWestGoose, boolean hasWestFox, boolean hasWestBeans) {
		this.hasWestFarmer = hasWestFarmer;
		this.hasWestGoose = hasWestGoose;
		this.hasWestFox = hasWestFox;
		this.hasWestBeans = hasWestBeans;

	}

	/**
	 * Returns true if all four values return false.
	 *
	 * @return returns true if all the items are on the west side of the bank.
	 */
	public boolean solved() {

		return (!this.hasWestFox && !this.hasWestBeans && !this.hasWestGoose && !this.hasWestFarmer);
	}

	/**
	 * The method that takes the farmer and one item across the river
	 *
	 * @param anItem
	 *            The item that is passed in to be transported across the river.
	 * @return Returns the new River state.
	 */
	public River transportItem(Item anItem) {
		River newStateRiver;

		switch (anItem) {
			case GOOSE:
				newStateRiver = this.moveGoose();
				return newStateRiver;

			case FOX:
				newStateRiver = this.moveFox();
				return newStateRiver;

			case BEANS:
				newStateRiver = this.moveBeans();
				return newStateRiver;

			case NOTHING:
				newStateRiver = this.moveNothing();
				return newStateRiver;

			default:
				newStateRiver = null;
				return newStateRiver;
		}
	}

	/**
	 * Moves the farmer and the goose across the river.
	 * 
	 * @return a new River with the new locations of the farmer and the goose.
	 */
	private River moveGoose() {
		River aRiver = null;
		if (this.hasWestFarmer == this.hasWestGoose) {

			boolean goose = !(this.hasWestGoose);
			boolean farmer = !(this.hasWestFarmer);

			aRiver = new River(farmer, goose, this.hasWestFox, this.hasWestBeans);
			return aRiver;
		} else {
			throw new IllegalArgumentException("The farmer and the goose are not on the same side.");
		}

	}

	/**
	 * Moves the farmer and the fox across the river.
	 * 
	 * @return a new River with the new locations of the farmer and the fox.
	 */
	private River moveFox() {
		River aRiver = null;
		if (this.hasWestFarmer == this.hasWestFox) {

			boolean farmer = !(this.hasWestFarmer);
			boolean fox = !(this.hasWestFox);

			aRiver = new River(farmer, this.hasWestGoose, fox, this.hasWestBeans);
			this.checkifGooseEatsBeans(farmer, this.hasWestBeans);
			return aRiver;
			
		} else {
			throw new IllegalArgumentException("The farmer and the fox are not on the same side.");
		}
	}

	/**
	 * Checks to see if fox eats goose.
	 * 
	 * @param farmer
	 *            The farmer location at this state
	 * @param fox
	 *            The fox location at this state.
	 */
	private void checkifFoxEatsGoose(boolean farmer, boolean fox) {
		if (fox == this.hasWestGoose && this.hasWestGoose != farmer) {
			throw new IllegalStateException("The fox has eaten the goose.");
		}

	}

	/**
	 * Moves the farmer and the beans across the river.
	 * 
	 * @return a new River with the new locations of the farmer and the beans.
	 */
	private River moveBeans() {
		River aRiver = null;

		if (this.hasWestFarmer == this.hasWestBeans) {

			boolean farmer = !(this.hasWestFarmer);
			boolean beans = !(this.hasWestBeans);
			
			aRiver = new River(farmer, this.hasWestGoose, this.hasWestFox, beans);
			this.checkifFoxEatsGoose(farmer, this.hasWestFox);
			return aRiver;

		} else {
			throw new IllegalArgumentException("The farmer and the beans are not on the same side.");
		}

	}

	/**
	 * Checks to see if the goose eats the beans
	 * 
	 * @param farmer
	 *            The farmer location at this state
	 * @param beans
	 *            The beans' location at this state
	 */
	private void checkifGooseEatsBeans(boolean farmer, boolean beans) {
		if (beans == this.hasWestGoose && this.hasWestGoose != farmer) {
			throw new IllegalStateException("The goose has eaten the beans.");
		}
	}

	/**
	 * Moves the farmer and nothing across the river.
	 * 
	 * @return a new River with the new locations of the farmer and nothing.
	 */
	private River moveNothing() {

		River currentRiver = null;

		boolean farmer = !this.hasWestFarmer;
		currentRiver = new River(farmer, this.hasWestGoose, this.hasWestFox, this.hasWestBeans);
		return currentRiver;
	}

	/**
	 * Returns the status of all the items concerned.
	 *
	 * @return A string location of all the items and their loation
	 */
	public String toString() {
		return String.format("[Farmer: %s, Fox: %s, Goose: %s, Beans: %s]", this.getRiverBank(this.hasWestFarmer),
				this.getRiverBank(this.hasWestFox), this.getRiverBank(this.hasWestGoose),
				this.getRiverBank(this.hasWestBeans));
	}

	/**
	 * Helper output method for string output
	 *
	 * @param hasItem
	 *            The item in question.
	 * @return A string if the item is east or west.
	 */
	private String getRiverBank(boolean hasItem) {
		if (hasItem) {
			return "west";
		}
		return "east";
	}

	/**
	 * Returns the number of moves.
	 *
	 * @return An arrayList of the current valid moves
	 */
	public ArrayList<Item> getMoves() {
		ArrayList<Item> numberOfMoves = new ArrayList<Item>();

		if (this.hasWestFarmer == this.hasWestFox) {
			this.addFox(numberOfMoves);
		}
		if (this.hasWestFarmer == this.hasWestGoose) {
			numberOfMoves.add(Item.GOOSE);
		}
		if (this.hasWestFarmer == this.hasWestBeans) {
			this.addBeans(numberOfMoves);
		}
		if ((this.hasWestGoose != this.hasWestBeans) || (this.hasWestGoose != this.hasWestFox)) {
			numberOfMoves.add(Item.NOTHING);

		}

		return numberOfMoves;
	}

	/**
	 * private helper method that provides the additional check ensuring the
	 * goose and the fox are not on the same side alone before adding the beans
	 * to the solution set.
	 *
	 * @param numberOfMoves
	 *            The list of items
	 */
	private void addBeans(ArrayList<Item> numberOfMoves) {
		if (this.hasWestGoose != this.hasWestFox) {
			numberOfMoves.add(Item.BEANS);
		}
	}

	/**
	 * private helper method that provides the additional check ensuring the
	 * goose and the beans are not on the same side alone before adding the fox
	 * to the solution set.
	 *
	 * @param numberOfMoves
	 *            the list of items
	 */
	private void addFox(ArrayList<Item> numberOfMoves) {
		if (this.hasWestGoose != this.hasWestBeans) {
			numberOfMoves.add(Item.FOX);
		}
	}
}
