package dev.paie.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import dev.paie.entite.Grade;

/**
 * Classe pour mapper un grade
 * @author Sandra Le Thiec
 *
 */
public class GradeMapper implements RowMapper<Grade> {

	@Override
	public Grade mapRow(ResultSet res, int rowNum) throws SQLException {
		Grade g = new Grade();
		g.setId(res.getInt("id"));
		g.setCode(res.getString("code"));
		g.setNbHeuresBase(res.getBigDecimal("nbHeuresBase"));
		g.setTauxBase(res.getBigDecimal("tauxBase"));
		return g;
	}
}
