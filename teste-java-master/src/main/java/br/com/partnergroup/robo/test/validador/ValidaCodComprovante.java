package br.com.partnergroup.robo.test.validador;

import br.com.partnergroup.robo.test.model.Formulario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaCodComprovante implements ValidaTexto{
    @Override
    public void validarTexto(String texto, Formulario formulario) {

        Matcher matcher = Pattern.compile("[A-Z0-9]{4}+\\.[A-Z0-9]{4}+\\.[A-Z0-9]{4}+\\.[A-Z0-9]{4}").matcher(texto);

        if(matcher.find()){
            formulario.setCodComprovante(matcher.group());
        }

    }
}
