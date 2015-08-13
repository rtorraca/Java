/*
 * Material utilizado para as aulas práticas da disciplinas da Faculdade de
 * Computação da Universidade Federal de Mato Grosso do Sul (FACOM / UFMS).
 * Seu uso é permitido para fins apenas acadêmicos, todavia mantendo a
 * referência de autoria.
 */
package Model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe Venda
 * Essa classe deve ser serializável pois será convertida em binário para
 * armazenamento em arquivo
 * @author Profª Jane Eleutério
 */
public class Venda implements Serializable {

    private Date dataHora;
    private Cliente comprador;
    private Map<Integer, Brinquedo> itens;

    /**
     * Constrói um objeto Venda que irá armazenar os dados da venda realizada.
     * Ao ser construído o objeto, é setada a data da venda como o momento da
     * criação do objeto.
     */
    public Venda() {
        this.dataHora = new Date();
        itens = new HashMap<Integer, Brinquedo>();
    }

    /**
     * Define o cliente que está realizando a compra
     * @param cliente
     */
    public void definirCliente(Cliente cliente) {
        this.comprador = cliente;
    }

    /**
     * Insere um novo brinquedo à venda
     * @param item Brinquedo vendido
     * @return verdadeiro se o brinquedo foi vendido (possui estoque) e falso caso contrário
     */
    public boolean inserirItem(Brinquedo item) {
        if (item.decrementarEstoque()) {
            this.itens.put(this.itens.size() + 1, item);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gera a nota fiscal, listando os brinquedos vendidos e preços
     * @return Texto da nota fiscal
     */
    public String gerarNota() {
        String nota = new String();
        Brinquedo b;
        nota += "Data e hora da compra: " + retornaData() + "\n";
        nota += "Cliente: " + comprador.getNome() + " - CPF: " + comprador.getCpf() + "\n\n";
        nota += "Lista de itens vendidos: \n";
        for (int i = 1; i <= itens.size(); i++) {
            b = itens.get(i);
            nota += i + " - " + b.getNome() + " - " + formataValor(b.getPreco()) + "\n";
        }

        nota += "Quantidade de itens: " + itens.size() + "\n\n";
        nota += "Valor total: " + formataValor(getTotal()) + "\n";

        return nota;
    }

    /**
     * Retorna a data e hora.
     * @return texto com a data no formato "dd/MM/yyyy HH:mm:ss"
     */
    public String retornaData() {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        return formatoData.format(this.dataHora);
    }

    /**
     * Retornar o valor total da Venda
     * @return valor total (soma dos preços dos produtos vendidos)
     */
    public double getTotal() {
        double total;
        total = 0;
        for (int i = 1; i <= itens.size(); i++) {
            total += itens.get(i).getPreco();
        }
        return total;
    }

    /**
     * Formata valores como R$xx,xx
     * @param valor
     * @return string com valor formatado
     */
    private String formataValor(double valor) {
        String svalor;
        DecimalFormat format = new DecimalFormat("R$#,##0.00");
        svalor = format.format(valor);
        return svalor;
    }

    /**
     * Retorna um texto com as informações da venda.
     * @return texto
     */
    public String imprimir() {
        return "Data: " + retornaData() + " - Cliente: " + comprador.getNome() + " - Total: " + formataValor(getTotal());
    }

    /**
     * Retorna o valor total da Venda formatado em Reais (R$XX,XX).
     * @return valor total (soma dos preços dos produtos vendidos)
     */
    public String getTotalReais() {
        return formataValor(getTotal());
    }
}
