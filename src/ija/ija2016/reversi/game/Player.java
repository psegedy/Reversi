package ija.ija2016.reversi.game;

import ija.ija2016.reversi.board.Board;
import ija.ija2016.reversi.board.Field;
import ija.ija2016.reversi.board.Disk;
/**
 * Class Player to create player and setting its color
 * @author Patrik Segedy 
 * @author Tibor Dudlak
 */
public class Player implements java.io.Serializable {

    private static final long serialVersionUID = 3145485149475518508L;
    private boolean isWhite;
    
    /**
     * Constructor of player
     * @param isWhite sets color of player's disks
     */
    public Player(boolean isWhite) {
        this.isWhite = isWhite;
    }
    
    /**
     * Method returns player's color
     * @return <code>true</code> - when player is white;
     *         <code>false</code> - when player is black.
     */
    public boolean isWhite() {
        return isWhite;
    }
    
    /**
     * Method returns true when player can or can't put disk at field
     * @param field contains actual field on board
     * @return <code>true</code> - when can put disk;
     *         <code>false</code> - when can not.
     */
    public boolean canPutDisk(Field field) {
        return field.canPutDisk(new Disk(isWhite));
    }
    
    /**
     * Method put disk puts disk at field
     * @param  field contains actual field on board
     * @return <code>true</code> - when it was successful;
     *         <code>false</code> - otherwise.
     */
    public boolean putDisk(Field field) {
        return field.putDisk(new Disk(isWhite));
    }
    
    /**
     * Method initializes playing board
     * @param board board to initialize
     */
    public void init(Board board) {
        int size = board.getSize();
        if (isWhite) {
            //je biely, vlozim biely disk
            board.getField(size/2, size/2).putStartDisk(new Disk(isWhite));
            board.getField(size/2 + 1, size/2 + 1).putStartDisk(new Disk(isWhite));
        }
        else {
            board.getField(size/2 + 1, size/2).putStartDisk(new Disk(isWhite));
            board.getField(size/2, size/2 + 1).putStartDisk(new Disk(isWhite));
        }
    }

    @Override
    public String toString() {
        if (isWhite) {
            return "white";
        }
        else
            return "black";
    }
}
