package ija.ija2016.reversi.board;

public class Disk {
	
	private boolean isWhite;

	public Disk(boolean isWhite) {
		this.isWhite = isWhite;
	}	
	
	public void turn() {
		if (isWhite == true)
			isWhite = false;
		else
			isWhite = true;
	}
	
	public boolean isWhite() {
		if (isWhite == true)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disk other = (Disk) obj;
		if (isWhite != other.isWhite)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isWhite ? 1231 : 1237);
		return result;
	}
}
