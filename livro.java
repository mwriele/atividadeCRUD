package classes;

public class Produto{
    private int id, quantidade;
    private String nome;
    private double preco;

    public Produto(int id, String nome, int quantidade, double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public double getPreco(){
        return preco;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }   

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }  
    
    @Override
    public String toString() {
        return "Produto [ID =" + id + ", Nome =" + nome + ", Preço =" + preco + " Quantidade = " + quantidade + "]";
    }
}

