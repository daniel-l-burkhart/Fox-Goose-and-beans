/**
 * 
 */
package edu.westga.cs3270.foxGooseAndBeans.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.westga.cs3270.foxGooseAndBeans.model.Item;
import edu.westga.cs3270.foxGooseAndBeans.model.River;

/**
 * Test class for putting methods under the river class under test.
 * 
 * @author danielburkhart
 * @version Fall 2015
 */
public class WhenTestingRiver {

	private River aRiver;
	private ArrayList<Item> items;

	/**
	 * Set up method that declares the variables for the tests.
	 * 
	 * @throws Exception
	 *             The exception that's thrown if error occurs.
	 */
	@Before
	public void setUp() throws Exception {
		this.aRiver = new River();
		this.items = new ArrayList<Item>();
	}

	/**
	 * Test method for
	 * {@link edu.westga.cs3270.foxGooseAndBeans.model.River#transportItem(edu.westga.cs3270.foxGooseAndBeans.model.Item)}
	 * .
	 */
	@Test
	public void testTransportItem() {

		this.aRiver.transportItem(Item.GOOSE);
		this.aRiver.transportItem(Item.NOTHING);
		this.aRiver.transportItem(Item.FOX);
		this.aRiver.transportItem(Item.NOTHING);
		this.aRiver.transportItem(Item.BEANS);
		this.aRiver.transportItem(Item.NOTHING);
		this.aRiver.transportItem(Item.GOOSE);

		assertTrue(this.aRiver.solved());
	}

	/**
	 * Test method for
	 * {@link edu.westga.cs3270.foxGooseAndBeans.model.River
	 * #transportItem(edu.westga.cs3270.foxGooseAndBeans.model.Item)}
	 * The second valid solution for the problem.
	 * .
	 */
	@Test
	public void secondTestTransportItem() {
		
		this.aRiver.transportItem(Item.GOOSE);
		this.aRiver.transportItem(Item.NOTHING);
		this.aRiver.transportItem(Item.BEANS);
		this.aRiver.transportItem(Item.NOTHING);
		this.aRiver.transportItem(Item.FOX);
		this.aRiver.transportItem(Item.NOTHING);
		this.aRiver.transportItem(Item.GOOSE);

		assertTrue(this.aRiver.solved());
	}

	/**
	 * Test method for
	 * {@link edu.westga.cs3270.foxGooseAndBeans.model.River#solved()}.
	 */
	@Test
	public void testSolved() {

		assertFalse(this.aRiver.solved());
	}

	/**
	 * Test method for
	 * {@link edu.westga.cs3270.foxGooseAndBeans.model.River#solved()}.
	 */
	@Test
	public void testSolvedAfterOneItem() {

		this.aRiver.transportItem(Item.GOOSE);

		assertFalse(this.aRiver.solved());
	}

	/**
	 * Method for forcing the program into an IllegalStateException for the 
	 * fox eating the goose.
	 */
	@Test(expected = IllegalStateException.class)
	public void foxEatsGoose() {

		this.aRiver.transportItem(Item.BEANS);
	}

	/**
	 * Method for forcing the program into an IllegalStateException for the
	 * goose eating the beans.
	 */
	@Test(expected = IllegalStateException.class)
	public void gooseEatsBeans() {

		this.aRiver.transportItem(Item.FOX);
	}

	/**
	 * Test method for
	 * {@link edu.westga.cs3270.foxGooseAndBeans.model.River#getMoves()}.
	 */
	@Test
	public void testGetMoves() {

		this.items = this.aRiver.getMoves();
		assertTrue(this.items.contains(Item.GOOSE));
		assertTrue(this.items.size() == 1);
	}

	/**
	 * Test method for
	 * {@link edu.westga.cs3270.foxGooseAndBeans.model.River#getMoves()}.
	 */
	@Test
	public void secondTestGetMoves() {
		this.aRiver.transportItem(Item.GOOSE);

		this.items = this.aRiver.getMoves();
		assertTrue(this.items.contains(Item.GOOSE));
		assertTrue(this.items.contains(Item.NOTHING));
		assertTrue(this.items.size() == 2);
	}

	/**
	 * Test method for
	 * {@link edu.westga.cs3270.foxGooseAndBeans.model.River#getMoves()}.
	 */
	@Test
	public void thirdTestGetMoves() {
		this.aRiver.transportItem(Item.GOOSE);
		this.aRiver.transportItem(Item.NOTHING);

		this.items = this.aRiver.getMoves();
		assertTrue(this.items.contains(Item.BEANS));
		assertTrue(this.items.contains(Item.NOTHING));
		assertTrue(this.items.contains(Item.FOX));
		assertTrue(this.items.size() == 3);
	}

}
