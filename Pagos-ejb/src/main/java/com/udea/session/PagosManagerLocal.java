/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;


import com.udea.modelo.Pago;
import javax.ejb.Local;

/**
 *
 * @author Juan
 */
@Local
public interface PagosManagerLocal {

    
    void añadirPago(Pago pago);

}
