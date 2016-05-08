package ija.ija2016.reversi.board;
/**
 * Class Disk represents one disk on board
 * @author Patrik Segedy
 * @author Tibor Dudlak
 */
public class Disk implements java.io.Serializable {
    
    private static final long serialVersionUID = 3166896002752168247L;
    private boolean isWhite;
    private boolean isFreezed;

    /**
     * Constructor of disk
     * @param isWhite color of disk
     */
    public Disk(boolean isWhite) {
        this.isWhite = isWhite;
        isFreezed = false;
    }   
    
    /**
     * Method to change disk's color
     */
    public void turn() {
        if (isWhite == true)
            isWhite = false;
        else
            isWhite = true;
    }
    
    /**
     * Method returns disk's color
     * @return <code>true</code> - when disk is white;
     *         <code>false</code> - otherwise.
     */
    public boolean isWhite() {
        return isWhite;
    }
    
    /**
     * Method returns disk's freezing status
     * @return <code>true</code> - when disk is freezed;
     *         <code>false</code> - otherwise.
     */
    public boolean isFreezed() {
        return isFreezed;
    }
    
    /**
     * Setter on freezing option on actual disk
     * @param isFreezed information, whether disk is freezed or not
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
