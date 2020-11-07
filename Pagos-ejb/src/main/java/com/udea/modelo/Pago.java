/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan
 */
@Entity
@Table(name = "PAGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p")
    , @NamedQuery(name = "Pago.findById", query = "SELECT p FROM Pago p WHERE p.id = :id")
    , @NamedQuery(name = "Pago.findByNombreCliente", query = "SELECT p FROM Pago p WHERE p.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "Pago.findByNumeroTarjeta", query = "SELECT p FROM Pago p WHERE p.numeroTarjeta = :numeroTarjeta")
    , @NamedQuery(name = "Pago.findByCvv", query = "SELECT p FROM Pago p WHERE p.cvv = :cvv")
    , @NamedQuery(name = "Pago.findByTipoTarjeta", query = "SELECT p FROM Pago p WHERE p.tipoTarjeta = :tipoTarjeta")
    , @NamedQuery(name = "Pago.findByValorTransaccion", query = "SELECT p FROM Pago p WHERE p.valorTransaccion = :valorTransaccion")
    , @NamedQuery(name = "Pago.findByFechaVencimiento", query = "SELECT p FROM Pago p WHERE p.fechaVencimiento = :fechaVencimiento")
    , @NamedQuery(name = "Pago.findByFechaTransaccion", query = "SELECT p FROM Pago p WHERE p.fechaTransaccion = :fechaTransaccion")
    , @NamedQuery(name = "Pago.findByEmail", query = "SELECT p FROM Pago p WHERE p.email = :email")})
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_CLIENTE")
    private String nombreCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NUMERO_TARJETA")
    private String numeroTarjeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CVV")
    private String cvv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "TIPO_TARJETA")
    private String tipoTarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_TRANSACCION")
    private double valorTransaccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 7, max = 7)
    @Column(name = "FECHA_VENCIMIENTO")
    private String fechaVencimiento;
    @Size(max = 30)
    @Column(name = "FECHA_TRANSACCION")
    private String fechaTransaccion;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;

    public Pago() {
    }

    public Pago(Integer id) {
        this.id = id;
    }

    public Pago(Integer id, String nombreCliente, String numeroTarjeta, String cvv, String tipoTarjeta, double valorTransaccion, String fechaVencimiento, String email) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
        this.tipoTarjeta = tipoTarjeta;
        this.valorTransaccion = valorTransaccion;
        this.fechaVencimiento = fechaVencimiento;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public double getValorTransaccion() {
        return valorTransaccion;
    }

    public void setValorTransaccion(double valorTransaccion) {
        this.valorTransaccion = valorTransaccion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(String fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Pago[ id=" + id + " ]";
    }
    
}
