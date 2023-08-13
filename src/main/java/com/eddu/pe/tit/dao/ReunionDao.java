package com.eddu.pe.tit.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import com.eddu.pe.tit.dominio.Reunion;

public class ReunionDao extends AbastractDao<Reunion> {

	public ReunionDao() {
		setClazz(Reunion.class);
	}
	
	public Reunion proximaReunion() {
		String qStr = "FROM " + Reunion.class.getName() + " WHERE fecha > now () order by fecha";
		Query query = getManager().createQuery(qStr).setMaxResults(1);
		return (Reunion) query.getSingleResult();
		
	}


	public List<Reunion> reunionesdiaSiguente(){
		String qStr = "FROM " + Reunion.class.getName() + " WHERE fecha between ?1 and ?2";
		Query query = getManager().createQuery(qStr);
		LocalDate dia = LocalDate.now().plus(1, ChronoUnit.DAYS);
		query.setParameter(1, dia.atStartOfDay());
		query.setParameter(2, dia.plus(1, ChronoUnit.DAYS).atStartOfDay());
		return query.getResultList();
	}

}
