package controleestoqueuam;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * Rubens Guarnieri, R.A.: 20303016
 * Erik Henrique, R.A.: 20301986
 */
public class PedidoModel {

    private ArrayList<LivroModel> livros;
    //as quantidades serão armazanadas no mesmo indice dos livros
    private ArrayList<Integer> qtdLivros;
    private double valor;

    public PedidoModel() {
        livros = new ArrayList();
        qtdLivros = new ArrayList();
    }

    //adiciona livros e as suas quantidades no pedido se o estoque permitir
    public Boolean adicionaLivro(LivroModel la, int quantidade) {
        if (livros.isEmpty()) {
            if ((la.getQtdEstoque() - quantidade) >= 10) {
                livros.add(la);
                qtdLivros.add(quantidade);
                JOptionPane.showMessageDialog(null, "Livro adicionado com Sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Livro com quantidade insuficiente");
            }
        } else {
            for (LivroModel e : livros) {
                if (e.getCodigo() == la.getCodigo()) {
                    qtdLivros.set(livros.indexOf(e), quantidade + qtdLivros.get(livros.indexOf(e)));
                    JOptionPane.showMessageDialog(null, "Livro já adicionado, somando a quantidade...");
                    return true;
                }
            }
            if ((la.getQtdEstoque() - quantidade) >= 10) {
                livros.add(la);
                qtdLivros.add(quantidade);
                JOptionPane.showMessageDialog(null, "Livro adicionado com Sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Livro com quantidade insuficiente");
            }
        }
        return false;
    }

    //retorna o valor total de cada livro e o total do pedido
    public String fecharConta() {
        String resultado = "";
        double preco = 0;
        for (LivroModel e : livros) {
            resultado += "Total do livro " + e.getCodigo()
                    + " " + e.getTitulo() + ": "
                    + e.getPreco() * qtdLivros.get(livros.indexOf(e)) + "\n";
            preco += e.getPreco() * qtdLivros.get(livros.indexOf(e));
        }
        resultado += "Total geral: " + preco;
        this.valor = preco;
        return resultado;
    }

    //retornar valor
    public double getValor() {
        return this.valor;
    }

    //retorna o ArrayList dos livros pedidos
    public ArrayList<LivroModel> getLivros() {
        return livros;
    }

    //retornar o ArrayList das quantidades dos livros no pedido
    public ArrayList<Integer> getQtdLivros() {
        return qtdLivros;
    }

    public void setQtdLivros(ArrayList<Integer> qtdLivros) {
        this.qtdLivros = qtdLivros;
    }
}