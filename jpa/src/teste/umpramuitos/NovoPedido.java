package teste.umpramuitos;

import infra.DAO;
import modelo.basico.Produto;
import umpramuitos.ItemPedido;
import umpramuitos.Pedido;

public class NovoPedido {

	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<>();
		
		Pedido pedido = new Pedido();
		Produto produto = new Produto("TV",1895.99);
		ItemPedido item = new ItemPedido(pedido,produto,2);
		
		dao.abrirTransacao()
		   .incluir(produto)
		   .incluir(pedido)
		   .incluir(item)
		   .fecharTransacao()
		   .fechar();
	}
}
