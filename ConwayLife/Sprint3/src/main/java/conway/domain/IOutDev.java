package conway.domain;
/*
 * Contratto definito dalla business logic
 */
public interface IOutDev {
	public void display(String msg);      //For HMI
	public void close();
	public void displayGrid(IGrid grid);
	public void displayCell(IGrid grid, int x, int y);

}
