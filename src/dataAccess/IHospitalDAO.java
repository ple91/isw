// IPatientDAO interface

package dataAccess;

import java.util.List;

import exceptions.DAOException;

import logic.*;

public interface IHospitalDAO {
	public Hospital findHospital(String name) throws DAOException;

	public List<Hospital> getHospital() throws DAOException;
}
