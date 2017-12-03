/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Moto;
import repositorio.RepositorioMoto;



@Path("motos")
public class MotoWS {

    @Context
    private UriInfo context;

    public MotoWS() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Moto> getMotos() {
        return RepositorioMoto.getInstance().listar();
    }
    
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Moto getMoto(@PathParam("codigo") int cod) {
        return RepositorioMoto.getInstance().buscarPorCodigo(cod);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void adicionarMoto(Moto m, @Context final HttpServletResponse response){
        RepositorioMoto.getInstance().inserir(m);
        response.setStatus(HttpServletResponse.SC_CREATED);
        try{
            response.flushBuffer();
        }catch(IOException e){
            throw new InternalServerErrorException();
        }
    }
   
    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void alerarMoto(@PathParam("codigo") int cod, Moto moto) {
        Moto m = RepositorioMoto.getInstance().buscarPorCodigo(cod);
        m.setModelo(moto.getModelo());
        m.setMarca(moto.getMarca());
        m.setCilindradas(moto.getCilindradas());
        m.setPreco(moto.getPreco());
        RepositorioMoto.getInstance().atualizar(m);   
    }
    
    @DELETE
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Moto removerMoto(@PathParam("codigo") int cod){
        Moto m = RepositorioMoto.getInstance().buscarPorCodigo(cod);
        RepositorioMoto.getInstance().excluir(m);
        return m;
    }
}
