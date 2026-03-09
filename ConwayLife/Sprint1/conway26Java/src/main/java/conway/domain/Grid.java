package main.java.conway.domain;

import main.java.conway.domain.IGrid;
import main.java.conway.domain.ICell;
import main.java.conway.domain.Cell;

public class Grid implements IGrid {
	private ICell[][] cells;
	
	public Grid(int nCols, int nRows) {
		this.cells = new Cell[nCols][nRows];
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
	public int countAliveNeighbors(int x, int y) {
		int nAliveNeighbors = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (!(x + i < 0 || x + i >= this.getNumRows() || y + j < 0 || y + j >= this.getNumCols() || (i == 0 && j == 0))) {
					if (this.cells[x + i][y + j].isAlive()) {
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
		
		for (int i = 0; i < nCols; i++) {
			for (int j = 0; j < nRows; j++) {
				this.cells[i][j] = new Cell(false);
			}
		}
	}
	
	public void setCellStatus(boolean status, int x, int y) {
		this.cells[x][y].setStatus(status);
	}
	
	public boolean getCellStatus(int x, int y) {
		return this.cells[x][y].isAlive();
	}
}
