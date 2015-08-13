/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ws1client;
import matematica.*;

public class Main {
public static void main(String[] args) {
CalculoBasicoService cb = new CalculoBasicoService();
CalculoBasico port = cb.getCalculoBasicoPort();
System.out.println(port.soma(30, 45));
System.out.println(port.multi(3, 12));
System.out.println(port.divid(30, 6));

}
}