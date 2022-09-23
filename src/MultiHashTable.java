public class MultiHashTable extends HashTable{

    public MultiHashTable(int NumberTableEntries, int NumberFlows, int NumberHashes) {
        super(NumberTableEntries, NumberFlows, NumberHashes);
    }

    @Override
    public void addFlow(int flowID) {
        // TODO Auto-generated method stub
        System.out.println(this.hashFunctions.Hash(flowID, 0));
    }

}
