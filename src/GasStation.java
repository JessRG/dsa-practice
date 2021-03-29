public class GasStation {

    // Gas Station
    // There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
    // You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
    // You begin the journey with an empty tank at one of the gas stations.
    // Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit
    // once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        /** Brute Force Solution */
        // Loop through the gas array
//        for(int s = 0; s < gas.length; s++) {
//            // int variable to help keep track of the remaining gas in the car
//            int tank = 0;
//            // boolean to help with keeping track of the starting point (s) if circuit completes
//            boolean isPossible = true;
//
//            // nested loop to traverse to each gas station to complete a circuit
//            for(int i = s; i < gas.length + s; i++) {
//                // must use modulus to ensure that if the starting point is not the first gas station
//                // the iteration will not go out of bounds and the gas amount and cost amount are properly accessed
//                int station = i % gas.length;
//
//                // calculate the amount in tank by subtracting the gas from the cost
//                tank += gas[station] - cost[station];
//
//                // if tank is less than zero set isPossible to false and break nested loop
//                if(tank < 0) {
//                    isPossible = false;
//                    break;
//                }
//            }
//            // check isPossible (if circuit was completed)
//            if(isPossible) {
//                return s;
//            }
//        }
//
//        return -1;

        /** Improved Solution (One Pass) */
        // determine if the circuit is possible by calculating the difference (total gas - total cost)
        int diff = 0;
        for(int i = 0; i < gas.length; i++) {
            diff += gas[i] - cost[i];
        }
        if(diff < 0) return -1;

        // declare variable for tank of car and startPoint (store starting gas station)
        int tank = 0;
        int startPoint = 0;

        // loop through gas array to find the startPoint point where circuit will complete
        for(int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if(tank < 0) {
                startPoint = i + 1;
                // reset tank back to zero (new startPoint point)
                tank = 0;
            }
        }
        return startPoint;
    }
}
