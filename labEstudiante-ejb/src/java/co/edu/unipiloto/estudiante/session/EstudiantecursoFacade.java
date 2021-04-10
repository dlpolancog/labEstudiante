/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.estudiante.session;

import co.edu.unipiloto.estudiante.entity.Estudiantecurso;
import co.edu.unipiloto.estudiante.entity.EstudiantecursoPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dlpol
 */
@Stateless
public class EstudiantecursoFacade extends AbstractFacade<Estudiantecurso> implements EstudiantecursoFacadeLocal {

    @PersistenceContext(unitName = "EstudiantePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudiantecursoFacade() {
        super(Estudiantecurso.class);
    }
    
}
