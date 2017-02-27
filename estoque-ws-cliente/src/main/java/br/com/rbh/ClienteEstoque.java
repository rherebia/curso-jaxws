package br.com.rbh;

import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ClienteEstoque {

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:8080/estoquews-web/EstoqueWS?wsdl");
        QName qname = new QName("http://ws.estoque.caelum.com.br/", "EstoqueWS");

        Service service = Service.create(url, qname);

        EstoqueWS cliente = service.getPort(EstoqueWS.class);

        Filtro filtro = new Filtro();
        filtro.setNome("IPhone");
        filtro.setTipo("Celular");;

        ListaItens lista = cliente.todosOsItens(new Filtros(Arrays.<Filtro>asList(filtro)));

        for (Item item : lista.item) {
            System.out.println(item.getNome());
        }
	}

}

