package ija.ija2016.reversi.board;

/**
 * Class Border field represents border of playing board
 * @author Patrik Segedy 
 * @author Tibor Dudlak
 */
public class BorderField implements Field, java.io.Serializable {

	private static final long serialVersionUID = 4767790484188912360L;

	@Override
	public void addNextField(Direction dirs, Field field) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Disk getDisk() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field nextField(Direction dirs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean putDisk(Disk disk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canPutDisk(Disk disk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean putStartDisk(Disk disk) {
		// TODO Auto-generated method stub
		return false;
	}

}
