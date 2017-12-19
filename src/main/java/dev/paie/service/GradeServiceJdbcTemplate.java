package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dev.paie.entite.Grade;
import dev.paie.mapper.GradeMapper;

/**
 * Service pour la manipulation des données de type Grade avec JDBC
 * 
 * @author Sandra Le Thiec
 *
 */
@Repository
public class GradeServiceJdbcTemplate implements GradeService {

	/* ATTRIBUTS */
	
	/**
	 * Template pour JDBC
	 */
	private JdbcTemplate jdbcTemplate;

	/* METHODES */
	
	/**
	 * Définir la source de données
	 * @param dataSource
	 */
	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Sauvegarder un grade
	 */
	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "INSERT INTO grade (code,nbHeuresBase,tauxBase) VALUES(?,?,?)";
		this.jdbcTemplate.update(sql, nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(),nouveauGrade.getTauxBase());
	}

	/**
	 * Mettre à jour un grade
	 */
	@Override
	public void mettreAJour(Grade grade) {
		String sql = "UPDATE grade SET code = ?,  nbHeuresBase = ?, tauxBase = ? WHERE ID = ? ";
		this.jdbcTemplate.update(sql, grade.getCode(), grade.getNbHeuresBase(), grade.getTauxBase(), grade.getId());
	}

	/**
	 * Lister les grades
	 */
	@Override
	public List<Grade> lister() {
		String sql = "SELECT * FROM grade";
		return this.jdbcTemplate.query(sql, new GradeMapper());
	}

}
