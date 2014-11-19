package socketserver;

import java.io.Serializable;

/**
 * Created by Sidus on 11/18/2014.
 */
public class Fighter {

    private String name;
    private int hp;
    private int attack;
    private int defense;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return this.hp;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return this.defense;
    }
}
