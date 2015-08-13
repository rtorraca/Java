/*
 * Material utilizado para as aulas práticas da disciplinas da Faculdade de
 * Computação da Universidade Federal de Mato Grosso do Sul (FACOM / UFMS).
 * Seu uso é permitido para fins apenas acadêmicos, todavia mantendo a
 * referência de autoria.
 */
package Controller;

import Model.Cliente;
import Model.Brinquedo;
import Model.Venda;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe ControladoraBrinqueFeliz.
 * Essa classe tem a função de controlar todo o fluxo de dados da aplicação, e
 * irá possuir um catálogo para cada classe de objetos usados na aplicação.
 * São eles: catálogo de vendas, catálogo de binquedos e catálogo de clientes.
 * Isso é necessário devido ao fato da persistência dos dados ser realizada
 * através de manipulação de arquivos binários. Obs: Essa aplicação substitui
 * o conceito de banco de dados por arquivos binários.
 * @author Profª Jane Eleutério
 */
public class ControladoraBrinqueFeliz {

    private List<Brinquedo> catalogoBrinquedos;
    private List<Cliente> catalogoClientes;
    private List<Venda> catalogoVendas;

    /**
     * Constrói um objeto ControladoraBrinqueFeliz.
     */
    public ControladoraBrinqueFeliz() {
        catalogoBrinquedos = new ArrayList<Brinquedo>();
        catalogoClientes = new ArrayList<Cliente>();
        catalogoVendas = new ArrayList<Venda>();
        carregarDados();
    }

    /**
     * Salva o brinquedo passado como argumento, ou seja, inclui o objeto
     * no catálogo para ser persistido.
     * @param novoBrinquedo
     * @return true se obteve sucesso no salvamento e false caso contrário
     */
    public boolean salvarBrinquedo(Brinquedo novoBrinquedo) {
        if (buscarBrinquedoCodBarras(novoBrinquedo.getCodBarras()) == null) {
            System.out.println("Salvando o Brinquedo...");
            catalogoBrinquedos.add(novoBrinquedo);
            gravaArquivoBrinquedo();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Busca um brinquedo através do código de barras
     * @param cod código de barras
     * @return o objeto brinquedo se a busca obteve sucesso, ou null em caso contrário
     */
    public Brinquedo buscarBrinquedoCodBarras(String cod) {
        Brinquedo b = null;
        boolean achou = false;
        Iterator iteB = catalogoBrinquedos.iterator();
        cod = retiraPontuacao(cod);
        while (iteB.hasNext() & !achou) {
            b = (Brinquedo) iteB.next();
            if (retiraPontuacao(b.getCodBarras()).equals(cod)) {
                achou = true;
            }
        }
        if (achou) {
            return b;
        } else {
            return null;
        }
    }

    /**
     * Salva o cliente passado como argumento, ou seja, inclui o objeto
     * no catálogo para ser persistido.
     * @param novoCliente
     * @return true se obteve sucesso no salvamento e false caso contrário
     */
    public boolean salvarCliente(Cliente novoCliente) {
        if (buscarClienteCpf(novoCliente.getCpf()) == null) {
            System.out.println("Salvando o cliente...");
            catalogoClientes.add(novoCliente);
            gravaArquivoCliente();

            return true;
        } else {
            return false;
        }
    }

    /**
     * Busca um cliente através do CPF
     * @param cpf CPF do cliente a ser procurado
     * @return o objeto cliente se a busca obteve sucesso, ou null em caso contrário
     */
    public Cliente buscarClienteCpf(String cpf) {
        Cliente c = null;
        boolean achou = false;
        Iterator iteCli = catalogoClientes.iterator();
        cpf = retiraPontuacao(cpf);

        while (iteCli.hasNext() & !achou) {
            c = (Cliente) iteCli.next();
            if (retiraPontuacao(c.getCpf()).equals(cpf)) {
                achou = true;
            }
        }
        if (achou) {
            return c;
        } else {
            return null;
        }
    }

    /**
     * Salva a venda passada como argumento, ou seja, inclui o objeto
     * no catálogo para ser persistido.
     * @param novaVenda
     */
    public void salvarVenda(Venda novaVenda) {
        System.out.println("Salvando os dados da venda...");
        catalogoVendas.add(novaVenda);
        gravaArquivoVenda();

    }

    /**
     * Retorna um texto com o relatório de clientes, brinquedos e vendas
     * registrados no sistema.
     * @return texto como relatório
     */
    public String geraRelatorio() {
        String relatorio = new String();
        Iterator ite;

        relatorio += "\tRelatório de Clientes\n";
        if (catalogoClientes.isEmpty()) {
            relatorio += " - - não há clientes cadastrados - - ";
        } else {
            ite = catalogoClientes.iterator();
            while (ite.hasNext()) {
                relatorio += ((Cliente) ite.next()).imprimir() + "\n";
            }
        }
        relatorio += "\n\tRelatório de Brinquedos\n";
        if (catalogoBrinquedos.isEmpty()) {
            relatorio += " - - não há brinquedos cadastrados - - ";
        } else {
            ite = catalogoBrinquedos.iterator();
            while (ite.hasNext()) {
                relatorio += ((Brinquedo) ite.next()).imprimir() + "\n";
            }
        }
        relatorio += "\n\tRelatório de Vendas\n";
        if (catalogoVendas.isEmpty()) {
            relatorio += " - - não há vendas registradas - - ";
        } else {
            ite = catalogoVendas.iterator();
            while (ite.hasNext()) {
                relatorio += ((Venda) ite.next()).imprimir() + "\n";
            }
        }
        return relatorio;
    }

    private String retiraPontuacao(String texto) {
        texto = texto.replace(".", "");
        texto = texto.replace("-", "");
        texto = texto.replace("/", "");
        texto = texto.replace("*", "");
        return texto;
    }

    private void carregarDados() {

        leArquivoCliente();
        leArquivoVenda();
        leArquivoBrinquedo();
    }

    private void gravaArquivoCliente() {
        try {
            // Serialize to a file
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("cliente.ser"));
            out.writeObject(catalogoClientes);
            out.close();
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    private void gravaArquivoVenda() {
        try {
            // Serialize to a file
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("venda.ser"));
            out.writeObject(catalogoVendas);
            out.close();
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    private void gravaArquivoBrinquedo() {
        try {
            // Serialize to a file
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("brinquedo.ser"));
            out.writeObject(catalogoBrinquedos);
            out.close();
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    private void leArquivoCliente() {
        try {
            // Deserialize from a file
            File file = new File("cliente.ser");
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            // Deserialize the object
            catalogoClientes = (List<Cliente>) in.readObject();
            in.close();

        } catch (ClassNotFoundException e) {
            e.fillInStackTrace();
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    private void leArquivoVenda() {
        try {
            // Deserialize from a file
            File file = new File("venda.ser");
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            // Deserialize the object
            catalogoVendas = (List<Venda>) in.readObject();
            in.close();

        } catch (ClassNotFoundException e) {
            e.fillInStackTrace();
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    private void leArquivoBrinquedo() {
        try {
            // Deserialize from a file
            File file = new File("brinquedo.ser");
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            // Deserialize the object
            catalogoBrinquedos = (List<Brinquedo>) in.readObject();
            in.close();

        } catch (ClassNotFoundException e) {
            System.out.println(e.fillInStackTrace());
        } catch (IOException e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
