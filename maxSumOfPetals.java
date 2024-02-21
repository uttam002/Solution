class Demo {
  public static void main (String args[]){
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int[] p =new int[n];
    for (int i=0;i<n;i++){
      p[i] = sc.nextInt();
    }
    long maxSum = getMaxPetals(p);
    System.out.println(maxSum);

  }
 private static int getMaxPetals(int[] p){
    int min=0;
    int maxSum=0;
    for(int x:p){
        if(min<x) min=x;
        maxSum+=x;
    }
    if(maxSum%2 == 0)maxSum-=min;
    return (maxSum%2==0)? -1 : maxSum;
 }

}
