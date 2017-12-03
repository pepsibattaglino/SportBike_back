/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Giuseppe
 */
@XmlRootElemententment
public class Moto implements Serializable {
    private int codigo;
    private String modelo;
    private String marca;
    private int cilindradas;
    private double preco;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Moto() {
    }

    public Moto(int codigo, String modelo, String marca, int cilindradas, double preco) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.marca = marca;
        this.cilindradas = cilindradas;
        this.preco = preco;
    }
    
    
    
}
