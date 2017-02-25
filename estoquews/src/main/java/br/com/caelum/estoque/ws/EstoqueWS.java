package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.usuario.AutorizacaoException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

/**
 * Created by rherebia on 12/02/17.
 */
@WebService
public class EstoqueWS {

    private ItemDao dao = new ItemDao();

    @WebMethod(operationName = "TodosOsItens")
    @RequestWrapper(localName = "listaItens")
    @ResponseWrapper(localName = "itens")
    @WebResult(name = "item")
    public List<Item> getItens(@WebParam(name = "filtros") Filtros filtros) {
        System.out.println("Chamando getItens()");
        List<Filtro> lista = filtros.getLista();
        List<Item> itensResultado = dao.todosItens(lista);
        return itensResultado;
    }
    
    @WebMethod(operationName = "CadastrarItem")
    @WebResult(name = "item")
    public Item cadastrarItem(@WebParam(name = "token", header = true) TokenUsuario token, @WebParam(name = "item") Item item) throws AutorizacaoException {
    	boolean valido = new TokenDao().ehValido(token);
    	
    	if (!valido) {
    		throw new AutorizacaoException("Autorização falhou");
    	}
    	this.dao.cadastrar(item);
    	
    	return item;
    }
}
