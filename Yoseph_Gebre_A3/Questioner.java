import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
public class Questioner{
    
    public DTNode root;

    /**
     * PURPOSE : Sets up an initial hardcoded tree
     */
    public Questioner(){
        root = new DTNode ("");
        root.left = new DTNode ("");
        root.left.left = new DTNode ("human");
        root.left.right = new DTNode ("shark");
        root.right = new DTNode ("");
        root.right.left = new DTNode ("carrot");
        root.right.right = new DTNode ("diamond");
        root.left = new DTNode ("Is it a mammal?",root.left.left, root.left.right);
        root.right = new DTNode ("Is it a plant?",root.right.left, root.right.right);
        root = new DTNode ("Is it an animal?", root.left, root.right);
    } // end Questioner constructor

    /**
     * PURPOSE : Initiates the game. Modifies the tree if the computer cannot guess.
     * @return String : returns if the computer correctly or incorrectly.
     */
    public String playRound(){
        DTNode curr = root;
        DTNode prev = null;
        DTNode newNode = null;
        String answer = "", newThing="", question="";
        int currAnswer=0;

        while(!curr.isLeaf(curr)){
            prev = curr;
            currAnswer = JOptionPane.showConfirmDialog(null, curr.item,"20 Questions", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(currAnswer == JOptionPane.YES_OPTION){
                curr = curr.left;
            }
            else if(currAnswer == JOptionPane.NO_OPTION){
                curr = curr.right;
            } // end if-else
        } // end while

        currAnswer = JOptionPane.showConfirmDialog(null, "Are you thinking of a/an " + curr.item +" ?",
            "20 Questions", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        // Checks if the answer guessed is correct or not. If it is not correct then it asks 
        // for the user's guess and modifies the tree accordingly.
        if(currAnswer == JOptionPane.YES_OPTION)
            answer = "I guessed correctly!";
        else if(currAnswer == JOptionPane.NO_OPTION){
            answer = "I guessed wrong.";
            newThing = JOptionPane.showInputDialog("What were you thinking of?");
            question = JOptionPane.showInputDialog("Please give me a yes/no question to distinguish between a/an "+
                curr.item + " and " + newThing);
            if (prev.left == curr)
                prev.left = new DTNode(question, new DTNode(newThing), new DTNode(curr.item));
            else
                prev.right = new DTNode(question, new DTNode(newThing), new DTNode(curr.item));
        } // end if-else
        return answer;
    } // end playRound method

    /**
     * PURPOSE : Writes the hardcoded tree into a file.
     */
    public void writeTree(){
        JFileChooser j = new JFileChooser();
        j.showSaveDialog(null);
        File file = j.getSelectedFile();

        try{
            PrintWriter outFile = new PrintWriter (new FileWriter (file));
            preorderTraversal(outFile,root);
            outFile.close();
        }
        catch(Exception e){
            System.out.println("Sorry, something went wrong");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } // end try-catch 
    } // end method writeTree

    /**
     * PURPOSE : Recursive helper method for writeTree. It traverses the tree in a preorder way.
     * @param outFile : Accepts a file where the tree is to be written
     * @param curr : Accepts a node to be se up as a part of the tree
     */
    void preorderTraversal(PrintWriter outFile, DTNode curr) {
        String lineStart="< ", lineEnd=">";
        String line="";
            
        line+= lineStart+ curr.item ;
        
        outFile.println(line);
        // left tree traversal
        if(curr.left!=null)
            preorderTraversal(outFile,curr.left);
            
        // right tree traversal
        if(curr.right!=null)
            preorderTraversal(outFile,curr.right);
            
        outFile.println(lineEnd);
    } // end method preorderTraversal 

    /**
    * PURPOSE : Reads a tree from a file. 
    */
    public void readTrVee(){
        JFileChooser j = new JFileChooser();
        j.showOpenDialog(null);
        File file = j.getSelectedFile();

        try{
            FileReader fr = new FileReader (file);
            Scanner scan = new Scanner(fr);
            root = helperTree(scan);
            fr.close();
        }
        catch(Exception e){
            System.out.println("Sorry, something went wrong");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } // end try-catch 
    } // end method readTree

    /**
    * PURPOSE : Recursive helper method for readTree. 
    * @param scan : Scanner argument
    * 
    * @return DTNode : Returns a node
    */
    private DTNode helperTree(Scanner scan){
        String line = "";
        DTNode curr = root;

        if(scan.hasNext("<")){
            line = scan.nextLine();
            if(scan.hasNext("<")){
                // read left subtree
                curr.left = helperTree (scan);
                // read right subtree
                curr.right = helperTree (scan);
            }
            // forms the tree
            curr = new DTNode (line, curr.left, curr.right);
        } // end nested if
        scan.nextLine();
        return curr;
    } // end method helperTree
} // end class Questioner

