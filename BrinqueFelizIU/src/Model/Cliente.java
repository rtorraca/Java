/*
 * Material utilizado para as aulas práticas da disciplinas da Faculdade de
 * Computação da Universidade Federal de Mato Grosso do Sul (FACOM / UFMS).
 * Seu uso é permitido para fins apenas acadêmicos, todavia mantendo a
 * referência de autoria.
 */
package Model;

import java.io.Serializable;

/**
 * Classe Cliente.
 * Essa classe deve ser serializável pois será convertida em binário para
 * armazenamento em arquivo
 * @author Profª Jane Eleutério
 */
public class Cliente implements Serializable {

    private String nome;
    private String cpf;
    private String rg;
    private String endereco;

    /**
     * Constrói um objeto Cliente que representa os valores especificados.
     * @param nome nome completo do cliente
     * @param cpf CPF do cliente
     */
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    /**
     * Define o endereço do cliente
     * @param endereco endereço completo
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Define o RG do cliente
     * @param rg RG (documento de identidade)
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * Retorna o CPF .
     * @return CPF do cliente
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Retorna o nome do cliente.
     * @return nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o endereço do cliente.
     * @return endereço do cliente
     */
    public String getEndereco() {
        if (endereco == null) {
            return "-";
        } else {
            return endereco;
        }
    }

    /**
     * Retorna o RG.
     * @return RG do cliente
     */
    public String getRg() {
        if (rg == null) {
            return "-";
        } else {
            return rg;
        }
    }

    /**
     * Retorna um texto com as informações do cliente.
     * @return texto
     */
    public String imprimir() {
        return "CPF: " + getCpf() + " / Nome: " + getNome() + " / RG: " + getRg() + " / Endereço: " + getEndereco();
    }
}
