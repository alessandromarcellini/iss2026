package main.java.test;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.conway.domain.Grid;
import main.java.conway.domain.IGrid;


public class GridTest {
	private IGrid grid = new Grid(10, 10);
	
	@Before
	public void setup() { // runs before every test to setup the environment
		System.out.println("ConwayLifeTest | setup");
	}

	@After
	public void down() { // runs after every test to destroy the environment
		System.out.println("ConwayLifeTest | down");
	}
	
	// ROWS AND COLS GETTERS TESTS ------------------------------------------
	@Test
	public void testNRows() {
		int nRows = 10;
		this.grid = new Grid(nRows, 10);
		assertEquals(nRows, this.grid.getNumRows());
	}
	
	@Test
	public void testNCols() {
		int nCols = 10;
		this.grid = new Grid(10, nCols);
		assertEquals(nCols, this.grid.getNumCols());
	}
	
	// SET CELL STATUS AND GET CELL STATUS TESTS ------------------------------------------
	@Test
	public void setCellStatusUnaliveTest() {
		int cellX = 5;
		int cellY = 5;
		
		grid.resetGrid();
		
		this.grid.setCellStatus(false, cellX, cellY);
		assertFalse(this.grid.getCellStatus(cellX, cellY));
	}
	
	@Test
	public void setCellStatusAliveTest() {
		int cellX = 5;
		int cellY = 5;
		
		grid.resetGrid();
		
		this.grid.setCellStatus(true, cellX, cellY);
		assertTrue(this.grid.getCellStatus(cellX, cellY));
	}
	
	// RESET GRID TESTS ------------------------------------------
	@Test
	public void testResetGrid( ) {
		// making every cell alive
		for (int i = 0; i < this.grid.getNumRows()) {
			for (int j = 0; j < this.grid.getNumCols()) {
				this.grid.setCellStatus(true, i, j);
			}
		}
		// resetting the grid
		this.grid.resetGrid();
		
		// testing every cell is dead
		for (int i = 0; i < this.grid.getNumRows()) {
			for (int j = 0; j < this.grid.getNumCols()) {
				assertFalse("Every cell should be dead after reset", this.grid.getCellStatus(i, j));
			}
		}	
	}
	
	// COUNT ALIVE NEIGHBORS TESTS ------------------------------------------
	@Test
	public void testCountAliveCenterNeighbors() {
		int cellX = 5;
		int cellY = 5;
		
		// ensure every cell is dead
	    grid.resetGrid();

	    // make some neighbors alive around the selected cell
	    grid.setCellStatus(true, cellX - 1, cellY); // above
	    grid.setCellStatus(true, cellX, cellY - 1); // left
	    grid.setCellStatus(true, cellX + 1, cellY + 1); // bottom-right

	    int aliveNeighbors = grid.countAliveNeighbors(cellX, cellY);

	    assertEquals("Cell (5,5) should have 3 alive neighbors", 3, aliveNeighbors);
	}
	
	@Test
	public void testCountAliveCornerNeighbors() {
	    int cellX = 0;
	    int cellY = 0;

	    // ensure every cell is dead
	    grid.resetGrid();

	    // make neighbors alive around the selected corner cell
	    grid.setCellStatus(true, cellX, cellY + 1);     // right
	    grid.setCellStatus(true, cellX + 1, cellY);     // below
	    grid.setCellStatus(true, cellX + 1, cellY + 1); // bottom-right

	    int aliveNeighbors = grid.countAliveNeighbors(cellX, cellY);

	    assertEquals("Corner cell (0,0) should have 3 alive neighbors", 3, aliveNeighbors);
	}
}
