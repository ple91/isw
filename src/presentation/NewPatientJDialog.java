package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;

import controller.Controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.Patient;

public class NewPatientJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldDNI;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NewPatientJDialog dialog = new NewPatientJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NewPatientJDialog() {
		setTitle("");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(6, 20, 61, 16);
		contentPanel.add(lblDni);

		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(117, 14, 260, 28);
		contentPanel.add(textFieldDNI);
		textFieldDNI.setColumns(10);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(6, 60, 61, 16);
		contentPanel.add(lblNewLabel);

		textFieldName = new JTextField();
		textFieldName.setBounds(117, 54, 260, 28);
		contentPanel.add(textFieldName);
		textFieldName.setColumns(10);

		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(6, 89, 61, 16);
		contentPanel.add(lblSurname);

		textFieldSurname = new JTextField();
		textFieldSurname.setBounds(117, 83, 260, 28);
		contentPanel.add(textFieldSurname);
		textFieldSurname.setColumns(10);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(6, 117, 61, 16);
		contentPanel.add(lblGender);

		final JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBounds(117, 113, 66, 23);
		contentPanel.add(rdbtnMale);

		final JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(195, 113, 141, 23);
		contentPanel.add(rdbtnFemale);

		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(6, 176, 119, 16);
		contentPanel.add(lblPhoneNumber);

		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setBounds(117, 170, 260, 28);
		contentPanel.add(textFieldPhoneNumber);
		textFieldPhoneNumber.setColumns(10);

		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(6, 148, 61, 16);
		contentPanel.add(lblAge);

		final JSpinner spinnerAge = new JSpinner();
		spinnerAge.setBounds(117, 136, 48, 28);
		contentPanel.add(spinnerAge);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(6, 204, 61, 16);
		contentPanel.add(lblAddress);

		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(117, 198, 260, 28);
		contentPanel.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							Patient pat = new Patient(textFieldDNI.getText(),
									textFieldName.getText(), textFieldSurname
											.getText(),
									rdbtnMale.isSelected() ? rdbtnMale
											.getText().substring(0, 1)
											: rdbtnFemale.getText().substring(
													0, 1), (Integer) spinnerAge
											.getValue(), textFieldPhoneNumber
											.getText(), textFieldAddress
											.getText());
							Controller.getSingletonController()
									.CreateNewPatient(pat);
							dispose();
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage(),
									"Error", JOptionPane.ERROR_MESSAGE);
						}
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
