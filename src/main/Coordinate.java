package main;
/**
 * Class used to instantiate new coordinates.
 * These are primarily used to denote selected stones and/or groups.
 */
public class Coordinate {

    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return this.x+ ", " + this.y;
    }
    
    @Override
    //Tests object equality.
    public boolean equals(Object other){
        if(other == this)
            return true;
        
        if(!(other instanceof Coordinate))
            return false;
        
        Coordinate c = (Coordinate)other;
        
        return (this.x == c.x && this.y == c.y);
    }

    @Override
    //Computes hashcode for coordinates.
    //Will fail to be unique with all coordinate ranges >=100
    //As Go boards are designed to be limited to 19x19 length, this not an issue.
    public int hashCode() {
        int hash = this.x;
        hash += this.y * 100;
        return hash;
    }
}
