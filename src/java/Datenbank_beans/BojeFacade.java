/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datenbank_beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author h1451938
 */
@Stateless
public class BojeFacade extends AbstractFacade<Boje> {

    @PersistenceContext(unitName = "SailAway-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BojeFacade() {
        super(Boje.class);
    }
    
}
