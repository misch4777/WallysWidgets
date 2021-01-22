import java.util.*;

public class WallysWidgetsCalculator {

    public static HashMap<Integer,Integer> getPacks(int widgetsRequired,int[] packSizes){
        HashMap<Integer,Integer> output = new HashMap<Integer,Integer>();
        int[] packageNums = new int[packSizes.length];
        int runTotal;
        Arrays.sort(packSizes);

        for(int i=packSizes.length-1;i>0;i--){
            runTotal=0;
            for(int j=0;j<i;j++){
                runTotal=runTotal+packSizes[j];
            }
            while(widgetsRequired>packSizes[i-1]){
                if((runTotal>=widgetsRequired)&&(runTotal<packSizes[i])){
                    widgetsRequired=widgetsRequired-packSizes[i-1];
                    packageNums[i-1]++;
                } else {
                    widgetsRequired=widgetsRequired-packSizes[i];
                    packageNums[i]++;
                }
            }
        }
        if(widgetsRequired>=0){
            packageNums[0]++;
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
