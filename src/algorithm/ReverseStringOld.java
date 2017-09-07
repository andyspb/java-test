package algorithm;

public class ReverseStringOld {
  public static void main(String[] args) {
    String input = "GeeksforGeeks";

    System.out.println(input);
    
    char[] arr = input.toCharArray();

    int len = arr.length;  
    
    for (int i = 0; i < len >> 1; ++i) {
      char temp = arr[i];
      arr[i] = arr[len-i-1];
      arr[len-i-1] = temp;
    }

    System.out.println(new String(arr));
    
  }
}
