/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.modelo.Pago;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;


/**
 *
 * @author Juan
 */
public class PagosMBean {

    @EJB
    private com.udea.session.PagosManagerLocal pagosManager;

   
    public Pago pago = new Pago();
    
    
    public PagosMBean() {
    }
    /*
    Metodo para insertar un registro en la base de datos, en este, se obtiene la fecha del sistema actual para enviarla a la bd 
    como la fecha en la que ocurrió la transacción
    */
    public String addPayment() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        String time = formatter.format(date);
        pago.setFechaTransaccion(time);
        pagosManager.añadirPago(pago);
        return "CREATED";//pasar de FormularioPago a FacturaPago.xhtml
    }
     
    /*
    Metodo para validar que tipo de tarjeta se ingresó de acuerdo a los rangos de la misma
    */
    public String validarTarjeta(String number){
        
        int numero = Integer.parseInt(number.substring(0,5));
        if(numero>= 11111 && numero <=22222){
            return "American Express";
        }else if(numero>=33333 && numero<=44444){
            return "Diners";
        }else if(numero>=55555 && numero<=66666){
            return "Visa";
        }else if(numero>=77777 && numero<=88888){
            return "Mastercard";
        }else{
        return "";
        }
    }
    /*
    Metodo para validar la entrada del campo email en el FormularioPago.xhtml, si se encuentra un error se retorna el mensaje correspondiente
    */
    public void validarEmail(FacesContext context, UIComponent toValidate, Object value){
        context = FacesContext.getCurrentInstance();
        String email = (String)value;
        
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        if(mather.find()!=true){
           ((UIInput)toValidate).setValid(false);
           context.addMessage(toValidate.getClientId(context), new FacesMessage("El email no tiene el formato correcto "));       
        }
    }
       
    /*
    Metodo para validar que el numero de tarjeta de credito ingresado en FormularioPago.xhtml si corresponde a los tipos de tarjetas aceptadas
    */
    public void avisoTarjeta(FacesContext context, UIComponent toValidate, Object value){
        context = FacesContext.getCurrentInstance();
        String tarjeta = (String)value;
        String tipoTarjeta = validarTarjeta(tarjeta);
        
        if(tipoTarjeta != ""){
            pago.setTipoTarjeta(tipoTarjeta);    
        }else{
           ((UIInput)toValidate).setValid(false);
           context.addMessage(toValidate.getClientId(context), new FacesMessage("La tarjeta no pertenece a las marcas existentes "));
        }
        
    }
    /*
    Metodo para validar que el campo de la fecha en formularioPago.xhtml si tiene el formato correcto, de lo contrario, se envia el mensaje correspondiente
    */
    public void validarFecha(FacesContext context, UIComponent toValidate, Object value){
        context = FacesContext.getCurrentInstance();
        String fecha = (String)value;
              
        if(!isValidDate(fecha)){
           ((UIInput)toValidate).setValid(false);
           context.addMessage(toValidate.getClientId(context), new FacesMessage("Fecha no valida"));
        }
        
    }
    /*
    Metodo para validar que la fecha de vencimiento de la tarjeta si cuenta con el formato especificado (MM/yyyy)
    */
    public boolean isValidDate(String dateString) {
       SimpleDateFormat df = new SimpleDateFormat("MM/yyyy");
       try {          
           df.parse(dateString);
           return true;
       } catch (ParseException e) {
           return false;
       }
}
    
    
    public Pago getPago(){
        return pago;
    }  
    /*
    Metodo para pasar de FacturaPago.xhtml a index.xhtml
    */
    public String menu(){
        return "MENU";//Pasar de FacturaPago.xhtml a index.xhtml
    } 
    /*
    Metodo para pasar de FormularioPago.xhtml a index.xhtml
    */
    public String cancel(){
        return "CANCEL";// pasar de FormularioPago.xhtml a index.
    }
    /*
    Metodo para pasar de index.xhtml a formularioPago.xhtml
    */
    public String goPayment(){
        return "PAGAR";
    }

     
  

  
}
