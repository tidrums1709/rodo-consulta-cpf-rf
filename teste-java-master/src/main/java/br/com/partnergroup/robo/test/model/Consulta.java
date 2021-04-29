package br.com.partnergroup.robo.test.model;

import br.com.partnergroup.robo.test.model.TipoConsulta;

public class Consulta {

    private boolean OuviuCaptha;
    private String cpf;
    private String dataNascimento;
    private String captha;
    private TipoConsulta tipoConsulta;

    public Consulta(boolean ouviuCaptha, String cpf, String dataNascimento, String captha, TipoConsulta tipoConsulta) {
        OuviuCaptha = ouviuCaptha;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.captha = captha;
        this.tipoConsulta = tipoConsulta;
    }

    public boolean isOuviuCaptha() {
        return OuviuCaptha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getCaptha() {
        return captha;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }
}
