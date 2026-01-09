public class Reach_a_number {
    public int reachNumber(int target) {
        long sum=0;
        int k=0;
        target= Math.abs(target);

        while(sum<target){
            k++;
            sum= sum+k;
        }
        long diff=sum - target;
        if(diff%2==0){
            return k;
        }
        else{
            return (k%2==0)?(k+1):(k+2);
        }


    }
}
