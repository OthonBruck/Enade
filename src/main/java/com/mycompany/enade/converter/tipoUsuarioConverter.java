package com.mycompany.enade.converter;

import com.mycompany.enade.model.TipoUsuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter("tipoUsuarioConverter")
@Named
public class tipoUsuarioConverter implements Converter{
     @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof TipoUsuario) {
            TipoUsuario obj = (TipoUsuario) value;
            if (obj != null) {
                uic.getAttributes().put(obj.getIdTipoUsuario().toString(), obj);
                return obj.getIdTipoUsuario().toString();
            }
            return "";
        }
        return "";
    }
}
