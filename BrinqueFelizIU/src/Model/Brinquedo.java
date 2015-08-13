/*
 * Material utilizado para as aulas práticas da disciplinas da Faculdade de
 * Computação da Universidade Federal de Mato Grosso do Sul (FACOM / UFMS).
 * Seu uso é permitido para fins apenas acadêmicos, todavia mantendo a
 * referência de autoria.
 */
package Model;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * Classe Brinquedo.
 * Essa classe deve ser serializável pois será convertida em binário para
 * armazenamento em arquivo
 * @author Profª Jane Eleutério
 */
public class Brinquedo implements Serializable {

    private String codBarras;
    private String nome;
    private String faixaEtaria;
    private int qtdeEstoque;
    private double preco;

    /**
     * Constrói um objeto Brinquedo que representa os valores especificados.
     * @param codBarras código de barras
     * @param nome nome / título do brinquedo
     * @param faixaEtaria faixa etária a qual se aplica, por exemplo, 3-7 anos
     * @param qtdeEstoque quantidade disponível em estoque
     * @param preco preço para venda
     */
    public Brinquedo(String codBarras, String nome, String faixaEtaria, int qtdeEstoque, double preco) {
        this.codBarras = codBarras;
        this.nome = nome;
        this.faixaEtaria = faixaEtaria;
        this.qtdeEstoque = qtdeEstoque;
        this.preco = preco;
    }

    /**
     * Define o preço do brinquedo
     * @param preco preço de venda
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Decrementa o estoque do brinquedo
     * @return falso caso não possua estoque e verdadeiro caso contrário
     */
    public boolean decrementarEstoque() {
        if (qtdeEstoque > 0) {
            this.qtdeEstoque--;
            return true;
        } else {
            return false;
        }

    }

    /**
     * Retorna o código de barras.
     * @return código de barras
     */
    public String getCodBarras() {
        return codBarras;
    }

    /**
     * Retorna a faixa etária.
     * @return faixa etária
     */
    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    /**
     * Retorna o nome / título do brinquedo.
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o preço de venda do brinquedo.
     * @return preço (em double)
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Retorna o preço de venda do brinquedo formatado em Reais (R$XX,XX).
     * @return preço (em Reais)
     */
    public String getPrecoReais() {
        String svalor;
        DecimalFormat format = new DecimalFormat("R$#,##0.00");
        svalor = format.format(preco);
        return svalor;
    }

    /**
     * Retorna a quantidade de exemplares em estoque.
     * @return estoque
     */
    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    /**
     * Retorna um texto com as informações do brinquedo.
     * @return texto
     */
    public String imprimir() {
        return "CodBarras: " + codBarras + " / Nome: " + nome + " / Faixa etária: "
                + faixaEtaria + " / Preço: " + getPrecoReais() + " / Estoque: " + qtdeEstoque;
    }
}
