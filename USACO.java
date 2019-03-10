import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class USACO {
  public static int bronze(String filename) throws FileNotFoundException{
    // array of 6x6 squares, making the pasture
    int[][] pasture;
    // row, column, elevation, down
    int R=0;int C=0;int E=0;int N=0;
    //getting input file
    File input = new File(filename);
    Scanner lines = new Scanner(input);
    String currentLine = lines.nextLine();
    //getting r,c,e,n values
    String[] nums = currentLine.split(" ",4);
    R=Integer.parseInt(nums[0]);
    C=Integer.parseInt(nums[1]);
    E=Integer.parseInt(nums[2]);
    N=Integer.parseInt(nums[3]);
    //getting pasture
    pasture = new int[R][C];
    currentLine = lines.nextLine();
    nums = currentLine.split(" ",C);
    for (int i=0;i<R;i++) {
      for (int j=0;j<C;j++) {
        pasture[i][j]=Integer.parseInt(nums[j]);
      }
      currentLine = lines.nextLine();
      nums = currentLine.split(" ",C);
    }
    System.out.println(toString(pasture));
    //getting cow movements
    int R_s=0;int C_s=0;int D_s=0;
    nums = currentLine.split(" ",3);
    R_s=Integer.parseInt(nums[0]);
    C_s=Integer.parseInt(nums[1]);
    D_s=Integer.parseInt(nums[2]);
    System.out.println(""+R_s+C_s+D_s);
    stomp(R_s,C_s,D_s,pasture);
    while (lines.hasNextLine()) {
      currentLine = lines.nextLine();
      nums = currentLine.split(" ",3);
      R_s=Integer.parseInt(nums[0]);
      C_s=Integer.parseInt(nums[1]);
      D_s=Integer.parseInt(nums[2]);
      System.out.println(""+R_s+C_s+D_s);
      stomp(R_s,C_s,D_s,pasture);
    }
    return 0;
  }
  private static void stomp(int r, int c, int d, int[][] pasture) {
    int maxE = pasture[r][c];
    for (int i=r-1;i<r+2;i++) {
      for (int j=c-1;j<c+2;j++) {
        maxE = Math.max(maxE,pasture[i][j]);
        System.out.println(maxE);
      }
    }
    for (int i=r-1;i<r+2;i++) {
      for (int j=c-1;j<c+2;j++) {
        pasture[i][j] = Math.min(pasture[i][j],maxE-d);
        System.out.println(pasture[i][j]);
      }
    }
    System.out.println(toString(pasture));
  }
  private static String toString(int[][] array) {
    String s = "";
    for (int i=0;i<array.length;i++) {
      for (int j=0;j<array[i].length;j++) {
        s+=array[i][j]+" ";
      }
      s+="\n";
    }
    return s;
  }
  public static void main(String[] args) {
    String filename = args[0];
    try {
      System.out.println(bronze(filename));
    } catch(FileNotFoundException F) {
      System.out.println(filename+" not found.");
    }
  }
}
