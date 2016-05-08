package ija.ija2016.reversi.board;

/**
 * Class Board Field represents field on playing board
 * @author Patrik Segedy 
 * @author Tibor Dudlak
 */
public class BoardField implements Field, java.io.Serializable {

    private static final long serialVersionUID = 8757784087839655732L;
    private int row;
    private int col;
    private Disk disk;
    private Field[] fieldArr = new Field[8]; 
    
    /**
     * Constructor of Board Field with coords row and col
     * @param row row of field
     * @param col column of field
     */
    public BoardField(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    @Override
    public void addNextField(Direction dirs, Field field) {
        fieldArr[dirs.ordinal()] = field;
    }

    @Override
    public Field nextField(Direction dirs) {
        return fieldArr[dirs.ordinal()];
    }
    
    /**
     * Method setting starting disks
     * @param disk
     * @return <code>true</code> - on success;
     *         <code>false</code> - otherwise.
     */
    public boolean putStartDisk(Disk disk) {
        if (this.disk == null) {
            this.disk = disk;
            Board.startDisks++;
            return true;
        } else
            return false;
    }

    /**
     * Puts disk on field.
     * @return <code>true</code> - on success;
     *         <code>false</code> - otherwise.
     */
    public boolean putDisk(Disk disk) {
        boolean newDiskSet = false;
        
        if (!this.isEmpty())
            return false;
        // prechadzam vsetkymi smermi a hladam policko s opacnou farbou
        Field tmpField;
        for (int i = 0; i < fieldArr.length; i++) {
            boolean breakAgain = false;
            int j = 0;
            if(i % 2 == 0)
                j = i + 1;
            else
                j = i - 1;
            int count = 0;
            tmpField = fieldArr[i];
            
            // policko musi byt instancia BoardField
            while (tmpField instanceof BoardField) {
                // musi byt obsadene
                if (!tmpField.isEmpty()){
                    // rozne farby
                    if (tmpField.getDisk().isWhite() != disk.isWhite()) {
                        if (!tmpField.getDisk().isFreezed()) {
                            // posuvam sa na dalsie v rovnakom smere
                            tmpField = tmpField.nextField(intToDirection(i));
                            count++; //pocet policok ktore budem otacat
                        }
                        else
                            return false;
                    }
                    else if (count != 0) {
                        for (int k = 0; k < count; k++) {
                            tmpField = tmpField.nextField(intToDirection(j));
                            if (this.equals(tmpField)) {
                                breakAgain = true;
                                break;
                            }
                            if(tmpField.isEmpty() || tmpField.getDisk().isFreezed())
                                return false;
                            tmpField.getDisk().turn();
                        }
                        if (breakAgain)
                            break;
                        this.disk = disk;
                        newDiskSet = true;
                    }
                    else
                        break;
                }
                else
                    break;
            }
            
        }
        if (newDiskSet)
            return true;
        
        return false;
    }
    
    /**
     * Method returns disk on this field
     */
    public Disk getDisk() {
        if (this.disk != null)
            return disk;
        else
            return null;
    }
    
    public Direction intToDirection(int number) {
        switch (number) {
        case 0:
            return Direction.L;
        case 1:
            return Direction.R;
        case 2:
            return Direction.U;
        case 3:
            return Direction.D;
        case 4:
            return Direction.LU;
        case 5:
            return Direction.RD;
        case 6:
            return Direction.LD;
        case 7:
            return Direction.RU;

        default:
            return null;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + col;
        result = prime * result + ((disk == null) ? 0 : disk.hashCode());
        result = prime * result + row;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof BoardField))
            return false;
        BoardField other = (BoardField) obj;
        if (col != other.col)
            return false;
        if (disk == null) {
            if (other.disk != null)
                return false;
        } else if (!disk.equals(other.disk))
            return false;
        if (row != other.row)
            return false;
        return true;
    }

    /**
     * Check if it is possible to put disk.
     * @return <code>true</code> - when field is empty;
     *         <code>false</code> - otherwise.
     */
    public boolean canPutDisk(Disk disk) {
        // policko je obsadene ?
        if (!this.isEmpty())
            return false;
        // prechadzam vsetkymi smermi a hladam policko s opacnou farbou
        Field tmpField;
        for (int i = 0; i < fieldArr.length; i++) {
            int count = 0;
            tmpField = fieldArr[i];
            // policko musi byt instancia BoardField
            while (tmpField instanceof BoardField) {
                // musi byt obsadene
                if (!tmpField.isEmpty()){
                    // rozne farby
                    if (tmpField.getDisk().isWhite() != disk.isWhite()) {
                        if (!tmpField.getDisk().isFreezed()) {
                            // posuvam sa na dalsie v rovnakom smere
                            tmpField = tmpField.nextField(intToDirection(i));
                            count++; //pocet policok ktore budem otacat
                        }
                        else
                            return false;
                    }
                    else if (count != 0) {
                        if (tmpField.isEmpty() || tmpField.getDisk().isFreezed()) {
                            return false;
                        }
                        return true;
                    }
                    else
                        break;
                }
                else
                    break;
            }
            
        }
        
        return false;
    }

    /**
     * Checks if field is empty
     * @return <code>true</code> - when field is empty;
     *         <code>false</code> - otherwise.
     */
    public boolean isEmpty() {
        if (this.disk == null)
            return true;
        else
            return false;
    }
}
