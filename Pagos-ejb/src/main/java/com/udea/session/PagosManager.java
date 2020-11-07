/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 /* String name = pago.getNombreCliente();
        System.out.println(name);*/


package com.udea.session;


import com.udea.modelo.Pago;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juan
 */
@Stateless
public class PagosManager implements PagosManagerLocal {

    @PersistenceContext(unitName = "com.udea_Pagos-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    

    @Override
    public void añadirPago(Pago pago) {
        em.persist(pago);
    }

    
    
    
}
