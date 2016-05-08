package ija.ija2016.reversi.board;

/**
 * Interface Field represents one field on board or border
 * @author Patrik Segedy 
 * @author Tibor Dudlak
 */
public interface Field {
	public static enum Direction { 
		L,
		R,
		U,
		D,
		LU,
		RD,
		LD,
		RU
	}
	
	/**
	 * Method add field in direction defined in dirs.
	 * @param dirs - direction.
	 * @param field - added field.
	 */
	void addNextField(Field.Direction dirs, Field field);
	
	/**
	 * Method returns disk from field
	 * @return disk
	 */
	Disk getDisk();
	
	/**
	 * Method returns neighbour field in direction dirs.
	 * @param dirs.
	 * @return field.
	 */
	Field nextField(Field.Direction dirs); 
	
	/**
	 * Puts disk.
	 * @param disk - disk to insert.
	 * @return <code>true</code> - when success;
     *         <code>false</code> - otherwise.
	 */
	boolean putDisk(Disk disk);
	
	/**
	 * Puts disk.
	 * @param disk - disk to insert.
	 * @return <code>true</code> - when success;
     *         <code>false</code> - otherwise.
	 */
	boolean putStartDisk(Disk disk);
	
	/**
	 * Puts disk.
	 * @param disk - disk to insert.
	 * @return <code>true</code> - when success;
     *         <code>false</code> - otherwise.
	 */
	boolean canPutDisk(Disk disk);
	
	/**
	 * Checks whether field is empty or not
	 * @return <code>true</code> - when field is empty;
     *         <code>false</code> - otherwise.
	 */
	boolean isEmpty();
	
}
