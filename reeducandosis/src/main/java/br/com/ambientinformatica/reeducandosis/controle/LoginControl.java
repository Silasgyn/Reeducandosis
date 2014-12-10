package br.com.ambientinformatica.reeducandosis.controle;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ambientinformatica.reeducandosis.util.InicializadorSistema;

@Controller("LoginControl")
@Scope("conversation")
public class LoginControl {
	InicializadorSistema ini = new InicializadorSistema();
	public String logout() {
		ini.logout();
		return "inicio.jsf";		
	}


}
