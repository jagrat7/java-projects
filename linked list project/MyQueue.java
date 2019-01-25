import java.util.Arrays;
import java.lang.reflect.*;
import java.util.*;

public class MyQueue<T extends Comparable <T>> 
{

 Olinkedlist<T> list;
 

public MyQueue(T[] input)
{
  this.list = new  Olinkedlist<T>(input);

}

public MyQueue()
{
   this.list=new Olinkedlist<T>();
}

public MyQueue(T input)
{
    this.list=new Olinkedlist<T>(input);
}

 MyQueue copy()
 {   
                         
     T[] array= this.list.toArray(this.list);     
     MyQueue nqueue = new MyQueue(array);   
     return  nqueue;
}
MyQueue Enqueue(T input)    //Add an element to the sequence
{
     this.list.addtoback(input);
     return copy();
}

MyQueue Dequeue()//Remove an element from the start of the sequence
{
    this.list.removefirst();
    return copy();
}

Comparable atIndex(int x) //Return the element at the given index (x) Or throw an exception if it is out of bound (if you can control the user input then do that instead)
{ 
Snode curr = list.gethead();
 int index=0;
        while (curr!=null)
        {
         
         if(index==x)
        { return curr.value; }
            
         curr = curr.next;
      
         index++;
        }
        throw new IndexOutOfBoundsException();         
       //return this.list.atindex(x);
        
       
}


int Size()
{ 
    return list.getsize();
}

boolean isEmpty() //Boolean, returns true if the Queue is empty
{
       if(list.gethead()==null)
       { 
         return true;
       }
       else
       {
         return false;
       }
}

MyQueue Empty()//Empty the Queue
{
    this.list =new Olinkedlist();
    return copy();
  
}


 











}