package com.mycompany.enade.converter;

import com.mycompany.enade.model.Questao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter("questaoConverter")
@Named
public class questaoConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof Questao) {
            Questao obj = (Questao) value;
            if (obj != null) {
                uic.getAttributes().put(obj.getIdQuestao().toString(), obj);
                return obj.getIdQuestao().toString();
            }
            return "";
        }
        return "";
    }
}
