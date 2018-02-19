package algo;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * @author Myan
 */
public class Heap {
 
     ArrayList<Node> PHeap = new ArrayList<>();
public  Heap (ArrayList PHeap)
 {this.PHeap = PHeap;}

public void SetPHeap (ArrayList PHeap){this.PHeap = PHeap;}
public ArrayList GetPHeap (){return PHeap;}

public void AddNode (Node node)
{
  this.PHeap.add(node);
   HeapifyUp();
}


//-----------------------------------------------------------------------------------------
    public void HeapifyUp()
    {
        
       int HSize = PHeap.size()-1;
       while (HSize>0)
       {  
          Node ChildtNode = PHeap.get(HSize);
          Node ParentNode = PHeap.get(GetParent(HSize));
      
          if(ChildtNode.priority>ParentNode.priority)
          {   Swap(HSize,GetParent(HSize));
              HSize = GetParent(HSize);
          }
          
          else if (ChildtNode.priority == ParentNode.priority)
          {
              if(ChildtNode.EnteryNum < ParentNode.EnteryNum)
               {Swap(HSize,GetParent(HSize));}
              HSize = GetParent(HSize);
          } 
          else {
              break;
           }
       
       }
       
    
    }
    
    
    public void HeapifyDown()
    {  
       int CurrentI=0;
       int LeftChildI = GetLeftchild(CurrentI);
       while(LeftChildI<PHeap.size())
       {    int Max=LeftChildI; 
            int RightChildI = GetRightchild(CurrentI);
            Node LeftChildtNode = PHeap.get(LeftChildI);
           
            if(RightChildI<PHeap.size())
              { 
                 Node RightChildNode = PHeap.get(RightChildI);
                 
                if(RightChildNode.priority>LeftChildtNode.priority)
                 {Max++;}
                
                else if(RightChildNode.priority==LeftChildtNode.priority)
                {
                   if(RightChildNode.EnteryNum < LeftChildtNode.EnteryNum)
                     {Max++;}             
                }
              }
           
           
           Node MaxNode = PHeap.get(Max);
           Node ParentNode = PHeap.get(CurrentI);
           
           if(ParentNode.priority < MaxNode.priority)       
           {
               Swap(Max, CurrentI);
               CurrentI = Max ; 
               LeftChildI=GetLeftchild(CurrentI);
           }
           else if(ParentNode.priority == MaxNode.priority)
           {
              if(ParentNode.EnteryNum > MaxNode.EnteryNum)
               { Swap(Max, CurrentI);}
               CurrentI = Max ; 
               LeftChildI=GetLeftchild(CurrentI);
           }
          else
          {break;}
       }
    }
    
 //-------------------------------------------------------------------------------------   
     public int GetParent (int Index){
        int NewIndex ; 
        NewIndex  = (Index-1)/2 ; 
        return NewIndex;
    }
     
     public int GetLeftchild (int Index){
        int NewIndex ; 
        NewIndex  = 2*Index+1; 
        return NewIndex;
    }
    
     public int GetRightchild (int Index){
        int NewIndex ; 
        NewIndex  = 2*Index+2 ;
        return NewIndex;
        
     }

 //---------------------------------------------------------------------------------  
      public void Swap(int Findex,int Sindex)
     {
         Node Tmp = new Node() ; 
         Tmp = PHeap.get(Findex);
         PHeap.set(Findex,PHeap.get(Sindex));
         PHeap.set(Sindex, Tmp);
     }

    public Node delete()
  throws NoSuchElementException {
        
        if (PHeap.size() == 0) 
          {throw new NoSuchElementException();}
        
        if (PHeap.size() == 1) 
          { return PHeap.remove(0);}
        
        Node hold = PHeap.get(0);
        PHeap.set(0, PHeap.remove(PHeap.size()-1));
        HeapifyDown();
        return hold;
    }
    
  
   //--------------------------------------------------------------  
     
     public int size() {
        return PHeap.size();
    }
     
    public boolean isEmpty() {
        return PHeap.isEmpty();
         
    }
     
   //-----------------------------------------------------------------------
    
    public void display()
    {
        while (!PHeap.isEmpty())
       {
         Node Max = new Node(); 
         Max = delete(); 
         System.out.println("-------------------------------------------------------------");
         System.out.println(" value :   " +Max.value);
         System.out.println(" priority :    " +Max.priority);
         System.out.println(" E :    " +Max.EnteryNum);
         System.out.println("-------------------------------------------------------------");
      }
    }
   
    
    public void print ()
    {
      for(int i=0 ; i<PHeap.size() ; i++)
      {
           Node Max = new Node();
           Max = PHeap.get(i);
      }
    
    }
   
    
    
    
}
