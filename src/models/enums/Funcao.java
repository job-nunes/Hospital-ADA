package models.enums;

public enum Funcao {
    Medico("Médico","MED"),
    Atendente("Atendente","ATEND");

    private String funcao;
    private String sigla;

    Funcao(String funcao, String sigla) {
        this.funcao = funcao;
        this.sigla = sigla;
    }

    public String getFuncao(){
        return this.funcao;
    }
    public String getSigla(){
        return this.sigla;
    }
    @Override
    public String toString(){
        return this.funcao;
    }
}
