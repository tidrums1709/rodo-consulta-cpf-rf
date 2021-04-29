package br.com.tiagoss.robo.test.validador;

import br.com.tiagoss.robo.test.model.Formulario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaDataNascimento implements ValidaTexto {
    @Override
    public void validarTexto(String texto, Formulario formulario) {

        Matcher matcher = Pattern.compile("Data de Nascimento: [0-9]{2}\\/[0-9]{2}\\/[0-9]{4}").matcher(texto);

        if(matcher.find()){
            String data = matcher.group();
            String dataFinal = data.replace("Data de Nascimento: ", "");
            formulario.setDataNascimento(dataFinal);
        }
    }
}

