package main.java.test;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import conway.domain.Cell;
import conway.domain.ICell;


public class CellTest {
	private ICell cell = new Cell(false);
	
	@Before
	public void setup() { // runs before every test to setup the environment
		System.out.println("ConwayLifeTest | setup");
	}

	@After
	public void down() { // runs after every test to destroy the environment
		System.out.println("ConwayLifeTest | down");
	}
	
	// isAlive and setStatus TESTS ------------------------------------------
	@Test
	public void testCellAlive() {
		cell.setStatus(true);
		
		assertTrue(cell.isAlive());
	}	
	@Test
	public void testCellDead() {
		cell.setStatus(false);
		
		assertFalse(cell.isAlive());
	}
	
	// switchState TESTS -----------------------------------------------------
	@Test
	public void testSwitchToAlive() {
		cell.setStatus(false);
		
		cell.switchState();
		assertTrue(cell.isAlive());
	}
	
	@Test
	public void testSwitchToUnalive() {
		cell.setStatus(true);
		
		cell.switchState();
		assertFalse(cell.isAlive());
	}
}
