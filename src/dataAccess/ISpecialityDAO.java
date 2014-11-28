// IPatientDAO interface

package dataAccess;

import java.util.List;

import exceptions.DAOException;

import logic.*;

public interface ISpecialityDAO {
	public Speciality findSpeciality(String name) throws DAOException;

	public List<Speciality> getSpeciality() throws DAOException;
}
