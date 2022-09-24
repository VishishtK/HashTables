public class CuckooHashTable extends HashTable{

    int cuckooSteps;

    public CuckooHashTable(int NumberTableEntries, int NumberFlows, int NumberHashes, int cuckooSteps) {
        super(NumberTableEntries, NumberFlows, NumberHashes);
        this.cuckooSteps = cuckooSteps;
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

    private boolean move(int x, int step){
        int flowID = hashTable[x];
        int key;

        for(int i=0;i<hashFunctions.hashSize;i++){
            key = hashFunctions.Hash(flowID, i);
            if(key!=x && hashTable[key]==null){
                hashTable[key]=flowID;
                return true;
            }
        }

        if(step>1){
            for(int i=0;i<hashFunctions.hashSize;i++){
                key = hashFunctions.Hash(flowID, i);
                if(key!=x && move(key,step-1)){
                    hashTable[key]=flowID;
                    return true;
                }
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

        for(int i=0;i<hashFunctions.hashSize;i++){
            key = hashFunctions.Hash(flowID, i);
            if(move(key,this.cuckooSteps)){
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

    @Override
    public void Output() {
        System.out.println("Number of flows in the hash table: "+ flowsAdded);
        System.out.println("Flow ID's recorded:");
        // System.out.println(Arrays.toString(hashTable));
        
    }
    
}