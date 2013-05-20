package controleestoqueuam;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * Rubens Guarnieri, R.A.: 20303016
 * Erik Henrique, R.A.: 20301986
 */
public class ControlaEstoqueModel {

    private ArrayList<LivroModel> livros;

    public ControlaEstoqueModel() {
        livros = new ArrayList();
    }

    //cadastra livro
    public void cadastraLivro(LivroModel e) {
        livros.add(e);
    }

    //gera o relatório de todos os livros do estoque
    public String geraRelatorio() {
        String relatorio = "";
        if (livros.isEmpty()) {
            relatorio = "Não existem livros cadastradros!";
        } else {
            for (LivroModel e : livros) {
                relatorio += "Código : " + e.getCodigo() + "\n";
                relatorio += "Nome: " + e.getTitulo() + "\n";
                relatorio += "Ano: " + e.getAnoEdicao() + "\n";
                relatorio += "Categoria: " + e.getCategoria() + "\n";
                relatorio += "Autor: " + e.getAutor() + "\n";
                relatorio += "Quantidade: " + e.getQtdEstoque() + "\n";
                relatorio += "Preço: " + e.getPreco() + "\n";
            }
        }
        return relatorio;
    }

    //gera relatório dos livros que possuem estoque minimo
    public String relatorioEstoqueMin() {
        String relatorio = "";
        if (livros.isEmpty()) {
            relatorio = "Não existem livros cadastradros!";
        } else {
            for (LivroModel e : livros) {
                if (e.getQtdEstoque() >= 10) {
                    relatorio += "Código : " + e.getCodigo() + "\n";
                    relatorio += "Nome: " + e.getTitulo() + "\n";
                    relatorio += "Ano: " + e.getAnoEdicao() + "\n";
                    relatorio += "Categoria: " + e.getCategoria() + "\n";
                    relatorio += "Autor: " + e.getAutor() + "\n";
                    relatorio += "Quantidade: " + e.getQtdEstoque() + "\n";
                    relatorio += "Preço: " + e.getPreco() + "\n";
                }
            }
        }
        return relatorio;
    }

    //dá baixa no estoque dos livros pedidos
    public void baixaPedido(LivroModel e, int quantidade) {
        LivroModel alterar = this.livros.get(this.livros.indexOf(e));
        alterar.setQtdEstoque(e.getQtdEstoque() - quantidade);
        this.livros.set(this.livros.indexOf(e), alterar);
    }

    public LivroModel buscaLivro(int cod) {
        for (LivroModel e : livros) {
            if (cod == e.getCodigo()) {
                return e;
            }
        }
        return null;
    }

    //Atualiza a quantidade em estoque do livro
    public void atualizaQuantidade(int cod, int quantidade) {
        if (verificaLivro(cod)) {
            for (LivroModel e : livros) {
                if (e.getCodigo() == cod) {
                    e.setQtdEstoque(quantidade);
                    livros.set(livros.indexOf(e), e);
                    return;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Livro não cadastrado");
        }
    }

    //Verifica se o livro existe
    public boolean verificaLivro(int cod) {
        for (LivroModel e : livros) {
            if (e.getCodigo() == cod) {
                return true;
            }
        }
        return false;
    }
}
