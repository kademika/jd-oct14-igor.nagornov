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

import Tanks.TanksOOP.Tanks.BT7;
import Tanks.TanksOOP.Tanks.Tiger;

public class ChooseTankModelForm implements ActionListener {

	private JLabel tankIcon;
	private ActionField actionField;

	public ChooseTankModelForm() {
		// TODO Auto-generated constructor stub

		this.actionField = actionField;
		final JFrame frame = new JFrame("CHOOSE YOUR ENEMY");
		frame.setLocation(750, 150);
		frame.setMinimumSize(new Dimension(300, 200));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);

		JPanel commonPanel = new JPanel(new BorderLayout());

		final JRadioButton jRadioButtonTiger = new JRadioButton("Tank Tiger");
		jRadioButtonTiger.setSelected(true);
		jRadioButtonTiger.setActionCommand("tigerup.png");
		jRadioButtonTiger.addActionListener(this);

		final JRadioButton jRadioButtonBT7 = new JRadioButton("Tank BT7");
		jRadioButtonBT7.setActionCommand("bt7up.png");
		jRadioButtonBT7.addActionListener(this);

		tankIcon = new JLabel(new ImageIcon("tigerup.png"));

		ButtonGroup bg = new ButtonGroup();
		bg.add(jRadioButtonTiger);
		bg.add(jRadioButtonBT7);

		JButton chooseButton = new JButton("Choose tank");
		chooseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.getContentPane().removeAll();
				frame.dispose();
				ActionField af = new ActionField();
				af.setAgressor(jRadioButtonTiger.isSelected());				

			}
		});

		JPanel choosePanel = new JPanel(new GridLayout(0, 1));
		choosePanel.add(jRadioButtonTiger);
		choosePanel.add(jRadioButtonBT7);
		choosePanel.add(chooseButton);

		commonPanel.add(choosePanel, BorderLayout.LINE_START);
		commonPanel.add(tankIcon, BorderLayout.CENTER);
		commonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		frame.getContentPane().add(commonPanel);
		frame.pack();
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		tankIcon.setIcon(new ImageIcon(e.getActionCommand()));

	}

}
