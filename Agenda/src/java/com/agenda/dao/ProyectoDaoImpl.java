/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.dao;

import java.io.Serializable;
import com.agenda.model.Proyecto;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author TIC
 */
public class ProyectoDaoImpl extends GenericDaoImpl<Proyecto, Integer> implements ProyectoDao{
 
        public List<Proyecto> queryByName(String name){
            
		List<Proyecto> queried = new ArrayList<Proyecto>();
		for(Proyecto pro: super.findAll()){
			if(pro.getNombre().toLowerCase().startsWith(name.toLowerCase())){
				queried.add(pro);
			}
		}
		return queried;
	}
    
}
