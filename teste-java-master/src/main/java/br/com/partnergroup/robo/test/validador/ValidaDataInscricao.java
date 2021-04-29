package br.com.partnergroup.robo.test.validador;

import br.com.partnergroup.robo.test.model.Formulario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaDataInscricao implements ValidaTexto{
    @Override
    public void validarTexto(String texto, Formulario formulario) {

        Matcher matcher = Pattern.compile("Data da Inscrição: [0-9]{2}\\/[0-9]{2}\\/[0-9]{4}").matcher(texto);

        if(matcher.find()){
            String data = matcher.group();
            String dataFinal = data.replace("Data da Inscrição: ", "");
            formulario.setDataInscricao(dataFinal);
        }
    }
}
