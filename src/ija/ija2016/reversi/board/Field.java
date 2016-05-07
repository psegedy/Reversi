/**
 * Interface 
 * @author Patrik Segedy 
 * @author Tibor Dudl�k
 */
package ija.ija2016.reversi.board;

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
	 * Pøidá sousední pole field v daném smìru dirs.
	 * @param dirs - Smìr ve kterém se pøidává pole.
	 * @param field - Pøidávané pole.
	 */
	void addNextField(Field.Direction dirs, Field field);
	
	/**
	 * Vrací kámen, který je vložen na pole.
	 * @return Vložený kámen. Pokud je pole prázdné, vrací null.
	 */
	Disk getDisk();
	
	/**
	 * Vrátí sousední pole v daném smìru dirs.
	 * @param dirs - Smìr ve kterém se pøidává pole.
	 * @return Sousední pole v daném smìru dirs.
	 */
	Field nextField(Field.Direction dirs); 
	
	/**
	 * Vloží na pole kámen.
	 * @param disk - Vkládaný kámen.
	 * @return Vrací úspìšnost akce. Pokud je pole již obsazeno, vrací false.
	 */
	boolean putDisk(Disk disk);
	boolean putStartDisk(Disk disk);
	
	boolean canPutDisk(Disk disk);
	boolean isEmpty();
	
}
