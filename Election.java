import java.util.*;

public class Election {

    private final int[] times;
    private final int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leaders = new int[persons.length];

        // Frequency of votes per person
        Map<Integer, Integer> freq = new HashMap<>();

        int leader = -1;
        int leaderCount = 0;

        for (int i = 0; i < persons.length; i++) {
            int p = persons[i];
            int c = freq.getOrDefault(p, 0) + 1;
            freq.put(p, c);

            // Use >= so most recent vote wins in case of tie
            if (c >= leaderCount) {
                leader = p;
                leaderCount = c;
            }

            leaders[i] = leader;
        }
    }

    public Election(int[] times, int[] leaders) {
        this.times = times;
        this.leaders = leaders;
    }

    public int q(int t) {
        // Find rightmost index with times[idx] <= t
        int idx = upperBound(times, t) - 1;
        // Problem guarantees times[0] <= t, so idx >= 0
        return leaders[idx];
    }

    // Returns the index of the first element > target
    private int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
