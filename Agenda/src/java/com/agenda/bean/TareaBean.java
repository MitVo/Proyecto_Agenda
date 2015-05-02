package com.agenda.bean;

import com.agenda.dao.PersonaDaoImpl;
import com.agenda.dao.ProyectoDaoImpl;
import com.agenda.dao.TareaDaoImpl;
import com.agenda.model.Persona;
import com.agenda.model.Proyecto;
import com.agenda.model.Tarea;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean
@ViewScoped
public class TareaBean {

    private String txt6;
    private Tarea tarea;
    private List<Tarea> LTarea;
    private List<Persona> Lpersona;

    @ManagedProperty("#{personaDaoImpl}")
    private PersonaDaoImpl personaDao;
    private Persona persona;

    @ManagedProperty("#{proyectoDaoImpl}")
    private ProyectoDaoImpl proyectoDao;

    public ProyectoDaoImpl getProyectoDao() {
        return proyectoDao;
    }

    public void setProyectoDao(ProyectoDaoImpl proyectoDao) {
        this.proyectoDao = proyectoDao;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    private Proyecto proyecto;
    
    public TareaBean() {
    }

    public List<Persona> complete(String query){
        personaDao = new PersonaDaoImpl();
        return personaDao.queryByName(query);
    }
    
    public List<Proyecto> completePro(String query){
        proyectoDao = new ProyectoDaoImpl();
        return proyectoDao.queryByName(query);
    }
    
    
    public String convertInt(Integer value){
        return String.valueOf(value);
    }
    
    public String nombrePersona(String s, String a){
        return s + " " + a;
    }
    
    //http://www.javabeat.net/primefaces-autocomplete-pojo/
    public PersonaDaoImpl getPersonaDao() {
        return personaDao;
    }

    public void setPersonaDao(PersonaDaoImpl personaDao) {
        this.personaDao = personaDao;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
