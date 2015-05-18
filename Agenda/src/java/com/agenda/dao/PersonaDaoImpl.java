/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.dao;

import java.io.Serializable;
import com.agenda.model.Persona;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author TIC
 */
public class PersonaDaoImpl extends GenericDaoImpl<Persona, Integer> implements PersonaDao{
  

    public List<Persona> queryByName(String name){
		// Assumed search using the startsWith
		List<Persona> queried = new ArrayList<Persona>();
		for(Persona per: super.findAll()){
			if(per.getNombre().toLowerCase().startsWith(name.toLowerCase())){
				queried.add(per);
			}
		}
		return queried;
	}
    
        public Persona queryBylogin(Session session, String login, String mail) throws Exception{
        Persona persona = new Persona();
        String hql = "from Persona where user = 1 and (login = :lg or mail = :mail)";
        Query query = session.createQuery(hql);
        query.setParameter("lg", login);
        query.setParameter("mail", mail);
        return persona = (Persona) query.uniqueResult();
    }
}
