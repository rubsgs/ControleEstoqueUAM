package controleestoqueuam;

/**
 *
 * Rubens Guarnieri, R.A.: 20303016
 * Erik Henrique, R.A.: 20301986
 */
public class LivroModel {
    private int codigo;
    private String titulo;
    private String autor;
    private String categoria;
    private int anoEdicao;
    private double preco;
    private int qtdEstoque;
    
    public LivroModel(int cod, String titulo, String autor, String categoria, int ano,
        double preco, int quantidade) {
        this.codigo = cod;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.anoEdicao = ano;
        this.preco = preco;
        this.qtdEstoque = quantidade;
    }

    /* Get's e Set's */
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getAnoEdicao() {
        return anoEdicao;
    }

    public void setAnoEdicao(int anoEdicao) {
        this.anoEdicao = anoEdicao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
    
}
