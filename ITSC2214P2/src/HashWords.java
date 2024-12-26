import itsc2214.*; // not needed now, but you might in your projects
import java.util.ArrayList;
import java.util.List;

/**
 * Hashwords class to manage a hash table of word frequencies
 * This class allows adding words, calculating their frequency,
 * and retrieving information about the words in the hash table.
 */
public class HashWords {
    /**
     * hash table 
     */
    private List<WordFrequency>[] table;
    /**
     * num of unique words 
     */
    private int size;
     /**
     * total words num added 
     */
    private int totalWords = 0;


    /**
     * Constructor to initialize the hash table with a specified size
     * 
     * @param initialSize initialsize of hash table
     */
    public HashWords(int initialSize) {
        this.size = 0;
        totalWords = 0;
        table = (List<WordFrequency>[]) new ArrayList[initialSize];
        for (int i = 0; i < initialSize; i++) {
            table[i] = new ArrayList<>();
        }
    }

    /**
     * Returns number of unique words in hash tab;e
     * 
     * @return number of unique words
     */
    public int size() {
        return table.length;
    }

    /**
     * Computes hash key for given word
     * 
     * @param w word to to hasg
     * @return the hash key
     */
    public int hashKey(String w) {
        return Math.abs(w.hashCode()) % table.length;
    }

    /**
     * Returns the frequency of a word.
     * 
     * @param w the word search for
     * @return the frequency of the word else 0 if not found
     */
    public int frequency(String w) {
        int index = hashKey(w);
        for (WordFrequency wf : table[index]) {
            if (wf.equals(w)) {
                return wf.getCount();
            }
        }
        return 0;
    }

    /**
     * Adds a word to the hash table, updating its frequency if it already exists
     * 
     * @param w the word to add
     */
    public void addWord(String w) {
        int index = hashKey(w);
        for (WordFrequency wf : table[index]) {
            if (wf.equals(w)) {
                wf.increment();
                totalWords++;
                return; // Word exists, increment and return
            }
        }
        //if word doesnt exist, create new wordfrequency and add to table
        WordFrequency newWordFrequency = new WordFrequency(w);
        table[index].add(newWordFrequency);
        size++;
        totalWords++;
    }

    /**
     * Checks if a word is in the hash table
     * 
     * @param w word to check
     * @return true if the word exists, false otherwise
     */
    public boolean contains(String w) {
        int index = hashKey(w);
        for (WordFrequency wf : table[index]) {
            if (wf.equals(w)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns number of unique words in hash table
     * 
     * @return number of unique words
     */
    public int numUniqueWordsInTable() {
        return size;
    }

    /**
     * Returns tota' number of words added to hash table
     * 
     * @return total number words added
     */
    public int totalNumOfWords() {
        return totalWords;
    }

    /**
     * Returns the most common word in hash table
     * 
     * @return the most common word, else null if no word
     */
    public String mostCommonWord() {
        WordFrequency mostCommon = null;
        for (List<WordFrequency> bucket : table) {
            for (WordFrequency wf : bucket) {
                if (mostCommon == null || wf.getCount() > mostCommon.getCount()) {
                    mostCommon = wf;
                }
            }
        }
        return mostCommon != null ? mostCommon.getWord() : null;
    }

    /**
     * Calculates the term frquency of given word
     * 
     * @param w word to calculate frequency for
     * @return the term frequency as percentage of total words
     */
    public double termFrequency(String w) {
        int freq = frequency(w);
        if (totalWords == 0) {
            return 0.0;
        }
        return (double) freq / totalWords;
    }

}