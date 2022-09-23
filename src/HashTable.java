import java.util.HashMap;
import java.util.Random;

public abstract class HashTable {

    int NumberTableEntries;
    int NumberFlows;
    HashFunctions hashFunctions;
    HashMap<Integer,FlowEntry> hashTable;

    public HashTable(int NumberTableEntries, int NumberFlows, int NumberHashes){
        this.NumberTableEntries = NumberTableEntries;
        this.NumberFlows = NumberFlows;
        this.hashFunctions = new HashFunctions(NumberHashes);
        this.hashTable = new HashMap<>(NumberTableEntries);
    }

    public abstract void addFlow(int flowID);

    public void GenFLows(){
        Random random = new Random();
        for (int i = 0; i < this.NumberFlows; i++){
            addFlow(random.nextInt());
        }
    }
}
