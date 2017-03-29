/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author h1451938
 */
@Stateless
public class CrewmemberFacade extends AbstractFacade<Crewmember> {

    @PersistenceContext(unitName = "SailAway2.0-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CrewmemberFacade() {
        super(Crewmember.class);
    }
    
}
