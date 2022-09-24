import java.io.BufferedWriter;
import java.io.FileWriter;

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

    public void ConsumeFLows(int[] flow){
        for (int i = 0; i < flow.length; i++){
            addFlow(flow[i]);
        }
    }

    public void Output(String outputFileName) {
        System.out.println("Number of flows in the hash table: "+ flowsAdded);
        System.out.println("Flow ID's recorded:");
        // System.out.println(Arrays.toString(hashTable));

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            writer.write(String.valueOf(flowsAdded));
            writer.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
