// IAmbulanceDAO interface

package dataAccess;

import java.util.List;

import exceptions.DAOException;

import logic.*;

public interface IAmbulanceDAO {
	public Ambulance findAmbulance(String registrationNumber)
			throws DAOException;

	public List<Ambulance> getAmbulance() throws DAOException;
}
