package wslclient;
import matematica.*;

public class Main {
public static void main(String[] args) {
CalculoBasicoService cb = new CalculoBasicoService();
CalculoBasico port = cb.getCalculoBasicoPort();
System.out.println(port.soma(40, 45));
}
}