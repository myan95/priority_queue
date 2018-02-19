package algo;




public class Node {
 
    public int value , priority , EnteryNum ; 
     
    
    public Node (int value , int priority , int EnteryNum )
    {
     this.value = value ; 
     this.priority = priority ;
     this.EnteryNum = EnteryNum ;
     
    }
 public Node (){}
    
    public void Setvalue (int value){this.value = value;}
    public int Getvalue (){return value;}
    
    public void Setpriority (int priority){this.priority = priority;}
    public int Getpriority (){return priority;}
    
    public void SetEnteryNum (int EnteryNum){this.EnteryNum = EnteryNum;}
    public int GetEnteryNum (){return EnteryNum;}
    
    
}
