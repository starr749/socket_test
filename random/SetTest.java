package random;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by starr_000 on 11/24/2014.
 */
public class SetTest {
    public static void main(String args[]) {
        TreeSet<String> pokemon = new TreeSet<String>();
        pokemon.add("Pikachu");
        pokemon.add("Lizardon");
        pokemon.add("Squirtle");
        pokemon.add("Shroomish");
        pokemon.add("Raichu");
        pokemon.add("Skitty");
        pokemon.add("Jigglypuff");
        pokemon.add("Voltorb");
        pokemon.add("Bulbasaur");
        pokemon.add("Onyx");
        System.out.println(pokemon);
        System.out.println(pokemon.subSet("Bulbasaur", "Onyx"));

        HashSet<String> pokemonHash = new HashSet<String>();
        pokemonHash.add("Pikachu");
        pokemonHash.add("Lizardon");
        pokemonHash.add("Squirtle");
        pokemonHash.add("Shroomish");
        pokemonHash.add("Raichu");
        pokemonHash.add("Skitty");
        pokemonHash.add("Jigglypuff");
        pokemonHash.add("Voltorb");
        pokemonHash.add("Bulbasaur");
        pokemonHash.add("Onyx");

        System.out.println(pokemonHash);
    }
}
