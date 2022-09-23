import java.util.Random;
import java.util.stream.IntStream;

public class HashFunctions {

    int[] hashFunctionInts;
    int hashSize;

    public HashFunctions(int k){
        this.hashFunctionInts = IntStream.generate(() -> new Random().nextInt(Integer.MAX_VALUE)).limit(k).toArray();
        this.hashSize = k;
    }

    public int FNVHash(final String k) {
        int FNV_32_INIT = 0x811c9dc5;
        int FNV_32_PRIME = 0x01000193;

        int rv = FNV_32_INIT;
        final int len = k.length();
        for(int i = 0; i < len; i++) {
            rv ^= k.charAt(i);
            rv *= FNV_32_PRIME;
        }
        return Math.abs(rv%this.hashSize);
    }

    public int Hash(int k, int functionNumber){
        return FNVHash(String.valueOf(k ^ hashFunctionInts[functionNumber]));
    }
}
