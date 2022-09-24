import java.util.Random;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) throws Exception {

        int NumberTableEntries = 1000;
        int NumberFlows = 1000;
        int NumberHashes = 3;

        int[]  randomFlow = IntStream.generate(() -> new Random().nextInt()).limit(NumberFlows).toArray();

        System.out.println("Testing MultiHashTable");
        MultiHashTable multiHashTable = new MultiHashTable(NumberTableEntries, NumberFlows, NumberHashes);
        multiHashTable.ConsumeFLows(randomFlow);
        multiHashTable.Output();

        System.out.println("Testing CuckooHashTable");
        CuckooHashTable cuckooHashTable = new CuckooHashTable(NumberTableEntries, NumberFlows, NumberHashes,2);
        cuckooHashTable.ConsumeFLows(randomFlow);
        cuckooHashTable.Output();

        System.out.println("Testing dLeftHashTable");
        DLeftHashTable dLeftHashTable = new DLeftHashTable(NumberTableEntries, NumberFlows, NumberHashes);
        dLeftHashTable.ConsumeFLows(randomFlow);
        dLeftHashTable.Output();
    }
}
