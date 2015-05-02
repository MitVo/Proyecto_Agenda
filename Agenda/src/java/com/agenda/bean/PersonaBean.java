/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.bean;

import com.agenda.dao.PersonaDaoImpl;
import com.agenda.model.Persona;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

/**
 *
 * @author Usuario
 */
@ManagedBean
@ViewScoped
public class PersonaBean {

    private Persona persona;
    private List<Persona> LPersona;

    public PersonaBean() {
        persona = new Persona();
    }

    @PostConstruct
    public void init() {
        PersonaDaoImpl personaImpl = new PersonaDaoImpl();
        LPersona = personaImpl.findAll();
    }

    public void guardar() {
        PersonaDaoImpl personaImpl = new PersonaDaoImpl();
        personaImpl.create(persona);
        persona = new Persona();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", this.persona.getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void actualizar() {
        PersonaDaoImpl personaImpl = new PersonaDaoImpl();
        personaImpl.update(persona);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información Actualizada", this.persona.getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getLPersona() {
        return LPersona;
    }

    public void setLPersona(List<Persona> LPersona) {
        this.LPersona = LPersona;
    }

}
