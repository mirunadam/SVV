package ro.upt;

public class StringConv {
    public int strToInt(String str) throws NumberFormatException {
           int sum=0;
           boolean neg = false;
           if(str == null || str.length() == 0){
               throw new InvalidStringException("Invalid Null String");
           }

           if (str.charAt(0) == '-'){
               neg = true;
               for (int i = 0; i < str.length()-1; i++) {
                   int digit = (int)str.charAt(str.length()-i-1) - (int)'0';
                   //sum = sum + digit * (int)Math.pow(10, i);

                   long testSum = (long) sum + (long) (digit * Math.pow(10, i));
                   if (-testSum < Integer.MIN_VALUE) {
                       throw new NumberFormatException("Number exceeds integer limit");
                   }
                   sum = (int) testSum;
               }
           }
           else {
               for (int i = 0; i < str.length(); i++) {
                   if (str.charAt(i)<'0' || str.charAt(i)>'9'){
                       throw new InvalidStringException("Invalid String Input");
                   }
                      int digit = (int)str.charAt(str.length()-i-1) - (int)'0';
                      //sum = sum + digit * (int)Math.pow(10, i);

                       long testSum = (long) sum + (long) (digit * Math.pow(10, i));
                       if (testSum > Integer.MAX_VALUE) {
                           throw new NumberFormatException("Number exceeds integer limit");
                       }
                       sum = (int) testSum;
               }
           }
           if(neg){
               return -1 * sum;
           }
            return sum;
    }
}
