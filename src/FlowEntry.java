public class FlowEntry {
    int id;
    int packetCount;

    public FlowEntry(int id){
        this.id = id;
        this.packetCount = 1;
    }

    public FlowEntry(int id, int packetCount){
        this.id = id;
        this.packetCount = packetCount;
    }

    public void addPacket(){
        this.packetCount++;
    }

    public int getPacketCount(){
        return this.packetCount;
    }
}
