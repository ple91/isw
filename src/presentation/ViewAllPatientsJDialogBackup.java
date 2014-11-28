package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.Controller;
import logic.Patient;

public class ViewAllPatientsJDialogBackup extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablePatients;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewAllPatientsJDialogBackup dialog = new ViewAllPatientsJDialogBackup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewAllPatientsJDialogBackup() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);

		}
		{
			// tablePatients has now our particular table model
			tablePatients = new JTable(new PatientTableModel());
			scrollPane.setViewportView(tablePatients);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	// This method is invoked from outside this class
	public void loadPatients() {
		try {
			PatientTableModel model = (PatientTableModel) tablePatients
					.getModel();
			model.clear();
			Iterator<Patient> allPatients = Controller.getSingletonController()
					.getPatients();
			while (allPatients.hasNext()) {
				model.addRow(allPatients.next());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// **************************************************************
	// Internal class for the table model (implemented in the
	// ViewAllPatientsJDialog class)
	// **************************************************************
	class PatientTableModel extends AbstractTableModel {
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

		// This method is executed when the table needs the value of a field
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
