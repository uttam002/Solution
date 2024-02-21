public class UrbanPlanningChallengeParkDesign {
    public static void main(String[] args) {

        System.out.println(parkDesign(5, 10, 15, 20, 10, 10));  // Output: true
        System.out.println(parkDesign(0, 0, 10, 20, 20, 5));  // Output: false
        System.out.println(parkDesign(0,0,20,0,0,25));  // Output: true
    }
    public static boolean parkDesign(int x1, int y1, int r1, int x2, int y2, int r2) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); // Calculate the distance between the two centers
        if (distance == 0 ) { // If the distance is 0 and the radius are equal
            return true; // Parks overlap
        }
        if (distance > r1 + r2 || distance < Math.abs(r1 - r2)) { // If the distance is greater than the sum of the radius or less than the difference of the radius
            return false; // Parks do not overlap
        }
        return true; // Parks overlap
    }

}
