package TCPClient;

import java.io.*;
import java.net.*;

/**
 *
 * @author robson
 */
class TCPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
    String sentence;//cadeia digitada pelo usuario e enviada ao server
    String modifiedSentence;//cadeia obtida do servidor e enviada para saida padrao do usuario

    //Cria o objeto de cadeia x do tipo y, iniciando com System.in, que vincula a cadeia com a entrada
    BufferedReader inFromUser = new BufferedReader ( new InputStreamReader(System.in));

    //cria objeto x, d o tipo y. Ativa a conexao em TCP cli e serv, antes ao inicio, consulta DNS do nome; 
    //port cli = port serv; Processo TCP identif, ip e porta aplicação
    Socket clientSocket = new Socket("localhost",6789);

    //Criam objetos de cadeia ligados ao socket

    //cadeia out fornece a saida do processo para o socket;
    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
    
    //cadeia in, fornece ao processo a entrada do socket;
    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

    //digitado pelo usuario na cadeia sentence, junta caracteres até o carriage return,
    //da entrada padrao para a cadeia sentence
    sentence = inFromUser.readLine();

    //sentence para out com o carriage return, cli espera para receber carcter do serv
    outToServer.writeBytes(sentence+'\n');

    //chegando do serv, fluem atraves da cadeia in e colocados na modifi, acumulando at carriage
    modifiedSentence = inFromServer.readLine();

    //envia para o monitor a cadeia modifi retornada do servidor
    System.out.println("From SERVER:" +modifiedSentence);

    //fecha o socket e a conexao tcp entre cle e serv
    clientSocket.close();


    }

}
