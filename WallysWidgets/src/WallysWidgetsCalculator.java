import java.util.*;

public class WallysWidgetsCalculator {

    public static HashMap<Integer,Integer> getPacks(int widgetsRequired,int[] packSizes){
        HashMap<Integer,Integer> output = new HashMap<Integer,Integer>();
        int[] packageNums = new int[packSizes.length];
        Arrays.sort(packSizes);

        for(int i=packSizes.length-1;i>0;i--){
            while(widgetsRequired>=packSizes[i]){
                widgetsRequired=widgetsRequired-packSizes[i];
                packageNums[i]++;
            }
            if((widgetsRequired>packSizes[i-1])&&(packSizes[i]-widgetsRequired<packSizes[0])){
                widgetsRequired=widgetsRequired-packSizes[i];
                packageNums[i]++;
            }
        }
        if(widgetsRequired>0){
            while(widgetsRequired>0){
                widgetsRequired=widgetsRequired-packSizes[0];
                packageNums[0]++;
            }
        }

        for(int i=0;i<packSizes.length;i++){
            if(packageNums[i]!=0){
                output.put(packSizes[i],packageNums[i]);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println("Please enter number of widgets ordered");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[] b = new int[]{250, 500, 1000, 2000, 5000};
        System.out.println("Package sizes to be shipped as as follows: \n" + getPacks(a, b));
    }
}
