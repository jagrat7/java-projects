import java.util.stream.*;
import java.util.Random;
import java.util.Arrays;
public class Matrix {

public final int rows;
public final int cols;
public final int elements[][];
public Matrix()
{
 this(2,2);
}
public Matrix(int rows , int cols)
{
 this.rows=rows;
 this.cols=cols;
 
 
 this.elements = IntStream.range(0,this.rows)
 .mapToObj(x->new Random().ints(this.cols, 0,10)
 .toArray()).toArray(int[][]::new);
}
public Matrix(int [][] input)
{
  this.rows=input.length;
  this.cols=input.length;

  this.elements= Arrays.stream(input).map(x->Arrays.copyOf(x, x.length)).toArray(int[][]::new);
  
}

public Matrix add(Matrix input)
{  
return new Matrix
(Intstream().range(0,this.rows)
.mapToObj(i -> IntStream.range(0, this.cols)
.map(j -> this.elements[i][j]+input.elements[i][j])
.toArray()).toArray(int[][]::new));
  
}
public Matrix sub(Matrix input)
{
return new Matrix
(IntStream.range(0,rows)
.mapToObj(x->IntStream.range(0, cols)
.map(y->this.elements[x][y]-input.elements[x][y])
.toArray()).toArray(int[][]::new));
}
public Matrix hom(Matrix input)
{
   return new Matrix(IntStream.range(0,rows)
  .mapToObj(x->IntStream.range(0, cols)
  .map(y->this.elements[x][y]*input.elements[x][y])
  .toArray()).toArray(int[][]::new));
}
public Matrix dot(Matrix input)
{
    return new Matrix(IntStream.range(0,this.rows)
    .mapToObj(i->IntStream.range(0,input.cols)
    .map(j->IntStream.range(0,this.cols)
    .map(k->this.elements[i][k]*input.elements[k][j]).reduce(0,( a,b)->a+b))
    .toArray()).toArray(int[][]::new));   

}

public Object Clone()
{
 return(Object)new Matrix(this.elements);
}

@Override
public String toString()
{
 return Arrays.stream(this.elements)
 .map(r->Arrays.stream(r)
 .mapToObj(i-> String.format(" % 6d", i)).reduce("", (a,b) -> a + b))
 .reduce("",(a,b)->a+b+"\n");
 
}


@Override
public boolean equals(Object obj)
{    
    if(obj instanceof Matrix)
    {
      Matrix input =(Matrix) obj;
      return Arrays.deepEquals(this.elements,input.elements);
    }
    else 
    {return false;}

}
    
}
