package br.com.tiagoss.robo.test.model;

import lombok.Data;

@Data
public class Formulario {
    
    private String codComprovante;
    private String cpf;
    private String dataInscricao;
    private String dataNascimento;
    private String nome;
    private String situacao;

    @Override
    public String toString() {
        return "Formulario{" +
                "codComprovante='" + codComprovante + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataInscricao='" + dataInscricao + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", nome='" + nome + '\'' +
                ", situacao='" + situacao + '\'' +
                '}';
    }
}
