import java.util.Scanner;
import java.util.stream.*;
import java.util.Random;
import java.util.Arrays;

public class driver  {
static Scanner input = new Scanner(System.in);

static boolean valid(int x, Matrix c, Matrix j)
{
 if (x == 1 || x== 2 || x==4)
    {return (c.rows==j.rows && c.cols==j.cols);}
 else if ( x==3)
    {return (c.cols==j.rows); }
 else
  {return false;}
}
static public Matrix getmatrix( String name)
{
        System.out.print("Enter number of rows in the matrix: ");
        int r = input.nextInt();
        System.out.print("Enter number of coloums in the matrix: ");
        int c = input.nextInt();
        
        return new Matrix(r,c);
}
public static int getop()
{
    System.out.print("Enter operation to be performed on the matrix (1= Add 2=Subtract 3=Multiply 4=Hadamard): ");
    int op = input.nextInt();
    return op;
 }


static public Matrix cal(Matrix x, Matrix y)
{ int k=driver.getop();
  boolean vad=false; 
  do
  { vad =driver.valid(k,x,y);
  
     if(vad==false)
     {  System.out.println("Matrixes not valid for given operation");
        x= driver.getmatrix("uno");
        System.out.println(x.toString());
        y= driver.getmatrix("dos");
        System.out.println(y.toString()); }
  }
  while(!vad);
  return driver.doingit(k,x,y);
}


static public Matrix doingit(int x, Matrix c, Matrix j)
{
   if (x==1)
   {  return c.add(j);  }
   else if(x==2)
   {return c.sub(j); }
   else if(x==3)
   {return c.dot(j); }
   else if(x==4)
   {return c.hom(j); } 
      return c;
}

public static void main(String[] args)
{
 
      Matrix A= driver.getmatrix("uno");
     System.out.println(A.toString());
      Matrix b= driver.getmatrix("dos");
     System.out.println(b.toString());
     
      Matrix CUC= cal(A,b); 
      System.out.println("\n"+"RESULT:"); 
      System.out.println(CUC.toString());
      
            
      
}




}