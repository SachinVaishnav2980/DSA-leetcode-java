class Solution {
    static final long MOD = 1000000007;

    public int countAnagrams(String s) {
        long product = 1;
        String[] words = s.split(" ");

        for (String word : words) {
            int totalSize = word.length();
            long totalFact = factorial(totalSize);

            Map<Character, Integer> map = new HashMap<>();
            for (char ch : word.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            long denom = 1;
            for (int count : map.values()) {
                denom = (denom * factorial(count)) % MOD;
            }

            // Use modular inverse for division
            long inv = modInverse(denom, MOD);
            product = (product * totalFact % MOD) * inv % MOD;
        }

        return (int) (product % MOD);
    }

    long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = (fact * i) % MOD;
        }
        return fact;
    }

    // Fermat’s little theorem for modular inverse
    long modInverse(long a, long mod) {
        return pow(a, mod - 2, mod);
    }

    long pow(long a, long b, long mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
}