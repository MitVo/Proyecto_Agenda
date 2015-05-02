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
    
}
