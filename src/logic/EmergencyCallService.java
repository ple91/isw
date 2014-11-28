// EmergencyCallService class

package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import dataAccess.DAL;
import exceptions.DomainException;

public class EmergencyCallService {

	private HashMap<String, Patient> patients; // our collection for patients
	private ArrayList<Ambulance> ambulances; // our collection for ambulances
	private ArrayList<Hospital> hospitals;

	// private ArrayList<String> currentSpecList;

	public EmergencyCallService() {
		this.patients = new HashMap<String, Patient>();
		this.ambulances = new ArrayList<Ambulance>();
		this.hospitals = new ArrayList<Hospital>();
		// this.currentSpecList = new ArrayList<String>();

		// createSomeAmbulances();
	}

	public void addPatient(Patient p) {
		// add this patient to patients if it's not already in it
		if (!this.patients.containsKey(p.getDni())) {
			try {
				// not found -> add it, both in the database and (if no problem)
				// also in memory!
				DAL.getSingleton().createPatient(p);

				this.patients.put(p.getDni(), p);
			} catch (DomainException e) {
				e.printStackTrace();
			}
		}
	}

	public Patient findPatient(String dni) {
		Patient p = this.patients.get(dni);

		if (p == null) {
			// the patient is not in memory; find it in the database!
			try {
				p = DAL.getSingleton().findPatient(dni);

				if (p != null) {
					// from now on the patient will be also in memory
					this.patients.put(dni, p);
				}
			} catch (DomainException e) {
				e.printStackTrace();
			}
		}

		return p;
	}

	public Iterator<Patient> getPatients() {
		try {
			// get all patients from the database as we have NO guarantee they
			// are all in memory
			List<Patient> dbPatients = DAL.getSingleton().getPatients();

			for (Patient p : dbPatients)
				if (!this.patients.containsKey(p.getDni())) {
					// not found in memory -> add it!
					this.patients.put(p.getDni(), p);
				}
		} catch (DomainException e) {
			e.printStackTrace();
		}

		return this.patients.values().iterator();
	}

	public List<Ambulance> getAmbulances() {

		if (ambulances.size() == 0) {
			try {
				// get all Ambulances from the database as we have NO guarantee
				// they
				// are all in memory
				List<Ambulance> dbAmbulances = DAL.getSingleton()
						.getAmbulances();

				for (Ambulance p : dbAmbulances)

				{
					// not found in memory -> add it!

					this.ambulances.add(p);

				}
			} catch (DomainException e) {
				e.printStackTrace();
			}
		}
		return ambulances;
	}

	public void setAmbuState(String reg, String newState, double newLat,
			double newLong) {
		// TODO Auto-generated method stub
		for (Ambulance p : ambulances)

		{
			// not found in memory -> add it!
			if (p.getRegistrationNumber() == reg) {
				p.setState(newState);
				p.setLatitude(newLat);
				p.setLongitude(newLong);
			}
		}

	}

	public Ambulance getAmbulance(String selectedItem) {

		for (Ambulance p : ambulances)

		{
			// not found in memory -> add it!
			if (p.getRegistrationNumber() == selectedItem) {
				return p;
			}
		}
		return null;
	}

	public List<Hospital> getHospitals() {
		if (hospitals.size() == 0) {
			try {
				// get all Ambulances from the database as we have NO guarantee
				// they
				// are all in memory
				List<Hospital> dbHospitals = DAL.getSingleton().getHospitals();

				for (Hospital h : dbHospitals)

				{
					// not found in memory -> add it!

					this.hospitals.add(h);

				}
			} catch (DomainException e) {
				e.printStackTrace();
			}
		}
		return hospitals;
	}

	public ArrayList<String> getSpecList(String hospital) {

		try {
			return DAL.getSingleton().getCurrentSpecList(hospital);
		} catch (DomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
