package conway.domain;


public interface ICell {
	
	public void setStatus(boolean newStatus); // ha la possibilità di cambiare il suo stato interno tra true e false
	public boolean isAlive(); // La cella ha la capacità di rispondere a questa query con lo stato della cella ("viva" o "morta")
	public void switchState(); // La cella è capace di cambiare il suo stato interno da "viva" a "morta" o viceversa
}