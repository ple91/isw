// IPatientDAO interface

package dataAccess;

import java.util.List;

import exceptions.DAOException;

import logic.Patient;

public interface IPatientDAO {
	public Patient findPatient(String dni) throws DAOException;

	public void createPatient(Patient p) throws DAOException;

	public List<Patient> getPatients() throws DAOException;
}
