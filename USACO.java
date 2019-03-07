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
    System.out.println(currentLine);
    //getting r,c,e,n values
    int n=0;String num="";
    for (int i=0;i<currentLine.length();i++) {
      if (currentLine.charAt(i)!=' ') {
        num+=currentLine.charAt(i);
      } else {
        if (n==0) r=Integer.parseInt(num);
        if (n==1) c=Integer.parseInt(num);
        if (n==2) e=Integer.parseInt(num);
        num="";
        n++;
      }
    }
    if (n==3) n=Integer.parseInt(num);
    System.out.println(r);
    System.out.println(c);
    System.out.println(e);
    System.out.println(d);
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
