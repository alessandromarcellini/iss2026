package main.java.conway.domain;

public interface IGrid {
	
	public void resetGrid();
	
	public void setCellStatus(boolean status, int x, int y);
	public boolean getCellStatus(int x, int y);

}
