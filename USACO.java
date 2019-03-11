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
    //getting cow movements
    int R_s=0;int C_s=0;int D_s=0;
    for (int i=0;i<N;i++) {
      nums = currentLine.split(" ",3);
      R_s=Integer.parseInt(nums[0]);
      C_s=Integer.parseInt(nums[1]);
      D_s=Integer.parseInt(nums[2]);
      stomp(R_s,C_s,D_s,pasture);
      if (lines.hasNextLine())
        currentLine = lines.nextLine();
    }
    //getting depth
    int depth=0;
    for (int i=0;i<pasture.length;i++) {
      for (int j=0;j<pasture[i].length;j++) {
        if (pasture[i][j]<E) {
          pasture[i][j]=E-pasture[i][j];
        } else {
          pasture[i][j]=0;
        }
        depth+=pasture[i][j];
      }
    }
    //multiplying by 72 * 72 which is just 5184
    return depth * 5184;
  }
  private static void stomp(int r, int c, int d, int[][] pasture) {
    //find max elevation
    int maxE = pasture[r][c];
    for (int i=r-1;i<r+2;i++) {
      for (int j=c-1;j<c+2;j++) {
        maxE = Math.max(maxE,pasture[i][j]);
      }
    }
    //stomp
    for (int i=r-1;i<r+2;i++) {
      for (int j=c-1;j<c+2;j++) {
        pasture[i][j] = Math.min(pasture[i][j],maxE-d);
      }
    }
  }
  public static int silver(String filename) throws FileNotFoundException{
    //getting input file
    File input = new File(filename);
    Scanner lines = new Scanner(input);
    String currentLine = lines.nextLine();
    //getting N rows,M columns,T seconds
    String[] ins = currentLine.split(" ",3);
    int N=Integer.parseInt(ins[0]);
    int M=Integer.parseInt(ins[1]);
    int T=Integer.parseInt(ins[2]);
    //creating pasture
    int[][] pasture = new int[N][M];
    for (int i=0;i<N;i++) {
      currentLine = lines.nextLine();
      ins = currentLine.split("");
      for (int j=0;j<M;j++) {
        if (ins[j].equals(".")) {
          pasture[i][j]=0;
        } else {
          pasture[i][j]=-1;
        }
      }
    }
    //getting r1,c1,r2,c2
    ins = lines.nextLine().split(" ",4);
    int R1=Integer.parseInt(ins[0])-1;
    int C1=Integer.parseInt(ins[1])-1;
    int R2=Integer.parseInt(ins[2])-1;
    int C2=Integer.parseInt(ins[3])-1;
    for (int i=0;i<T;i++) {
      pasture=bessie(pasture);
    }
    System.out.println(toString(pasture));
    return 0;
  }
  private static int[][] bessie(int[][] pasture) {
    int[] movs = {1,0,-1,0,0,1,0,-1};
    int[][] moves = new int[pasture.length][pasture[0].length];
    for (int i=0;i<moves.length;i++) {
      for (int j=0;j<moves.length;j++) {

      }
    }
    return moves;
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
    filename = args[1];
    try {
      System.out.println(silver(filename));
    } catch(FileNotFoundException F) {
      System.out.println(filename+" not found.");
    }
  }
}
