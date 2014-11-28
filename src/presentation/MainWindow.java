package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frmEmergencyCallService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmEmergencyCallService.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmergencyCallService = new JFrame();
		frmEmergencyCallService.setTitle("Emergency Call Service");
		frmEmergencyCallService.setBounds(100, 100, 450, 300);
		frmEmergencyCallService.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmEmergencyCallService.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Operator");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewPatient = new JMenuItem("New patient");
		mntmNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// code in the MainWindow; the “new patient” menu item is
				// clicked
				NewPatientJDialog newPatient = new NewPatientJDialog();
				newPatient.setModal(true);
				newPatient.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewPatient);

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);

		JMenuItem mntmViewPatients = new JMenuItem("View patients");
		mntmViewPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewAllPatientsJDialog allPatients = new ViewAllPatientsJDialog();
				allPatients.setModal(true);
				allPatients.loadPatients();
				allPatients.setVisible(true);
			}
		});
		mnNewMenu.add(mntmViewPatients);

		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);

		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);
			}
		});

		JMenu mnAmbDriver = new JMenu("Amb. driver");
		menuBar.add(mnAmbDriver);

		JMenuItem mntmChangeAmbulanceState = new JMenuItem(
				"Change ambulance state and position");
		mnAmbDriver.add(mntmChangeAmbulanceState);
		mntmChangeAmbulanceState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ChangeAmbulanceJDialog myAmbulances = new ChangeAmbulanceJDialog();
				myAmbulances.setModal(true);
				myAmbulances.loadAmbus();
				myAmbulances.setVisible(true);
			}
		});

		JMenu mnComOfficer = new JMenu("Com. officer");
		menuBar.add(mnComOfficer);

		JMenuItem mntmHospSpecialities = new JMenuItem("Hosp. Specialities");
		mnComOfficer.add(mntmHospSpecialities);

		mntmHospSpecialities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ViewHospitalSpecialities myHospitals = new ViewHospitalSpecialities();
				myHospitals.setModal(true);
				myHospitals.loadHosp();
				myHospitals.setVisible(true);
			}
		});

		JMenu mnHospManager = new JMenu("Hosp. manager");
		menuBar.add(mnHospManager);
	}

}
