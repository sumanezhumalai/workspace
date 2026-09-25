import java.util.Scanner;

public class Reverse {

  static void reverseArray(int a[]) {
    int n = a.length;
    int r = n - 1;

    for (int l = 0; l < n / 2; l++) {
      int t = a[l];
      a[l] = a[r];
      a[r] = t;
      r--;
    }
  }

  static String reverse(String st, int i) {
    if (i < 0) {
      return "";
    }
    return st.charAt(i) + reverse(st, i - 1);
  }

  static void reverse(int a[]) {
    int n = a.length;
    int r = n - 1;

    for (int l = 0; l < n / 2; l++) {
      int t = a[l];
      a[l] = a[r];
      a[r] = t;
      r--;
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String st = sc.next();
    /*
     * for(int i=0;i<st.length();i++) {
     * str=str + st.charAt(st.length()-1-i);
     * }
     * 
     * System.out.println(str);
     */

    System.out.println(reverse(st, st.length() - 1));
    sc.close();
  }
}
