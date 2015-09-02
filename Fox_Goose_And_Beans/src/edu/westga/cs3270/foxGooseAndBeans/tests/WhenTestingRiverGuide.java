package edu.westga.cs3270.foxGooseAndBeans.tests;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

import edu.westga.cs3270.foxGooseAndBeans.model.Item;
import edu.westga.cs3270.foxGooseAndBeans.model.RiverGuide;

/**
 * Testing the River Guide class.
 *
 * @author dburkha1
 * @version Fall 2015
 */
public class WhenTestingRiverGuide {

	/**
	 * Testing whether the river guide solve causes the solution order to be
	 * created.
	 */
	@Test
	public void whenTestingGuideShouldGetAnOrder() {
		RiverGuide currentGuide = new RiverGuide();

		LinkedList<Item> solutions = currentGuide.getSolution();

		System.out.println("Solution size: " + solutions.size());
		for (Item anItem : solutions) {
			System.out.println(anItem);
		}

		assertEquals(7, solutions.size());
	}

}
