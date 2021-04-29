package br.com.tiagoss.robo.test.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teste {
    public static void main(String[] args) {
        String teste = "7FC9.51B3.0C99.63C3";
        if( teste.matches("[A-Z0-9]{4}+\\.[A-Z0-9]{4}+\\.[A-Z0-9]{4}+\\.[A-Z0-9]{4}")){
            System.out.println("deu certo");
        }
        String texto = "Ministério da Fazenda Secretaria da Receita Federal do Brasil Comprovante de Situação Cadastral no CPF No do CPF: 326.132.988-20 Nome: TIAGO SOARES DA SILVA Data de Nascimento: 17/09/1984 Situação Cadastral: REGULAR Data da Inscrição: 31/01/2002 Digito Verificador: 00  Comprovante emitido às: 09:32:56 do dia 29/04/2021 (hora e data de Brasília). Código de controle do comprovante: AA4D.3FB7.7AEE.2152 Este documento não substitui o \u0093Comprovante de Inscrição no CPF\u0094. (Modelo aprovado pela IN/RFB no 1.548, de 13/02/2015.)  Nova Consulta";
        Matcher matcher = Pattern.compile("[A-Z0-9]{4}+\\.[A-Z0-9]{4}+\\.[A-Z0-9]{4}+\\.[A-Z0-9]{4}").matcher(texto);

        if(matcher.find()){
            String group = matcher.group();
            System.out.println(group);
        }
    }
}
