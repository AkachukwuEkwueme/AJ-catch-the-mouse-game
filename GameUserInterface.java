import javax.swing.*;
import java.awt.*;

 /*the class GameUserInterface provides the user interface of the Game. It extends
 JFrame and lays out an instance of BoardUserInterface and  two instances of JButton: one to reset and the second the quit the game at any time.*/

public class GameUserInterface extends JFrame {

	private JButton reset;
	private JButton quit;
	// ADD YOUR INSTANCE VARIABLES HERE
	//ALL PRIVATE
	private BoardUserInterface bUI;
	private GameState state;
	private GameLogic gameLogic;
	private JFrame jframe;
 
    /* Constructor 
	 * initializes the board
     * takes as parameters the state of the game and the gameLogic */

    public GameUserInterface(GameState state, GameLogic gameLogic) {
    	jframe = new JFrame ("AJ's Game - Catch the Mouse! ");
    	jframe.setSize(state.getSize()*100, state.getSize()*100);
    	bUI = new BoardUserInterface(state, gameLogic);

    	//created instances of a Jframe and BoardUserInterface, set the size using a scalar for JFrame

		this.state = state;
		this.gameLogic = gameLogic;
		//setting variables
		

		JPanel jpanel = new JPanel();
		jpanel.setLayout(new FlowLayout());
		//creating a new panel and setting layout using flowlayout



		reset = new JButton("Restart");
		reset.addActionListener(gameLogic);
		quit = new JButton("Quit");
		quit.addActionListener(gameLogic);
		jpanel.add(reset);
		jpanel.add(quit);
		
		//created labels for my reset and quit buttons, connected them using actionListener to gameLogic, added them to my jpanel

		
		
		jframe.getContentPane().add(jpanel, BorderLayout.SOUTH);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//jframe.setSize(this.boardSize*50,this.boardSize*50);
		//jframe.setLayout(new GridLayout(this.boardSize,this.boardSize,5,5));
		//jframe.setSize(800,600);
		jframe.add(bUI);

		//setting buttons to bottom of my page and a way to close my game, added jframe to instance of boarduserinterface
		

		jframe.pack();
		jframe.setVisible(true);

		//Your code here

    }


	public JButton getReset(){
		return this.reset;
	}
	public JButton getQuit(){
		return this.quit;
	}
    public BoardUserInterface getBoardUserInterface(){
		return this.bUI;
   }
    public JFrame getFrme(){
    	return jframe;
    } 
}
