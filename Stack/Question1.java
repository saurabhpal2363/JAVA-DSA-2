package Stack;
import java.util.Stack;

public class Question1 {
    // Ques. Stock span Problem     O(n)
    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i=1; i<stocks.length; i++) {
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            s.push(i);
        }
    }

    // Ques. Next Greater Element       O(n)
    public static void nextGreater(int arr[], int nxtGreater[]) {
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--) {
            while(!s.isEmpty() && arr[i]>arr[s.peek()]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = arr[s.peek()];
            }

            s.push(i);
        }
    }

    // Ques. Valid Paranthesis      O(n)
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if(s.isEmpty()) {
                    return false;
                }

                if((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }

        if(s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    // Ques. Check Duplicate Paranthesis        O(n)
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            int count = 0;
            char ch = str.charAt(i);

            if(ch == ')') {
                while(s.peek() != '(') {
                    s.pop();
                    count++;
                }

                if(count == 0) {
                    return true;
                } else {
                    s.pop();
                }
            } else {
                s.push(ch);
            }
        }

        return false;
    } 

    // Ques. Max Area of Histogram      O(n)
    public static void maxArea(int arr[]) {
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        // Next smaller right
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1; i>=0; i--) {
            while(!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = arr[s.peek()];
            }

            s.push(i);
        }

        // Next smaller right 
        s = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            while(!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }

            s.push(i);
        }

        // Claculate Area 
        for(int i=0; i<arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }

        System.out.println("Maximum Area of Histogram is = " + maxArea);
    }

    public static void main(String[] args) {
        // int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);

        // for(int i=0; i<span.length; i++) {
        //     System.out.print(span[i] + " ");
        // }

        // int arr[] = {6, 8, 0, 1, 3};
        // int nxtGreater[] = new int[arr.length];

        // nextGreater(arr, nxtGreater);

        // for(int i=0; i<nxtGreater.length; i++) {
        //     System.out.print(nxtGreater[i] + " ");
        // }

        // String str = "(a+b)";
        // System.out.println(isDuplicate(str));

        int arr[] = {2, 1, 5, 6, 2, 3};     // Height in Histogram
        maxArea(arr);
    }
}
