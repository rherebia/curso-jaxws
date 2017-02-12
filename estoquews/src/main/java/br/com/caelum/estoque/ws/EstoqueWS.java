package br.com.caelum.estoque.ws;

import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by rherebia on 12/02/17.
 */
@WebService
public class EstoqueWS {

    private ItemDao dao = new ItemDao();
    
    public List<Item> getItens() {
        System.out.println("Chamando getItens()");
        return dao.todosItens();
    }
}
