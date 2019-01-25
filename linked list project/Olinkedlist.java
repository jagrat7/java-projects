import java.util.Random;
import java.util.Arrays;
import java.lang.reflect.*;
import java.util.*;
public class Olinkedlist<T extends Comparable <T>> implements Iterable
{

private Snode<T> head;
private int size;

Olinkedlist()
{
  this.head=null;
  this.size=0;
}
/*Olinkedlist()
{ 
  this.head= new Snode(null,new Snode(input));
  this.size=1;
}*/
Snode<T> gethead()
{
 return  this.head;
}
int getsize()
{
 return this.size;
}
Olinkedlist(T[] input)
{
  if(input.length>=1)
  {
     this.head= new Snode(null,chelper(input));
     this.size=input.length;
  }
  else 
  { 
     Arrays.sort(input);
     this.head = new Snode(null,null);
     this.size=0;
   }

}
Olinkedlist(T input)
{
 this.head=new Snode(null,new Snode(input,null));
 
 this.size=1;
 
}

private Snode chelper(T[] input)
{
   if(input.length==1)
   { 
     return new Snode(input[0],null);
   }
   else 
   {
     return new Snode(input[0],chelper(Arrays.copyOfRange(input,1,input.length)));
    } 

}




Olinkedlist <T> removefirst()
{

return new Olinkedlist(Arrays.copyOfRange(Olinkedlist.toArray(this),1,this.size));

}

static <T extends Comparable<T>> Olinkedlist<T> concat(Olinkedlist<T> input1,Olinkedlist<T> input2)
{
 T[] self= Olinkedlist.toArray(input1);
 T[] other = Olinkedlist.toArray(input2);

 T[]result= (T[])Array.newInstance(self[0].getClass(), self.length+other.length);
 for (int i =0; i< self.length ; i++)
 { 
  result[i]=self[i];
 }
 for(int i=0; i <other.length; i++)
 {
   result[i+ self.length]=other[i];
 } 

 return new Olinkedlist(result);
}

Olinkedlist<T> Addtofront(T input)
{
  Olinkedlist<T> toAdd= new Olinkedlist<>(input);
  return concat(toAdd,this);

}
Olinkedlist<T> addtoback(T input)
{
  Olinkedlist<T> add = new Olinkedlist<>(input);
  return concat(this, add);
}
@Override
public Iterator<T> iterator()
{
  List<T> mahlist=Arrays.asList((T[]) Olinkedlist.toArray(this));
  return mahlist.iterator();
}

T atindex(int x)
{ 
  if(x>0 && x<this.size)
  {
     Snode temp=this.head;
   for(int i=0; i<=x; i++)
   {
    temp= temp.next;
   }
   return (T)temp.value;
  }
  else
  { return null;}


}
static <T extends Comparable<T>>T[] toArray(Olinkedlist<T> input)
        {
                T[] result = (T[])Array.newInstance(input.head.value.getClass(), input.size);
                Snode<T> tempNode = input.head;
                if(tempNode==null)
                {return (T[]) new Object[0];}
                for(int i = 0; i<input.size;i++)
                {
                        tempNode = tempNode.next;
                        result[i] = tempNode.value;
                        
                }
                return result;
        }


}