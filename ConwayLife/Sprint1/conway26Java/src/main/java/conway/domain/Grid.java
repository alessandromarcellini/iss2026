package main.java.conway.domain;

import main.java.conway.domain.IGrid;
import main.java.conway.domain.ICell;
import main.java.conway.domain.Cell;

public class Grid implements IGrid {
	private ICell[][] cells;
	
	public Grid(int nCols, int nRows) {
		this.cells = new Cell[nRows][nCols];
		this.resetGrid();
	}
	
	// Operazioni primitive
	public int getNumRows() {
		return this.cells.length;
	}
	
	public int getNumCols() {
		return this.cells[0].length;
	}
	
	// Operazioni non primitive
	public int countAliveNeighbors(int row, int col) {
		int nAliveNeighbors = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (!(row + i < 0 || row + i >= this.getNumRows() || col + j < 0 || col + j >= this.getNumCols() || (i == 0 && j == 0))) {
					if (this.cells[row + i][col + j].isAlive()) {
						nAliveNeighbors++;
					}
				}
			}	
		}
		return nAliveNeighbors;
	}
	
	public void resetGrid() {
		int nCols = this.getNumCols();
		int nRows = this.getNumRows();
		
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				this.cells[i][j] = new Cell(false);
			}
		}
	}
	
	public void setCellStatus(boolean status, int row, int col) {
		if (row >= 0 && row < getNumRows() && col >= 0 && col < getNumCols()) {
		    cells[row][col].setStatus(status);
		}
	}
	
	public boolean getCellStatus(int row, int col) {
		if (row >= 0 && row < getNumRows() && col >= 0 && col < getNumCols()) {
			return this.cells[row][col].isAlive();
		}
		return false; // can be done better
	}
	
	public ICell getCell(int row, int col) {
		return this.cells[row][col];
	}
}
