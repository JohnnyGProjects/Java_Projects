import javax.swing.JOptionPane;
public class A4P2GebreYoseph{
    /**
     * PURPOSE : Main method to test all other methods and classes
     */
    public static void main(String[] args){
        A4P2GebreYoseph obj = new A4P2GebreYoseph();
        obj.playGame();
        JOptionPane.showMessageDialog(null,"20 Questions ends.");
    } // end main method

    /**
     * PURPOSE : Helper method to main that creates an object of the Questioner class and calls all other methods appropriately.
     *           It also takes care of the fundamental structure of the game.
     */
    private void playGame(){
        Questioner question = new Questioner();
        int answer = JOptionPane.showConfirmDialog(null, "Let's play 20 Questions", "20 Questions", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null,"Think about a living creature!");

        while (answer == JOptionPane.YES_OPTION) {
            question.playRound();
            answer = JOptionPane.showConfirmDialog(null, "I get better everytime I play. Another round?", "20 Questions",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(answer == JOptionPane.NO_OPTION) {
                int override = JOptionPane.showConfirmDialog(null, "Save knowledge in file?", "Progress...", 
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(override == JOptionPane.YES_OPTION)
                    question.writeTree();
            } // end nested if
        } // end while
    } // end method playGame
} // end class A4P2GebreJohnny
