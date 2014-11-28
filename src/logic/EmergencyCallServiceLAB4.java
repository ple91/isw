// EmergencyCallService class

package logic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import dataAccess.PatientDAOImp;
import exceptions.DAOException;

public class EmergencyCallServiceLAB4 {
	private HashMap<String, Patient> patients; // our collection for patients

	public EmergencyCallServiceLAB4() {
		this.patients = new HashMap<String, Patient>();
	}

	public void addPatient(Patient p) {
		// add this patient to patients if it's not already in it
		if (!this.patients.containsKey(p.getDni())) {
			try {
				// not found -> add it, both in the database and (if no problem)
				// also in memory!
				(new PatientDAOImp()).createPatient(p);

				this.patients.put(p.getDni(), p);
			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
	}

	public Patient findPatient(String dni) {
		Patient p = this.patients.get(dni);

		if (p == null) {
			// the patient is not in memory; find it in the database!
			try {
				p = (new PatientDAOImp()).findPatient(dni);

				if (p != null) {
					// from now on the patient will be also in memory
					this.patients.put(dni, p);
				}

			} catch (DAOException e) {
				e.printStackTrace();
			}
		}

		return p;
	}

	public Iterator<Patient> getPatients() {
		try {
			// get all patients from the database as we have NO guarantee they
			// are all in memory
			List<Patient> dbPatients = (new PatientDAOImp()).getPatients();
			for (Patient p : dbPatients)
				if (!this.patients.containsKey(p.getDni())) {
					// not found in memory -> add it!
					this.patients.put(p.getDni(), p);
				}
		} catch (DAOException e) {
			e.printStackTrace();
		}

		return this.patients.values().iterator();
	}
}
