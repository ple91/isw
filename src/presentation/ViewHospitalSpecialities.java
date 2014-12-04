package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import logic.Ambulance;
import logic.Hospital;
import logic.Patient;
import controller.Controller;

import javax.swing.JList;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewHospitalSpecialities extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JComboBox<String> comboBox;
	JList listOfSpec;
	private DefaultListModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewHospitalSpecialities dialog = new ViewHospitalSpecialities();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */

	public void loadHosp() {

		List<Hospital> allHosp = Controller.getSingletonController()
				.getHospitals();
		comboBox.removeAllItems();
		for (Hospital h : allHosp) {

			comboBox.addItem(h.getName());
		}

	}

	public ViewHospitalSpecialities() {
		// model.addElement("Specialities of Hospital: ");
		model = new DefaultListModel();

		setTitle("Hospital Specialities");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblHospital = new JLabel("Hospital");
			lblHospital.setBounds(22, 19, 71, 14);
			contentPanel.add(lblHospital);
		}
		{
			comboBox = new JComboBox();
			comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					ArrayList<String> specList = Controller
							.getSingletonController().getSpecList(
									comboBox.getSelectedItem().toString());
					// listOfSpec = new JList(specList.toArray());
					// listOfSpec.setVisible(true);
					model = new DefaultListModel();
					for (String s : specList) {
						//System.out.println(s);
						model.addElement(s);
					}
					listOfSpec.setModel(model);

				}
			});
			comboBox.setBounds(148, 15, 284, 22);
			contentPanel.add(comboBox);
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 422, 148);
		contentPanel.add(scrollPane);
		{
			listOfSpec = new JList();
			scrollPane.setViewportView(listOfSpec);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
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
		listOfSpec.setModel(model);

		JLabel lblSpecialitiesOfSelected = new JLabel(
				"Specialities of selected Hospital:");
		lblSpecialitiesOfSelected.setBounds(10, 56, 254, 14);
		contentPanel.add(lblSpecialitiesOfSelected);
	}

	class SpecTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		// Columns of the table
		private String[] columnNames = { "DNI", "Name", "Surname", "Age",
				"Gender", "Age", "Phone number", "Address" };
		// Data to be shown
		private ArrayList<Patient> data = new ArrayList<Patient>();

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		// This method is executed when the table needs the value

		public Object getValueAt(int row, int col) {
			Patient p = data.get(row);
			switch (col) {
			case 0:
				return p.getDni();
			case 1:
				return p.getName();
			case 2:
				return p.getSurname();
			case 3:
				return p.getAge();
			case 4:
				return p.getGender();
			case 5:
				return p.getAge();
			case 6:
				return p.getPhoneNumber();
			case 7:
				return p.getAddress();
			default:
				return null;
			}
		}

		public void clear() {
			data.clear();
		}

		/*
		 * JTable uses this method to determine the default renderer editor for
		 * each cell.
		 */
		public Class<? extends Object> getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		public void addRow(Patient row) {
			data.add(row);
		}

		public void delRow(int row) {
			data.remove(row);
		}
	}
}
