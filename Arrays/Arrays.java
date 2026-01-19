
public class Arrays {
    public static int getLargest(int arr[]) {
        int largest = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            if(largest < arr[i]) {
                largest = arr[i];
            }
        }

        return largest;
    }

    public static void reverse(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void pairs(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            int curr = arr[i];
            for(int j=i+1; j<arr.length; j++) {
                System.out.print("(" + curr + "," + arr[j] + ")" + " ");
            }
            System.out.println();
        }
    }

    public static void subArray(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int i=0; i<arr.length; i++) {
            int start = i;
            for(int j=i; j<arr.length; j++) {
                int end = j;
                currSum = 0;
                for(int k=start; k<=end; k++) {
                    currSum += arr[k];
                    System.out.print(arr[k] + " ");

                    if(currSum >= maxSum) {
                    maxSum = currSum;
                    }
                }
                
                System.out.println("(" + currSum + ")");
            }
            System.out.println();
        }
        System.out.println("MaxSum: " + maxSum);
    }

    public static void maxSubArray(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];

        prefix[0] = arr[0];
        for(int i=1; i<prefix.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        for(int i=0; i<prefix.length; i++) {
            int start = i;
            for(int j=1; j<arr.length; j++) {
                int end = j;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
                
                if(currSum >= maxSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max Sum: " + maxSum);
    }

    public static void kadanesAlgo(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0; i<arr.length; i++) {
            currSum += arr[i];

            if(currSum < 0) {
                currSum = 0;
            }

            maxSum = Math.max(maxSum, currSum);
        }

        System.out.println(maxSum);
    }

    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        // getLargest(arr);

        // reverse(arr);

        // for(int i=0; i<arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }

        // pairs(arr);

        // subArray(arr);

        kadanesAlgo(arr);
    }
}
