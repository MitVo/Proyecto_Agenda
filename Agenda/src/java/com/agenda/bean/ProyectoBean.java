/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agenda.bean;

import com.agenda.dao.ProyectoDaoImpl;
import com.agenda.model.Proyecto;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Usuario
 */
@ManagedBean
@ViewScoped
public class ProyectoBean {
    private Proyecto proyecto;
    private List<Proyecto> Lproyecto;
    
    public ProyectoBean() {
        proyecto = new Proyecto();
    }
    @PostConstruct
    public void init() {
        ProyectoDaoImpl proyectoDao = new ProyectoDaoImpl();
        Lproyecto = proyectoDao.findAll();
    }
    public void guardar(){
        ProyectoDaoImpl proyectoDao = new ProyectoDaoImpl();
        proyectoDao.create(proyecto);
        proyecto = new Proyecto();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", this.proyecto.toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
     public void actualizar() {
        ProyectoDaoImpl proyectoDao = new ProyectoDaoImpl();
        proyectoDao.update(proyecto);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información Actualizada", this.proyecto.toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<Proyecto> getLproyecto() {
        return Lproyecto;
    }

    public void setLproyecto(List<Proyecto> Lproyecto) {
        this.Lproyecto = Lproyecto;
    }
    
    
}
