package Tanks.TanksOOP.Service;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class ChooseTankModelForm implements ActionListener {

	private JLabel tankIcon;
	private ActionField actionField;
	private JFrame chooseEnemyFrame;
	private JButton chooseButton;
	private JRadioButton jRadioButtonTiger;
	private JRadioButton jRadioButtonBT7;
	private boolean chooseButtonClicked;

	public ChooseTankModelForm(ActionField af) {
		// TODO Auto-generated constructor stub

		actionField = af;
		chooseEnemyFrame = new JFrame("CHOOSE YOUR ENEMY");
		chooseEnemyFrame.setLocation(750, 150);
		chooseEnemyFrame.setMinimumSize(new Dimension(300, 200));
		chooseEnemyFrame
				.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		chooseEnemyFrame.setResizable(false);

		JPanel commonPanel = new JPanel(new BorderLayout());

		jRadioButtonTiger = new JRadioButton("Tank Tiger");
		jRadioButtonTiger.setSelected(true);
		jRadioButtonTiger.setActionCommand("tigerup.png");
		jRadioButtonTiger.addActionListener(this);

		jRadioButtonBT7 = new JRadioButton("Tank BT7");
		jRadioButtonBT7.setActionCommand("bt7up.png");
		jRadioButtonBT7.addActionListener(this);

		tankIcon = new JLabel(new ImageIcon("tigerup.png"));

		ButtonGroup bg = new ButtonGroup();
		bg.add(jRadioButtonTiger);
		bg.add(jRadioButtonBT7);

		chooseButton = new JButton("Choose tank");
		chooseButton.setActionCommand("Choose Tank");
		chooseButton.addActionListener(this);

		JPanel choosePanel = new JPanel(new GridLayout(0, 1));
		choosePanel.add(jRadioButtonTiger);
		choosePanel.add(jRadioButtonBT7);
		choosePanel.add(chooseButton);

		commonPanel.add(choosePanel, BorderLayout.LINE_START);
		commonPanel.add(tankIcon, BorderLayout.CENTER);
		commonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		chooseEnemyFrame.getContentPane().add(commonPanel);
		chooseEnemyFrame.pack();
		chooseEnemyFrame.setVisible(true);

		while (true) {
			try {
				if (!chooseButtonClicked) {
					throw new IllegalStateException(
							"You should choose your enemy and press choose button!");
				} else {
					break;
				}
			} catch (IllegalStateException e) {
//				e.printStackTrace();
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == chooseButton) {
			chooseEnemyFrame.getContentPane().removeAll();
			chooseEnemyFrame.dispose();
			actionField.setAgressor(jRadioButtonTiger.isSelected());
			chooseButtonClicked = true;

		} else {
			tankIcon.setIcon(new ImageIcon(e.getActionCommand()));
		}

	}

}
