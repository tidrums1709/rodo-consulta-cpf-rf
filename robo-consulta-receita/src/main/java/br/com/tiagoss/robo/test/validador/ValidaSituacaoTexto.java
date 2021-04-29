package br.com.tiagoss.robo.test.validador;

import br.com.tiagoss.robo.test.model.Formulario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaSituacaoTexto implements ValidaTexto {
    @Override
    public void validarTexto(String texto, Formulario formulario) {
        Matcher matcher = Pattern.compile("Situação Cadastral: [A-Z]{1,}").matcher(texto);

        if(matcher.find()){
            String data = matcher.group();
            String dataFinal = data.replace("Situação Cadastral: ", "");
            formulario.setSituacao(dataFinal);
        }
    }
}
