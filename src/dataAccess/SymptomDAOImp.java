// SymptomDAOImp class

package dataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logic.Symptom;
import exceptions.DAOException;

public class SymptomDAOImp implements ISymptomDAO {

	private ConnectionManager connManager;

	public SymptomDAOImp() throws DAOException {
		super();

		try {
			connManager = new ConnectionManager("ISW_DB");
		} catch (ClassNotFoundException e) {
			throw new DAOException(e);
		}
	}

	public Symptom findSymptom(String idSpeciality, String id)
			throws DAOException {
		try {
			connManager.connect();
			ResultSet rs = connManager
					.queryDB("select * from Symptom where idSpeciality= '"
							+ idSpeciality + "'");
			connManager.close();

			if (rs.next())
				return new Symptom(idSpeciality, id, rs.getString("NAME"),
						rs.getString("DESCRIPTION"), rs.getDouble("DURATION"),
						rs.getInt("STAGE GRAVITY"));
			else
				return null;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public void createSymptom(Symptom p) throws DAOException {
		try {
			connManager.connect();
			connManager
					.updateDB("insert into Symptom (IDSPECIALITY,ID, NAME, DESCRIPTION, DURATION,STAGE GRAVITY) values('"
							+ p.getId()
							+ "','"
							+ p.getIdSpeciality()
							+ "','"
							+ p.getName()
							+ "','"
							+ p.getDescription()
							+ "', '"
							+ p.getDuration() + "', " + p.getStageOfGravity());
			connManager.close();

		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public List<Symptom> getSymptoms() throws DAOException {
		try {
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from Symptom");
			connManager.close();

			List<Symptom> listSymptoms = new ArrayList<Symptom>(); // the
																	// collection
																	// as an
																	// ArrayList
			while (rs.next()) {
				Symptom pa = findSymptom(rs.getString("IDSPECIALITY"),
						rs.getString("ID"));
				listSymptoms.add(pa);
			}

			return listSymptoms;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}
