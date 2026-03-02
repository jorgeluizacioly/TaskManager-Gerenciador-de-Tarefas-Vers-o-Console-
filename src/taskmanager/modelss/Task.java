package taskmanager.modelss;

public class Task {
    
    private int id;
    private String nome;
    private String descricao;
    private boolean concluida;

    public Task(int id, String nome, String descricao, boolean concluida) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.concluida = false;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public boolean isConcluida() {
        return concluida;
    }


    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }


    
}