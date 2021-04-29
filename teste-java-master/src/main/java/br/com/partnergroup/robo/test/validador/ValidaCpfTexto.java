package br.com.partnergroup.robo.test.validador;

import br.com.partnergroup.robo.test.model.Formulario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaCpfTexto implements ValidaTexto{

    @Override
    public void validarTexto(String texto, Formulario formulario) {

        Matcher matcher = Pattern.compile("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}").matcher(texto);

        if(matcher.find()){
            formulario.setCpf(matcher.group());
        }
    }
}
