public class MultiHashTable extends HashTable{

    public MultiHashTable(int NumberTableEntries, int NumberFlows, int NumberHashes) {
        super(NumberTableEntries, NumberFlows, NumberHashes);
    }

    private boolean flowSeenBefore(int flowID){
        int key;
        for(int i=0;i<hashFunctions.hashSize;i++){
            key = hashFunctions.Hash(flowID, i);
            if(hashTable[key]==null){
                return false;
            }
            if(hashTable[key]==flowID){
                return true;
            }
        }
        return false;
    }

    @Override
    public void addFlow(int flowID) {
        if(flowSeenBefore(flowID)){
            return;
        }
        
        int key;
        
        for(int i=0;i<hashFunctions.hashSize;i++){
            key = hashFunctions.Hash(flowID, i);
            if(hashTable[key]==null){
                hashTable[key]=flowID;
                flowsAdded++;
                return;
            }
        }
        return;
    }

    @Override
    public boolean QueryFlow(int flowID) {
        return flowSeenBefore(flowID);
    }

}
