package Facade;

import Pagamenti.Controller.PagamentoController;
import Pagamenti.View.StoricoPagamentiUI;

public class PagamentoFacade {
	private PagamentoController pagamentoController;
	private static PagamentoFacade instance;
	
	public static PagamentoFacade getInstance() {
		if(instance == null) {
			instance = new PagamentoFacade();
			instance.setPagamentoController(new PagamentoController (instance));
		}
		return instance;
	}
	
	public PagamentoController getPagamentoController() {
		return pagamentoController;
	}

	public void setPagamentoController(PagamentoController pagamentoController) {
		this.pagamentoController = pagamentoController;
	}
	
	public void showStoricoPagamentiUI() {
		StoricoPagamentiUI.display();
	}
}
