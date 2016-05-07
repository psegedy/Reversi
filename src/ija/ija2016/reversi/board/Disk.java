/**
 * 
 * @author Patrik Segedy
 * @author Tibor Dudlák
 */
package ija.ija2016.reversi.board;

public class Disk implements java.io.Serializable {
	
	private static final long serialVersionUID = 3166896002752168247L;
	private boolean isWhite;
	private boolean isFreezed;

	/**
	 * 
	 * @param isWhite
	 */
	public Disk(boolean isWhite) {
		this.isWhite = isWhite;
		isFreezed = false;
	}	
	
	/**
	 * 
	 */
	public void turn() {
		if (isWhite == true)
			isWhite = false;
		else
			isWhite = true;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isWhite() {
		return isWhite;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isFreezed() {
		return isFreezed;
	}
	
	/**
	 * 
	 * @param isFreezed
	 */
	public void freezeDisk(boolean isFreezed) {
		this.isFreezed = isFreezed;
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
