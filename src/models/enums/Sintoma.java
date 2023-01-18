package models.enums;


import java.util.List;

public enum Sintoma {
    DOR_DE_BARRIGA("Dor de barriga", 1),
    DOR_DE_CABECA("Dor de cabeça", 2),
    ENXAQUECA("Enxaqueca", 3),
    AZIA("Azia", 4),
    FRATURA("Fratura", 5),
    FRAQUEZA("Fraqueza", 6),
    MEMBRO_QUEBRADO("Membro Quebrado", 7),
    OUTROS("Outros", 8);


    private final String sintoma;
    private final Integer id;
    private static final List<Sintoma> sintomaListGastro = List.of(DOR_DE_BARRIGA,AZIA);
    private static final List<Sintoma> sintomaListCirurgiao = List.of(FRATURA,MEMBRO_QUEBRADO);
    private static final List<Sintoma> sintomaListNeurologista = List.of(DOR_DE_CABECA,ENXAQUECA);
    private static final List<Sintoma> sintomaListClinicoGeral = List.of(FRAQUEZA, OUTROS);

    public static List<Sintoma> getSintomaListGastro() {
        return sintomaListGastro;
    }
    public static List<Sintoma> getSintomaListCirurgiao() {
        return sintomaListCirurgiao;
    }
    public static List<Sintoma> getSintomaListNeurologista() {
        return sintomaListNeurologista;
    }
    public static List<Sintoma> getSintomaListClinicoGeral() {
        return sintomaListClinicoGeral;
    }
    Sintoma(String sintoma, Integer id) {
        this.sintoma = sintoma;
        this.id = id;
    }
    public String getSintoma(){
        return this.sintoma;
    }
    public Integer getId(){
        return this.id;
    }
    @Override
    public String toString(){
        return this.sintoma;
    }
    public static void mostraTodosSintomas(){
        for (Sintoma sintoma : values()) {
            System.out.println(sintoma.id +" - "+ sintoma.sintoma);
        }
    }
    public static Sintoma buscaSintomaPeloId(String id) throws Exception {
        Integer index = Integer.parseInt(id);
        for (Sintoma sintoma : values()) {
            if(sintoma.getId().equals(index)) return sintoma;
        }
        throw new Exception("Não existe esse sintoma");
    }
}
