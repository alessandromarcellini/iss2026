package main.java.conway.domain;

public interface IGrid {
	// La griglia è una composizione di celle
	
	
	// Operazioni primitive
	public int getNumRows(); // Restituisce il numero di righe di cui è composta la griglia
	public int getNumCols(); // Restituisce il numero di colonne di cui è composta la griglia
	
	// Operazioni non primitive
	public int countAliveNeighbors(int row, int col); // Restituisce il numero di vicini vivi per una specificata cella
	public void resetGrid(); // La griglia può essere resettata allo stato iniziale (tutte celle "morte")
	public void setCellStatus(boolean status, int row, int col); // La griglia deve permettere di settare lo stato di una sua cella
	public boolean getCellStatus(int row, int col); // La griglia deve permettere di controllare lo stato di una sua cella
}
