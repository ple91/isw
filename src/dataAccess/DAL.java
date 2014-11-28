package dataAccess;

import java.util.ArrayList;
import java.util.List;

import logic.*;
import dataAccess.*;
import exceptions.DAOException;
import exceptions.DomainException;

// Data Access Layer (DAL)
public class DAL {
	// Singleton pattern for DAL with lazy initialization
	private static DAL dal = null;

	public static DAL getSingleton() {
		if (dal == null)
			dal = new DAL();
		return dal;
	}

	private DAL() {
		// empty and private constructor to avoid the creation of multiple DALs
	}

	public void createPatient(Patient p) throws DomainException {
		try {
			// uses the DAO implementation of the persistence lab session
			(new PatientDAOImp()).createPatient(p);
		} catch (DAOException e) {
			throw new DomainException("The patient cannot be created");
		}
	}

	public Patient findPatient(String dni) throws DomainException {
		try {
			// uses the DAO implementation of the persistence lab session
			return (new PatientDAOImp()).findPatient(dni);
		} catch (DAOException e) {
			throw new DomainException("The patient cannot be found");
		}
	}

	public List<Patient> getPatients() throws DomainException {
		try {
			// uses the DAO implementation of the persistence lab session
			return (new PatientDAOImp()).getPatients();
		} catch (DAOException e) {
			throw new DomainException("Patients cannot be recovered");
		}
	}

	public List<Ambulance> getAmbulances() throws DomainException {
		try {
			// uses the DAO implementation of the persistence lab session
			return (new AmbulanceDAOImp()).getAmbulance();
		} catch (DAOException e) {
			throw new DomainException("Ambulances cannot be recovered");
		}
	}

	public List<Hospital> getHospitals() throws DomainException {
		try {
			// uses the DAO implementation of the persistence lab session
			return (new HospitalDAOImp()).getHospital();
		} catch (DAOException e) {
			throw new DomainException("Hospitals cannot be recovered");
		}
	}

	public ArrayList<String> getCurrentSpecList(String hospital)
			throws DomainException {
		try {
			// uses the DAO implementation of the persistence lab session
			return (new HospitalDAOImp()).getCurrentSpecList(hospital);
		} catch (DAOException e) {
			throw new DomainException("Specs cannot be recovered");
		}
	}
}
