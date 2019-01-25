class Snode<T extends Comparable <T>>implements Comparable<Snode<T>>
{
  final T value;
  final Snode<T> next;
  
  Snode(T input, Snode next)
  {
   this.value=input;
   this.next=next;
  
  }
  Snode(T input)
  {
     this(input,null);
  
  }
 Snode()
 { 
   this(null,null);
 }
 
@Override 
public int compareTo(Snode<T> othernode)
{

  return this.value.compareTo(othernode.value);

}
   

}























