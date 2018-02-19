package algo;
import static java.lang.System.console;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer; 


public class Algo {
  
      /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

     ArrayList<Node> PHeap = new ArrayList<Node>();
     Heap CreatedHeap = new Heap(PHeap);     
     Scanner console = new Scanner(System.in); 
     Scanner lineTokenizer;
     int lineNum =0,ErrorLine =0 ;
     
     //-------------------------------------------
     
    try {
        
      while (console.hasNextLine())
       {
         ErrorLine =0; 
         lineTokenizer = new Scanner(console.nextLine());
         Node NewNode = new Node() ; 
      
         if (lineTokenizer.hasNext())
         {
            if (lineTokenizer.hasNext("##")) 
                { 
                    System.out.println("hash E");
                    break;
                }   
            
            else if (lineTokenizer.hasNextInt())
                {NewNode.Setvalue(lineTokenizer.nextInt());}
           
            else
            {
	            System.out.printf("line %d - %s: value should be an integer\n", 
                    lineNum, lineTokenizer.next());
                    ErrorLine =1; 
            }
          
        }
        
         
        else 
         {
	    System.out.printf("line %d: must have fields for value \n",lineNum);
            ErrorLine =1 ; 
         }
      
      
        if (lineTokenizer.hasNext()) 
        {
	     if (lineTokenizer.hasNextInt())
             {
	       NewNode.Setpriority(lineTokenizer.nextInt());
	  
             }
            
             else
             {
	       System.out.printf("line %d - %s: prior should be an integer\n",lineNum, lineTokenizer.next());
               ErrorLine =1; 
             }
        }
        
        else 
        {
	       System.out.printf("line %d: must have fields for prior\n", lineNum);
               ErrorLine =1 ; 
        }
          
      
      
        if(ErrorLine==0)
        {
             NewNode.SetEnteryNum(lineNum);
             CreatedHeap.AddNode(NewNode);
             lineNum ++;
        } 
     }
     
     CreatedHeap.display();
 }
     finally 
     {
         if(console != null)
         {
             console.close ();
             System.exit(0);
         } 
     } 
     
     
    }
    
    
}
