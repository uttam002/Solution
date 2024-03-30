public class Solution {
    public static void main(String[] args) {
        int marathonLength = 15;
        double startingSpeed = 10.0;
        int[] boosterLocations = {2, 5, 8, 10};
        int[] boosterEffectiveness = {5, 8, 12, 9};
        int[] waitingTimes = {1, 1, 4, 2};

        double minTimeOneBooster = minTimeWithOneBooster(marathonLength, startingSpeed, boosterLocations, boosterEffectiveness, waitingTimes);
        System.out.println("Minimum time to complete marathon with at most one booster dose: " + minTimeOneBooster + " hours");

        // double minTimeTwoBoosters = minTimeWithTwoBoosters(marathonLength, startingSpeed, boosterLocations, boosterEffectiveness, waitingTimes);
        // System.out.println("Minimum time to complete marathon with at most two booster doses: " + minTimeTwoBoosters + " hours");
    }

    private static double minTimeWithOneBooster(int marathonLength, double startingSpeed, int[] boosterLocations,int[] boosterEffectiveness, int[] waitingTimes) {
        double minTime = 0.0,currentSpeed = startingSpeed;
        for(int i=0;i<marathonLength;i++){
            minTime += (60/(currentSpeed));
            currentSpeed=(0.9)*currentSpeed; //decrease speed by 10% each time
        }
        for(int i=0;i<boosterLocations.length;i++){
             double time = 0.0;
        //     double speed = startingSpeed;
        //     for(int j=0;j<marathonLength;j++){
        //         time += (60/(speed));
        //         speed=(0.9)*speed; //decrease speed by 10% each time
        //         if(j==boosterLocations[i]){
        //             time += waitingTimes[i];
        //             speed += boosterEffectiveness[i];
        //         }
        //     }
        //     if(time<minTime)
        //         minTime = time;
        }
        return minTime/60;
   }
}
