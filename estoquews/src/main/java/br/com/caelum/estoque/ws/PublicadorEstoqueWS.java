package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

/**
 * Created by rherebia on 12/02/17.
 */
public class PublicadorEstoqueWS {

    public static void main(String args[]) {

        EstoqueWS implementacaoWS = new EstoqueWS();
        String URL = "http://localhost:8080/estoquews";

        System.out.println("EstoqueWS rodando: " + URL);

        //associando URL com implementacao
        Endpoint.publish(URL, implementacaoWS);
    }
}
