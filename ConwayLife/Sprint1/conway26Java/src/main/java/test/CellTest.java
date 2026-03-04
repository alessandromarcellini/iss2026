package main.java.test;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.conway.domain.Cell;
import main.java.conway.domain.ICell;


public class CellTest {
	private ICell cell = new Cell(); // SIMBOLO, non istanza
	
	@Before
	public void setup() {
		System.out.println("ConwayLifeTest | setup");
	}

	@After
	public void down() {
		System.out.println("ConwayLifeTest | down");
	}
	
	
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

}
