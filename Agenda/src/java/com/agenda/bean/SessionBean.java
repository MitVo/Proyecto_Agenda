
package com.agenda.bean;

import com.agenda.dao.PersonaDaoImpl;
import com.agenda.model.Persona;
import com.agenda.util.Fantasma;
import com.agenda.util.HibernateUtil;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.agenda.util.Fantasma;
import javax.faces.application.FacesMessage;


@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {

    private String login;
    private String pwd;
    private String mail;
    
    private Session session;
    private Transaction transaccion;
    
    public SessionBean()  {
        HttpSession miSession=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        miSession.setMaxInactiveInterval(60);
    }
    
        
    public String login()
    {
        this.session=null;
        this.transaccion=null;
        
        try
        {
            PersonaDaoImpl personaDao = new PersonaDaoImpl();
            
            this.session=HibernateUtil.getSessionFactory().openSession();
            this.transaccion=this.session.beginTransaction();
            
            Persona persona =  personaDao.queryBylogin(this.session, this.login,this.mail);
            
            if(persona!= null)
            {
                Fantasma secret = new Fantasma();
                if(persona.getPwd().equals(secret.getStringMessageDigest(this.pwd,secret.getMD5())))
                {
                    HttpSession httpSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    httpSession.setAttribute("login", this.login);
                    httpSession.setAttribute("mail", this.mail);
                    return "/index";
                }
            }
            
            this.transaccion.commit();
            
            this.login=null;
            this.pwd=null;
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de acceso:", "Usuario o contraseña incorrecto"));
            
            return "/login";
            
        }
        catch(Exception ex)
        {
            if(this.transaccion!=null)
            {
                this.transaccion.rollback();
            }
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador "+ex.getMessage()));
            
            return null;
        }
        finally
        {
            if(this.session!=null)
            {
                this.session.close();
            }
        }
    }

        public String cerrarSesion()
    {
        this.mail=null;
        this.login=null;
        this.pwd=null;
        
        HttpSession httpSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.invalidate();
        
        return "/login";
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
}
