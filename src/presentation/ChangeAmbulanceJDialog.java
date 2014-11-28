package presentation;

import java.util.List;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

import controller.Controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;

import logic.Ambulance;

public class ChangeAmbulanceJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldLongitude;
	private JTextField textFieldLatitude;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JComboBox comboBoxAmbulance = new JComboBox();
	// allAmbu;// = new ArrayList<Ambulance>();
	JRadioButton rdbtnFree;
	JRadioButton rdbtnOccupied;
	Ambulance selectedAmbu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChangeAmbulanceJDialog dialog = new ChangeAmbulanceJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// // This method is invoked from outside this class
	// public void loadAmbulances(){
	// try
	// {
	// Iterator<Ambulance> allAmbulances =
	// Controller.getSingletonController().getAmbulances();
	//
	// }
	// catch (Exception e){
	// JOptionPane.showMessageDialog (null, e.getMessage(),
	// "Error", JOptionPane.ERROR_MESSAGE);
	// }
	// }

	/**
	 * Create the dialog.
	 */

	public void loadAmbus() {
		// try {
		// if (allAmbu == null) {
		List<Ambulance> allAmbu = Controller.getSingletonController()
				.getAmbulances();
		comboBoxAmbulance.removeAllItems();
		for (Ambulance a : allAmbu) {
			// System.out.println("sss" + a.getRegistrationNumber());
			comboBoxAmbulance.addItem(a.getRegistrationNumber());
		}
		// System.out.println("xxxx" + allAmbu.size());
		/*
		 * } catch (Exception e) { JOptionPane.showMessageDialog(null,
		 * e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); }
		 */
		// }
	}

	public ChangeAmbulanceJDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Ambulance:");
			lblNewLabel.setBounds(6, 23, 89, 16);
			contentPanel.add(lblNewLabel);
		}

		// JComboBox comboBoxAmbulance = new JComboBox();
		comboBoxAmbulance.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Ambulance p = Controller.getSingletonController().getAmbulance(
						comboBoxAmbulance.getSelectedItem().toString());
				System.out.println("yyyy");
				// Ambulance p=allAmbu.next();
				System.out.println("zzz");
				{
					textFieldLongitude.setText(String.valueOf(p.getLongitude()));
					textFieldLatitude.setText(String.valueOf(p.getLatitude()));
					System.out.println("aaa");
					if (p.getState() == "free") {
						rdbtnFree.setSelected(true);
						rdbtnOccupied.setSelected(false);
						System.out.println("bbb");
					} else {
						rdbtnFree.setSelected(false);
						rdbtnOccupied.setSelected(true);
					}
					System.out.println("ccc");
				}

			}

		});
		comboBoxAmbulance.setBounds(154, 19, 161, 27);
		contentPanel.add(comboBoxAmbulance);

		JLabel lblAvailability = new JLabel("Availability:");
		lblAvailability.setBounds(6, 65, 89, 16);
		contentPanel.add(lblAvailability);

		rdbtnFree = new JRadioButton("Free");
		buttonGroup.add(rdbtnFree);
		rdbtnFree.setBounds(151, 61, 63, 23);
		contentPanel.add(rdbtnFree);

		rdbtnOccupied = new JRadioButton("Occupied");
		buttonGroup.add(rdbtnOccupied);
		rdbtnOccupied.setBounds(226, 61, 141, 23);
		contentPanel.add(rdbtnOccupied);

		JLabel lblLongitudew = new JLabel("Longitude (W):");
		lblLongitudew.setBounds(6, 110, 107, 16);
		contentPanel.add(lblLongitudew);

		textFieldLongitude = new JTextField();
		textFieldLongitude.setBounds(154, 104, 134, 28);
		contentPanel.add(textFieldLongitude);
		textFieldLongitude.setColumns(10);

		JLabel lblLatitude = new JLabel("Latitude (N):");
		lblLatitude.setBounds(6, 154, 89, 16);
		contentPanel.add(lblLatitude);

		textFieldLatitude = new JTextField();
		textFieldLatitude.setBounds(154, 148, 134, 28);
		contentPanel.add(textFieldLatitude);
		textFieldLatitude.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Change");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						// todo yO mAMA
						// String state = rdbtnFree.isSelected() ?
						// rdbtnFree.getText().substring(0, 1) :
						// rdbtnOccupied.getText().substring(0, 1),

						String newState;
						if (rdbtnFree.isSelected())
							newState = "Free";
						else
							newState = "Occupied";

						String reg = comboBoxAmbulance.getSelectedItem()
								.toString();
						double newLong = Double.parseDouble(textFieldLongitude
								.getText().toString());
						double newLat = Double.parseDouble(textFieldLatitude
								.getText().toString());
						Controller.setAmbuState(reg, newState, newLat, newLong);

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
