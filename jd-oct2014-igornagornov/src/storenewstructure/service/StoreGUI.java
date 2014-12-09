package storenewstructure.service;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import storenewstructure.guitar.GuitarBrand;
import storenewstructure.guitar.GuitarType;

public class StoreGUI {

	private Store store;
	private String customerName;
	private String guitarType;
	private String guitarBrand;
	private String model;
	private int number;

	private JPanel panel;
	private JLabel customerNameLabel;
	private JLabel guitarModelLabel;
	private JLabel guitarNumberLabel;
	private JLabel printInfoLabel;
	private JLabel chooseTypeLabel;
	private JLabel chooseBrandLabel;
	private JTextField customerNameTextField;
	private JTextField guitarModelTextField;
	private JFormattedTextField guitarNumberTextField;
	private JComboBox jComboBoxGuitarType;
	private JComboBox jComboBoxGuitarBrand;
	private JTextArea jTextArea;
	private JScrollPane scrollPane;
	private JRadioButton jRadioButtonPricesOnly;
	private JRadioButton jRadioButtonAllInfo;
	private JRadioButton jRadioButtonAcousticType;
	private JRadioButton jRadioButtonElectricType;
	private JRadioButton jRadioButtonBassType;
	private JButton jButtonBuy;
	private JButton jButtonShowPurchases;
	private JButton jButtonShowPurchaseStatistics;

