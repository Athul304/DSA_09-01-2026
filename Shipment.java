public class Shipment {

        public int shipWithinDays(int[] weights, int days) {
            int maxcapacity=0;
            int mincapacity=0;

            for(int weight : weights){
                maxcapacity+=weight;
                mincapacity=Math.max(mincapacity,weight);
            }
            int start = mincapacity;
            int end = maxcapacity;

            while(start<end){
                int mid = start+(end-start)/2;
                if(isShippingPossible(weights,days,mid)){
                    end = mid;
                }
                else{
                    start = mid +1;
                }
            }
            return end;
        }

        public boolean isShippingPossible(int[] weights,int days, int capacity){
            int daysTaken=1;
            int currentLoad=0;
            for(int weight: weights){
                if(currentLoad + weight > capacity){
                    daysTaken++;
                    currentLoad=0;
                }
                currentLoad += weight;
            }
            return daysTaken <= days;
        }
    }

