import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class USACO {
  public static int bronze(String filename) throws FileNotFoundException{
    // array of 6x6 squares, making the pasture
    int[][] pasture;
    // row, column, elevation, down
    int r=0;int c=0;int e=0;int d=0;
    //getting input file
    File input = new File(filename);
    Scanner lines = new Scanner(input);
    String currentLine = lines.nextLine();
    //getting r,c,e,n values
    String[] nums = currentLine.split(" ",4);
    for (int i=0;i<nums.length;i++) {
      if (i==0) r=Integer.parseInt(nums[i]);
      if (i==1) c=Integer.parseInt(nums[i]);
      if (i==2) e=Integer.parseInt(nums[i]);
      if (i==3) d=Integer.parseInt(nums[i]);
    }
    //getting pasture
    pasture = new int[r][c];
    currentLine = lines.nextLine();
    nums = currentLine.split(" ",c);
    for (int i=0;i<r;i++) {
      System.out.println(currentLine);
      for (int j=0;j<c;j++) {
        pasture[i][j]=Integer.parseInt(nums[j]);
        System.out.println(pasture[i][j]);
      }
      currentLine = lines.nextLine();
      nums = currentLine.split(" ",c);
    }
    return 0;
  };
  public static void main(String[] args) {
    String filename = args[0];
    try {
      System.out.println(bronze(filename));
    } catch(FileNotFoundException F) {
      System.out.println(filename+" not found.");
    }
  }
}
