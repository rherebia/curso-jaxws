package br.com.caelum.estoque.ws;

import br.com.caelum.estoque.modelo.item.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.List;

/**
 * Created by rherebia on 12/02/17.
 */
@WebService
public class EstoqueWS {

    private ItemDao dao = new ItemDao();

    @WebMethod(operationName = "todosOsItens")
    @RequestWrapper(localName = "listaItens")
    @ResponseWrapper(localName = "itens")
    @WebResult(name = "item")
    public List<Item> getItens(@WebParam(name = "filtros") Filtros filtros) {
        System.out.println("Chamando getItens()");
        List<Filtro> lista = filtros.getLista();
        List<Item> itensResultado = dao.todosItens(lista);
        return itensResultado;
    }
}
