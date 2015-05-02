/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import com.agenda.dao.PersonaDaoImpl;
import com.agenda.model.Persona;

import com.agenda.dao.TareaDaoImpl;
import com.agenda.model.Tarea;

import com.agenda.dao.ProyectoDaoImpl;
import com.agenda.model.Proyecto;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        
        PersonaDaoImpl personaDao = new PersonaDaoImpl();
        Persona persona = new Persona("Alexander", "Bravo Martinez", "alexb760@gmail.com");
        
        ProyectoDaoImpl proyectoDao = new ProyectoDaoImpl();
        Proyecto proyecto = new Proyecto("Hibernate 2.0", "Loremzo ipzum hheuehueh heuheuheu ");
        
        TareaDaoImpl tareaDao = new TareaDaoImpl();
        Tarea tarea = new Tarea(persona, proyecto, "Ejercicio No1", "Ejercicio desarrollo Con Hibernate", date, 0, true);
        
        personaDao.create(persona);
        proyectoDao.create(proyecto);
        int id = tareaDao.create(tarea);
        System.out.println(id);*/
        inset();
        System.exit(0);
    }
    
    public static void inset(){
        
        PersonaDaoImpl personaDao = new PersonaDaoImpl();
        
        for(int i = 0; i<=1000; i++){
            Persona persona = new Persona("Alexander" + i, "Bravo Martinez"+ i, "alexb760@gmail.com");
            personaDao.create(persona);
        }
        
    }
    }
    

