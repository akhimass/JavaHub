/**
 * WordFrequency class to be used in a hash table.
 * 
 * @author Akhi Chappidi
 */
public class WordFrequency {
    //declare private variables here
    /**
    *word itself 
    */
    private String word; 
    /**
     * count of word
     */
    private int count;
    
    /**
     * Constructor to initialize word and count
     * 
     * @param w - word
     */
    public WordFrequency(String w) {
        this.word = w;
        this.count = 1;
    }

    /**
     * Returns the word
     * 
     * @return word
     */
    public String getWord() {
        return word;
    }

    /**
     * Return count of word
     * 
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * Increments count of word by 1
     */
    public void increment() {
        count++;
    }

    /**
     * equals() - compares two WordFrequency objects
     * checking to see if they are the same. Equality
     * is defined by string matching ignoring case.
     * 
     * @param other object to compare against
     * @return true if this and other are equals, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof String) {
            String w = (String) other;
            return getWord().equalsIgnoreCase(w);
        } else if (other instanceof WordFrequency) {
            WordFrequency wf = (WordFrequency) other;
            String w = wf.getWord();
            return getWord().equalsIgnoreCase(w);
        } else {
            return false;
        }
    }
}
