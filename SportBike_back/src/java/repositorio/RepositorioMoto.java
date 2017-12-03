/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Moto;

/**
 *
 * @author Giuseppe
 */
public class RepositorioMoto {
    private static RepositorioMoto instancia;
    private List<Moto> listaMotos;
    private int autoIncrement;
    
    private RepositorioMoto(){
        listaMotos = new ArrayList<>();
        listaMotos.add(new Moto(1, "999", "Ducati", 1000, 25000.00));
        listaMotos.add(new Moto(2, "rg", "Yamaha", 400, 9000.00));
        listaMotos.add(new Moto(3, "883", "Harley Davidson", 1600, 50000.00));
        autoIncrement = 4;
    }
    
    public static synchronized RepositorioMoto getInstance(){
        if (instancia == null){
            instancia = new RepositorioMoto();
        }
        return instancia;
    }
    
    public void inserir (Moto m){
        if (m.getCodigo() == 0){
            m.setCodigo(autoIncrement++);
        }
        listaMotos.add(m);
    }
    
    public List<Moto> listar(){
        return listaMotos;
    }
    
    public Moto buscarPorCodigo(int cod){
        for (Moto m: listaMotos) {
            if (m.getCodigo() == cod) {
                return new Moto(m.getCodigo(),
                                m.getModelo(),
                                m.getMarca(),
                                m.getCilindradas(),
                                m.getPreco());
            }
        }
        return null;
    }
    
    private int getIndice(int codigo){
        for (int i = 0; i < listaMotos.size(); i++) {
            if (listaMotos.get(i).getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }
    
    public void atualizar(Moto mot){
        listaMotos.set(this.getIndice(mot.getCodigo()), mot);
    }
    
    public void excluir(Moto mot){
        listaMotos.set(this.getIndice(mot.getCodigo()), mot);
    }
}
