public class DurationsDivisibleBy60 {

    // Pairs of Songs With Total Durations Divisible by 60
//    You are given a list of songs where the ith song has a duration of time[i] seconds.
//    Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
//    Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
    public static int numPairsDivisibleBy60(int[] time) {

        /** Brute Force solution **/
        // accumulator
//        int pairs = 0;
//        for(int i = 0; i < time.length; i++) {
//            for(int j = i+1; j < time.length; j++) {
//                if( (time[i] + time[j]) % 60 == 0) {
//                    pairs++;
//                }
//            }
//        }
//        return pairs;

        /** Improved Solution **/
        // accumulator
        int pairs = 0;

        // Use hashmap to help solve this solution
//        Map<Integer, Integer> hmap = new HashMap<>();
        int[] map = new int[60];
        for(int t : time) {
            // if time modulus 60 is 0, then get the current value from the map (if null a 0 is added to pairs)
            if(t % 60 == 0) {
//                pairs += hmap.getOrDefault(0,0);
                pairs += map[0];
            } else { // if time modulus 60 is not equal to 0, then get the current value from map by subtracting
                // time modulus 60 from 60 and add value to pairs
//                pairs += hmap.getOrDefault(60 - t % 60, 0);
                pairs += map[60 - t % 60];
            }
//            hmap.put(t % 60, hmap.getOrDefault(t % 60, 0) + 1);
            map[t % 60]++;
        }
        return pairs;
    }
}