	public StoreGUI(Store store) {

		this.store = store;

		JFrame frame = new JFrame("Welcome to guitar store");
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setLocation(200,100);
		frame.getContentPane().add(createPanel());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	private JPanel createPanel() {

		panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		
		JPanel customerPanel = new JPanel();
		customerNameLabel = new JLabel("Enter your name");
		customerPanel.add(customerNameLabel);
		
		customerNameTextField = new JTextField();
		customerNameTextField.setColumns(25);
		customerPanel.add(customerNameTextField);
		panel.add(customerPanel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		JPanel chooseGuitarPanel = new JPanel();
		
		chooseTypeLabel = new JLabel("Choose guitar type");
		chooseGuitarPanel.add(chooseTypeLabel);
		
		String[] jComboBoxGuitarTypeValues = { GuitarType.ACOUSTIC.toString(),
				GuitarType.ELECTRIC.toString(), GuitarType.BASS.toString() };
		jComboBoxGuitarType = new JComboBox(jComboBoxGuitarTypeValues);
		chooseGuitarPanel.add(jComboBoxGuitarType);	
		
		chooseBrandLabel = new JLabel("Choose guitar brand");
		chooseGuitarPanel.add(chooseBrandLabel);
		
		String[] jComboBoxGuitarBrandValues = { GuitarBrand.FENDER.toString(),
				GuitarBrand.IBANEZ.toString(), GuitarBrand.GIBSON.toString(),
				GuitarBrand.JACKSON.toString(), GuitarBrand.ESP.toString() };
		jComboBoxGuitarBrand = new JComboBox(jComboBoxGuitarBrandValues);
		chooseGuitarPanel.add(jComboBoxGuitarBrand);
		
		panel.add(chooseGuitarPanel, new GridBagConstraints(0, 1, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));		
		
		
		JPanel enterFieldsGuitarPanel = new JPanel();
		
		guitarModelLabel = new JLabel("Enter guitar model");
		enterFieldsGuitarPanel.add(guitarModelLabel);		
		
		guitarModelTextField = new JTextField();
		guitarModelTextField.setColumns(10);
		enterFieldsGuitarPanel.add(guitarModelTextField);

		guitarNumberLabel = new JLabel("Enter number");
		enterFieldsGuitarPanel.add(guitarNumberLabel);

		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		guitarNumberTextField = new JFormattedTextField(numberFormat);
		guitarNumberTextField.setValue(1);
		guitarNumberTextField.setColumns(2);
		enterFieldsGuitarPanel.add(guitarNumberTextField);
		model = guitarNumberTextField.getText();	
		
		panel.add(enterFieldsGuitarPanel, new GridBagConstraints(0, 2, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		jTextArea = new JTextArea(10, 50);
		jTextArea.setEditable(false);
		jTextArea.setText(store.printStore(true));
		scrollPane = new JScrollPane(jTextArea);
		panel.add(scrollPane, new GridBagConstraints(0, 3, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		printInfoLabel = new JLabel(store.printNumberOfGuitarType());
		printInfoLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		panel.add(printInfoLabel, new GridBagConstraints(0, 4, 1, 1, 0, 0,
				GridBagConstraints.CENTER, 0, new Insets(0, 0, 0, 0), 0, 0));

		jRadioButtonPricesOnly = new JRadioButton("Prices only");
		jRadioButtonPricesOnly.setSelected(true);
		jRadioButtonPricesOnly.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jTextArea.setText(null);
				jTextArea.setText(store.printStore(true));				
			}
		});

		jRadioButtonAllInfo = new JRadioButton("All information");
		jRadioButtonAllInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jTextArea.setText(null);
				jTextArea.setText(store.printStore(false));				
			}
		});

		ButtonGroup buttonGroupPrintInfo = new ButtonGroup();
		buttonGroupPrintInfo.add(jRadioButtonPricesOnly);
		buttonGroupPrintInfo.add(jRadioButtonAllInfo);

		JPanel filterPanel = new JPanel();
		filterPanel.setLayout(new GridBagLayout());
		filterPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));		
		
		jRadioButtonAcousticType = new JRadioButton("Show acoustic");
		jRadioButtonAcousticType.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jTextArea.setText(null);
				jTextArea.setText(store.printGuitarByType(GuitarType.ACOUSTIC, jRadioButtonPricesOnly.isSelected()));	
			}
		});
		
		jRadioButtonElectricType = new JRadioButton("Show electric");
		jRadioButtonElectricType.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jTextArea.setText(null);
				jTextArea.setText(store.printGuitarByType(GuitarType.ELECTRIC, jRadioButtonPricesOnly.isSelected()));	
			}
		});		
		
		jRadioButtonBassType = new JRadioButton("Show bass");
		jRadioButtonBassType.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jTextArea.setText(null);
				jTextArea.setText(store.printGuitarByType(GuitarType.BASS, jRadioButtonPricesOnly.isSelected()));
			}
		});
		
		ButtonGroup buttonGroupPrintType = new ButtonGroup();
		buttonGroupPrintType.add(jRadioButtonAcousticType);
		buttonGroupPrintType.add(jRadioButtonElectricType);
		buttonGroupPrintType.add(jRadioButtonBassType);
		filterPanel.add(jRadioButtonPricesOnly, new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		filterPanel.add(jRadioButtonAllInfo, new GridBagConstraints(1, 0, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		filterPanel.add(jRadioButtonAcousticType, new GridBagConstraints(0, 1, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		filterPanel.add(jRadioButtonElectricType, new GridBagConstraints(1, 1, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		filterPanel.add(jRadioButtonBassType, new GridBagConstraints(2, 1, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		panel.add(filterPanel, new GridBagConstraints(0, 5, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));		
		

		JPanel actionButtons = new JPanel();
		
		jButtonBuy = new JButton("Buy");
		actionButtons.add(jButtonBuy);			

		jButtonBuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg) {
				// TODO Auto-generated method stub

				try {
					guitarBrand = (String) jComboBoxGuitarBrand
							.getSelectedItem();
					guitarType = (String) jComboBoxGuitarType.getSelectedItem();
					model = guitarModelTextField.getText();
					number = Integer.parseInt(guitarNumberTextField.getText());
					customerName = customerNameTextField.getText();

					if (model.trim().isEmpty()) {
						throw new NullPointerException();
					}

					if (customerName.trim().isEmpty()) {
						store.newPurchase(convertGuitarType(guitarType),
								convertGuitarBrand(guitarBrand), model, number,
								"", new Date());
					} else {
						store.newPurchase(convertGuitarType(guitarType),
								convertGuitarBrand(guitarBrand), model, number,
								customerName, new Date());
					}

					jTextArea.setText(null);
					jTextArea.setText(store.printStore(jRadioButtonPricesOnly.isSelected()));

					printInfoLabel.setText(store.printNumberOfGuitarType());
					printInfoLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

				} catch (NullPointerException e) {
					// TODO: handle exception
					System.err
							.println("One of fields is empty. You should enter values!");
				} catch (IllegalArgumentException e) {
					System.err.println("There is no such guitar in store!");
				} catch (IllegalStateException e) {
					System.err
							.println("Illegal number! We don't have it in store");
				}

			}

		});	
		
		
		jButtonShowPurchases = new JButton("Show purchases");
		actionButtons.add(jButtonShowPurchases);			
		jButtonShowPurchases.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newPurchaseInfoWindow(store.printPurchases(null));
			}
		});		
		
		jButtonShowPurchaseStatistics = new JButton("Show purchase statistics by week");
		actionButtons.add(jButtonShowPurchaseStatistics);
		jButtonShowPurchaseStatistics.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				newPurchaseInfoWindow(store.printNumberOfPurchasesByWeek());
			}
		});
		
		panel.add(actionButtons, new GridBagConstraints(0, 6, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		

		return panel;
	}

	private GuitarType convertGuitarType(String s) {

		if (s.equals(GuitarType.ACOUSTIC.toString())) {
			return GuitarType.ACOUSTIC;
		}

		if (s.equals(GuitarType.ELECTRIC.toString())) {
			return GuitarType.ELECTRIC;
		}

		return GuitarType.BASS;

	}

	private GuitarBrand convertGuitarBrand(String s) {

		if (s.equals(GuitarBrand.FENDER.toString())) {
			return GuitarBrand.FENDER;
		}

		if (s.equals(GuitarBrand.IBANEZ.toString())) {
			return GuitarBrand.IBANEZ;
		}

		if (s.equals(GuitarBrand.GIBSON.toString())) {
			return GuitarBrand.GIBSON;
		}

		if (s.equals(GuitarBrand.JACKSON.toString())) {
			return GuitarBrand.JACKSON;
		}

		return GuitarBrand.ESP;

	}	
	
	private void newPurchaseInfoWindow(String info){
		
		JFrame frame = new JFrame("Purchase information");
		frame.setMinimumSize(new Dimension(600, 450));
		frame.setLocation(300,200);
		JPanel jp = new JPanel();
		
		JTextArea ta = new JTextArea(20, 50);
		ta.setEditable(false);
		ta.setText(info);
		JScrollPane sp = new JScrollPane(ta);				
		jp.add(sp);				
		
		frame.getContentPane().add(jp);

		frame.pack();
		frame.setVisible(true);
		
	}

	

}
