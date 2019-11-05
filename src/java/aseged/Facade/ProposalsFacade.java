/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aseged.Facade;

import aseged.Entities.Proposals;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aseged
 */
@Stateless
public class ProposalsFacade extends AbstractFacade<Proposals> {

    @PersistenceContext(unitName = "aseged_RulesChangeProposalsPU")
    private EntityManager em;

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     */
    public ProposalsFacade() {
        super(Proposals.class);
    }
    
}
