class Solution {
    public int countPrimes(int n) {
        
        boolean[] primes = new boolean[n];

        for(int i=0; i<n; i++) {
            primes[i] = true;
        }

        for (int p=2; p*p<n; p++) {
            if(primes[p] == true) {
                for(int j=p*p; j<n; j+=p) {
                    primes[j] = false;
                }
            }
        }
        int count = 0;
        for(int k=2; k<n; k++) {
            if(primes[k] == true)
                count++;
        }

        return count;

    }
}