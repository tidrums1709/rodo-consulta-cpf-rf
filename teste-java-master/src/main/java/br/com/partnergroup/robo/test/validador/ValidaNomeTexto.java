package br.com.partnergroup.robo.test.validador;

import br.com.partnergroup.robo.test.model.Formulario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaNomeTexto implements ValidaTexto{
    @Override
    public void validarTexto(String texto, Formulario formulario) {
        Matcher matcher = Pattern.compile("Nome: (.*?) Data").matcher(texto);

        if(matcher.find()){
            String data = matcher.group();
            String dataFinal = data.replace("Nome: ", "").replace(" Data","");
            formulario.setNome(dataFinal);
        }
    }
}
