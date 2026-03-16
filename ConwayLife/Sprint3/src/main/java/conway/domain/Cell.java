package conway.domain;

public class Cell implements ICell {
	// Definisco la rappresentazione Concreta di una cella
	
	private boolean status;
	
	public Cell(boolean status) {
		this.status = status;
	}

	@Override
	public void setStatus(boolean newStatus) {
		this.status = newStatus;
	}

	@Override
	public boolean isAlive() {
		return this.status;
	}
	
	public void switchState() {
		this.status = !this.status;
	}

}
