public class P3_partA_1_driver {
    public static void main(String[] args) {
        P3_partA_1_point[] arr={
            new P3_partA_1_point(1,2),
            new P3_partA_1_point(3,4),
            new P3_partA_1_point(1,2),
            new P3_partA_1_point(5,6),
            new P3_partA_1_point(3,4)
        };

        int count=0;

        for(int i=0;i<arr.length;i++) {
            boolean found=false;

            for(int j=0;j<i;j++) {
                if(arr[i].equals(arr[j])) {
                    found=true;
                    break;
                }
            }

            if(found==false)
                count++;
        }

        System.out.println("Distinct: " + count);
    }
}