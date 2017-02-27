package br.com.rbh;

public class TesteServicoWeb {

	public static void main(String[] args) {
		EstoqueWS cliente = new EstoqueWS_Service().getEstoqueWSImplPort();
		
		Filtros filtros = new Filtros();
		
		Filtro filtro = new Filtro();
		filtro.setNome("Iphone");
		filtro.setTipo("Livro");
		filtros.getFiltro().add(filtro);
		
		ListaItens itens = cliente.todosOsItens(filtros);

		System.out.println(itens);
	}
}
