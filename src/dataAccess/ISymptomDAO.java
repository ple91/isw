// ISymptomDAO interface

package dataAccess;

import java.util.List;

import exceptions.DAOException;

import logic.*;

public interface ISymptomDAO {
	public Symptom findSymptom(String idSpeciality, String id)
			throws DAOException;

	public void createSymptom(Symptom p) throws DAOException;

	public List<Symptom> getSymptoms() throws DAOException;
}
