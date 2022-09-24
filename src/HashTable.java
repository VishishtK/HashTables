import java.util.Random;

public abstract class HashTable {

    int NumberTableEntries;
    int NumberFlows;
    HashFunctions hashFunctions;
    Integer[] hashTable;
    int flowsAdded;

    public HashTable(int NumberTableEntries, int NumberFlows, int NumberHashes){
        this.NumberTableEntries = NumberTableEntries;
        this.NumberFlows = NumberFlows;
        this.hashFunctions = new HashFunctions(NumberHashes,NumberTableEntries);
        this.hashTable = new Integer[NumberTableEntries];
        this.flowsAdded = 0;
    }

    public abstract void addFlow(int flowID);
    public abstract boolean QueryFlow(int flowID);
    public abstract void Output();

    public void GenFLows(){
        Random random = new Random();
        for (int i = 0; i < this.NumberFlows; i++){
            addFlow(Math.abs(random.nextInt()));
        }
    }
}
