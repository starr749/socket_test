package socketserver;

import java.io.Serializable;

/**
 * Created by Sidus on 11/18/2014.
 */
public class Player extends Fighter implements Serializable{
    private int level;
    private Fighter pet;
    private Enemy rival;

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public Fighter getPet() {
        return pet;
    }

    public void setPet(Fighter pet) {
        this.pet = pet;
    }

    public Enemy getRival() {
        return rival;
    }

    public void setRival(Enemy rival) {
        this.rival = rival;
    }
}
