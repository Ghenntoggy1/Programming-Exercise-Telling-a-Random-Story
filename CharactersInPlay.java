import java.util.ArrayList;
import edu.duke.FileResource;

public class CharactersInPlay {
    private ArrayList<String> characters;
    private ArrayList<Integer> counters;
    
    public CharactersInPlay () {
        characters = new ArrayList<String> ();
        counters = new ArrayList<Integer> ();
    }
    
    private void update (String person) {
        int index = characters.indexOf(person);
        if (index == -1) {
            characters.add(person);
            counters.add(1);
        }
        else {
            int value = counters.get(index);
            counters.set(index, value + 1);
        }
    }
    
    private void findAllCharacters () {
        characters.clear();
        counters.clear();
        FileResource fr = new FileResource();
        for (String line : fr.lines()) {
            int index = line.indexOf('.');
            if (index != -1) {
                String person = line.substring(0, index).toLowerCase();
                update(person.trim());
            }
        }
    }
    
    private int findIndexOfMax () {
        int maxValue = -1;
        int currValue;
        for (int i = 0; i < counters.size(); i++) {
            currValue = counters.get(i);
            if (maxValue < currValue) {
                maxValue = currValue;
            }
        }
        return counters.indexOf(maxValue);
    }
    
    private void charactersWithNumPart (int num1, int num2) {
        for (int i = 0; i < characters.size(); i++) {
            if (counters.get(i) >= num1 && counters.get(i) <= num2) {
                System.out.println(characters.get(i) + " : " + counters.get(i));
            }
        }
    }
    
    public void tester () {
        findAllCharacters();
        for (int i = 0; i < characters.size(); i++) {
            if (counters.get(i) > 5) {
                System.out.println(characters.get(i) + " : " + counters.get(i));
            }
        }
        
        System.out.println(counters.get(findIndexOfMax()) + " : " + characters.get(findIndexOfMax()));
        
        int num1 = 10;
        int num2 = 15;
        System.out.println("\n===========================\n");
        charactersWithNumPart(num1, num2);
    } 
}
