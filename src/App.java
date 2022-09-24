public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Testing MultiHashTable");
        MultiHashTable multiHashTable = new MultiHashTable(1000, 1000, 3);
        multiHashTable.GenFLows();
        multiHashTable.Output();

        System.out.println("Testing CuckooHashTable");
        CuckooHashTable cuckooHashTable = new CuckooHashTable(1000, 1000, 3,2);
        cuckooHashTable.GenFLows();
        cuckooHashTable.Output();

        System.out.println("Testing dLeftHashTable");
        DLeftHashTable dLeftHashTable = new DLeftHashTable(1000, 1000, 3);
        dLeftHashTable.GenFLows();
        dLeftHashTable.Output();
    }
}
