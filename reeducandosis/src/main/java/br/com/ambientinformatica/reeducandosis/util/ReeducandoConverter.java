package br.com.ambientinformatica.reeducandosis.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.util.FabricaAbstrata;
import br.com.ambientinformatica.reeducandosis.entidade.Reeducando;
import br.com.ambientinformatica.reeducandosis.persistencia.ReeducandoDao;

@FacesConverter("reeducandoConverter")
public class ReeducandoConverter implements Converter {
	
	
	
	private ReeducandoDao reeducandoDao = (ReeducandoDao) FabricaAbstrata
			.criarObjeto("reeducandoDao");

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component,
			Object value) {
		if (value == null || value.equals("")) {
			return "";
		} else {
			return String.valueOf(((Reeducando) value).getId());
		}
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && !value.trim().equals("")) {
			Reeducando reeducando = new Reeducando();
			try {
				int id = Integer.parseInt(value);

				try {
					reeducando = reeducandoDao.consultar(id);
				} catch (PersistenciaException e) {
					e.printStackTrace();
				}
			} catch (NumberFormatException exception) {
				// throw new ConverterException(new
				// FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error",
				// "Message"));
				return null;
			}
			return reeducando;
		} else {
			return null;
		}
	}

}
