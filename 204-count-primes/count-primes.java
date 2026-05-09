class Solution {

    public int countPrimes(int N) {

        if (N <= 2) {
            return 0;
        }

        boolean[] prime = new boolean[N];

        // Initially sabko prime mark karo
        for (int i = 2; i < N; i++) {

            prime[i] = true;
        }

        // Sieve
        for (int i = 2; i * i < N; i++) {

            if (prime[i] == true) {

                for (int j = i * i; j < N; j += i) {

                    prime[j] = false;
                }
            }
        }

        int count = 0;

        // Prime count karo
        for (int i = 2; i < N; i++) {

            if (prime[i] == true) {

                count++;
            }
        }

        return count;
    }
}