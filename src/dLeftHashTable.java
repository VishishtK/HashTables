public class DLeftHashTable extends HashTable{

    int segments;
    int segmentsSize;

    public DLeftHashTable(int NumberTableEntries, int NumberFlows, int NumberHashes) {
        super(NumberTableEntries, NumberFlows, NumberHashes);
        this.segments = NumberHashes;
        this.segmentsSize = NumberTableEntries/segments;
        this.hashFunctions.bound = this.segmentsSize;
    }

    private boolean flowSeenBefore(int flowID){
        int key;
        for(int i=0;i<segments;i++){
            key = i*this.segmentsSize + hashFunctions.Hash(flowID, i);
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
            key = i*this.segmentsSize + hashFunctions.Hash(flowID, i);
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
