package TCPServer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 
import java.io.*;
import java.net.*;


/**
 *
 * @author robson
 */
class TCPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
    String clientSentence = null;
    String capitalizedSentence = null;

    //Cria objeto x, do tipo y, welcome especie de porta que fica ouvindo, á espera de um cliente q acione
    //na porta tal
    ServerSocket welcomeSocket= new ServerSocket(6789);//cria socket para requisição entrante

    while(true)
    {
    //cria um socket, 
        Socket connectionSocket = welcomeSocket.accept();//espera por requisição de conexão entrante

    BufferedReader inFromClient =
            new BufferedReader ( new InputStreamReader(connectionSocket.getInputStream()));//ler requisição

    DataOutputStream outToClient =
            new DataOutputStream(connectionSocket.getOutputStream());//escrever requisição

    clientSentence = inFromClient.readLine();

    
    capitalizedSentence =
            clientSentence.toUpperCase()+ '\n';
    outToClient.writeBytes(capitalizedSentence);
    }


    }

}
