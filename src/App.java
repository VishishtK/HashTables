public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Testing MultiHashTable");
        MultiHashTable multiHashTable = new MultiHashTable(1000, 1000, 3);
        multiHashTable.GenFLows();
    }
}
