package Store.Service;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Store.Guitar.Guitar;
import Store.Guitar.GuitarBrand;
import Store.Guitar.GuitarType;
import Store.Purchase.Purchase;

public class StoreGUI {

	private Store store;
	private String customerName;
	private String guitarType;
	private String guitarBrand;
	private String model;
	private int number;

	private JPanel panel;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JFormattedTextField jTextField3;
	private JComboBox jComboBoxGuitarType;
	private JComboBox jComboBoxGuitarBrand;
	private JTextArea jTextArea;
	private JButton jButton1;

	public StoreGUI(Store store) {

		this.store = store;

		JFrame frame = new JFrame("Welcome to guitar store");
		frame.setMinimumSize(new Dimension(600, 400));
		frame.setLocation(400, 400);
		frame.getContentPane().add(createPanel());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	private JPanel createPanel() {

		panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		jLabel1 = new JLabel("Enter your name");
		panel.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));

		jTextField1 = new JTextField();
		jTextField1.setColumns(25);
		panel.add(jTextField1, new GridBagConstraints(1, 0, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		String[] jComboBoxGuitarTypeValues = { GuitarType.ACOUSTIC.toString(),
				GuitarType.ELECTRIC.toString(), GuitarType.BASS.toString() };
		jComboBoxGuitarType = new JComboBox(jComboBoxGuitarTypeValues);
		panel.add(jComboBoxGuitarType, new GridBagConstraints(0, 2, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		String[] jComboBoxGuitarBrandValues = { GuitarBrand.FENDER.toString(),
				GuitarBrand.IBANEZ.toString(), GuitarBrand.GIBSON.toString(),
				GuitarBrand.JACKSON.toString(), GuitarBrand.ESP.toString() };
		jComboBoxGuitarBrand = new JComboBox(jComboBoxGuitarBrandValues);//
		panel.add(jComboBoxGuitarBrand, new GridBagConstraints(1, 2, 1, 1, 0,
				0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0,
				0));

		jLabel2 = new JLabel("Enter guitar model");
		panel.add(jLabel2, new GridBagConstraints(0, 4, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		jTextField2 = new JTextField();
		jTextField2.setColumns(10);
		panel.add(jTextField2, new GridBagConstraints(1, 4, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		jLabel3 = new JLabel("Enter number");
		panel.add(jLabel3, new GridBagConstraints(0, 5, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));

		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		jTextField3 = new JFormattedTextField(numberFormat);
		jTextField3.setValue(1);
		jTextField3.setColumns(2);
		panel.add(jTextField3, new GridBagConstraints(1, 5, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		model = jTextField3.getText();

		jTextArea = new JTextArea(10, 30);
		jTextArea.setEditable(false);
		panel.add(jTextArea, new GridBagConstraints(1, 6, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		printPrices();		

		jButton1 = new JButton("Buy");
		panel.add(jButton1, new GridBagConstraints(1, 7, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg) {
				// TODO Auto-generated method stub

				try {
					guitarBrand = (String) jComboBoxGuitarBrand
							.getSelectedItem();
					guitarType = (String) jComboBoxGuitarType.getSelectedItem();
					model = jTextField2.getText();
					number = Integer.parseInt(jTextField3.getText());
					customerName = jTextField1.getText();

					if (model.trim().isEmpty()) {
						throw new NullPointerException();
					}

					if (customerName.trim().isEmpty()) {
						store.newPurchase(convertGuitarType(guitarType),
								convertGuitarBrand(guitarBrand), model, number, "", new Date());
					} else {
						store.newPurchase(convertGuitarType(guitarType),
								convertGuitarBrand(guitarBrand), model, number, customerName, new Date());
					}

					jTextArea.setText(null);
					printPrices();
					store.printPurchases();	
					store.printNumberOfGuitarType();

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

	private void printPrices() {

		for (Guitar[][] guitarType : store.getDb().getGuitar()) {
			if (guitarType != null) {
				for (Guitar[] guitarBrand : guitarType) {
					if (guitarBrand != null) {
						for (Guitar guitarTemp : guitarBrand) {
							if (guitarTemp != null) {
								jTextArea.append(guitarTemp
										.getClass()
										.getName()
										.substring(
												guitarTemp.getClass().getName()
														.lastIndexOf(".") + 1)
										+ " "
										+ guitarTemp.getGuitarBrand()
										+ " "
										+ guitarTemp.getColor()
										+ " "
										+ guitarTemp.getModel()
										+ " "
										+ guitarTemp.getPrice() + "\n");

							}
						}
					}
				}
			}

		}

	}

}
