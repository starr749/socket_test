package socketserver;

import java.io.Serializable;

/**
 * Created by Sidus on 11/18/2014.
 */
public class Player extends Fighter implements Serializable{
    private int level;

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }
}
