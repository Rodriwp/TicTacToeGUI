package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.TicTaeToeController;

public class TicTacToeGui {

	private JFrame frmTicTacToe;
	private TicTaeToeController controller;
	protected static ImageIcon ICON_0 =new ImageIcon(TicTacToeGui.class.getResource("/resources/circle.png")); //$NON-NLS-1$
	protected static ImageIcon ICON_X =new ImageIcon(TicTacToeGui.class.getResource("/resources/cross.png")); //$NON-NLS-1$

	JButton btn00 = new JButton(""); //$NON-NLS-1$
	JButton btn01 = new JButton(""); //$NON-NLS-1$
	JButton btn02 = new JButton(""); //$NON-NLS-1$
	JButton btn10 = new JButton(""); //$NON-NLS-1$
	JButton btn11 = new JButton(""); //$NON-NLS-1$
	JButton btn12 = new JButton(""); //$NON-NLS-1$
	JButton btn20 = new JButton(""); //$NON-NLS-1$
	JButton btn21 = new JButton(""); //$NON-NLS-1$
	JButton btn22 = new JButton(""); //$NON-NLS-1$
	JButton btnReset = new JButton(Messages.getString("TicTacToeGui.RESET")); //$NON-NLS-1$
	JButton btnExit = new JButton(Messages.getString("TicTacToeGui.EXIT")); //$NON-NLS-1$

	JLabel lblNewLabel = new JLabel(""); //$NON-NLS-1$

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToeGui window = new TicTacToeGui();
					window.frmTicTacToe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicTacToeGui() {
		this.controller = new TicTaeToeController();
		initialize();

	}

	public void checkButton(int row, int col, JButton button){
		if(controller.setPosition(row, col)){
			//Update icon
			if(controller.getCurrentPlayer()==controller.PLAYER_O){
				button.setIcon(ICON_0);	
			}else{
				button.setIcon(ICON_X);	
			}

			//Check if winner
			if(controller.isCurrentPlayerWinner()){
				JOptionPane.showMessageDialog(frmTicTacToe, 
						controller.getCurrentPlayer()+Messages.getString("TicTacToeGui.IS_WINNER")); //$NON-NLS-1$
				controller.reset();
				resetButtons();
			}else{
				//Check if there is no winner, is there any other free position?
				if(controller.getFreePositions()==0){
					JOptionPane.showMessageDialog(frmTicTacToe, Messages.getString("TicTacToeGui.DRAW")); //$NON-NLS-1$
					controller.reset();
					resetButtons();
				}else{
					controller.changePlayer();
					lblNewLabel.setText(Messages.getString("TicTacToeGui.IS_TURN_OF")+controller.getCurrentPlayer()); //$NON-NLS-1$
				}
			}
		}else{
			JOptionPane.showMessageDialog(frmTicTacToe, Messages.getString("TicTacToeGui.IS_NOT_POSSIBLE_UPDATE")); //$NON-NLS-1$
		}
	

}



/**
 * Initialize the contents of the frame.
 */
private void initialize() {
	frmTicTacToe = new JFrame();
	frmTicTacToe.setResizable(false);
	frmTicTacToe.setTitle(Messages.getString("TicTacToeGui.TITLE")); //$NON-NLS-1$
	frmTicTacToe.setBounds(100, 100, 277, 375);
	frmTicTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




	btnExit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frmTicTacToe.dispose();
		}
	});

	lblNewLabel.setText(Messages.getString("TicTacToeGui.IS_TURN_OF")+this.controller.getCurrentPlayer()); //$NON-NLS-1$

	JLabel lblProgramming = new JLabel(Messages.getString("TicTacToeGui.COURSE")); //$NON-NLS-1$
	GroupLayout groupLayout = new GroupLayout(frmTicTacToe.getContentPane());
	groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addComponent(btn00, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(btn01, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(btn02, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
											.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
													.addComponent(btn10, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(btn11, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(btn12, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
													.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
															.addComponent(btn20, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
															.addGap(18)
															.addComponent(btn21, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
															.addGap(18)
															.addComponent(btn22, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
															.addComponent(lblNewLabel))
															.addGroup(groupLayout.createSequentialGroup()
																	.addComponent(btnReset)
																	.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																	.addComponent(btnExit)))
																	.addContainerGap(21, Short.MAX_VALUE))
																	.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
																			.addContainerGap(144, Short.MAX_VALUE)
																			.addComponent(lblProgramming)
																			.addContainerGap())
			);

	btn00.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			checkButton(0, 0, btn00);
		}

	});

	btn01.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			checkButton(0, 1, btn01);
		}
	});
	btn02.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			checkButton(0, 2, btn02);
		}
	});
	btn10.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			checkButton(1, 0, btn10);
		}
	});
	btn11.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			checkButton(1, 1, btn11);
		}
	});
	btn12.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			checkButton(1, 2, btn12);
		}
	});
	btn20.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			checkButton(2, 0, btn20);
		}
	});
	btn21.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			checkButton(2, 1, btn21);
		}
	});
	btn22.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			checkButton(2, 2, btn22);
		}
	});
	btnReset.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			controller.reset();
			resetButtons();
		}


	});



	groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btn02, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addComponent(btn01, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addComponent(btn00, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(btn10, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addComponent(btn11, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addComponent(btn12, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(btn20, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
											.addComponent(btn21, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
											.addComponent(btn22, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
													.addComponent(btnReset)
													.addComponent(btnExit))
													.addGap(24)
													.addComponent(lblProgramming)
													.addContainerGap())
			);
	frmTicTacToe.getContentPane().setLayout(groupLayout);
}

protected void resetButtons() {
	btn00.setIcon(null);
	btn01.setIcon(null);
	btn02.setIcon(null);
	btn10.setIcon(null);
	btn11.setIcon(null);
	btn12.setIcon(null);
	btn20.setIcon(null);
	btn21.setIcon(null);
	btn22.setIcon(null);
	lblNewLabel.setText(Messages.getString("TicTacToeGui.IS_TURN_OF")+this.controller.getCurrentPlayer()); //$NON-NLS-1$

}
}
