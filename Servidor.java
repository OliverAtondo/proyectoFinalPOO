import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;

class Servidor extends JFrame implements Runnable{
  JTextArea areatexto;
  Thread hilo1;

  public Servidor(){
    JPanel milamina= new JPanel();
		milamina.setLayout(new BorderLayout());
		areatexto=new JTextArea();
		milamina.add(areatexto,BorderLayout.CENTER);
    hilo1 = new Thread(this);
    hilo1.start();


		this.add(milamina);
    this.setBounds(1200,300,280,350);
		this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
  public void run(){
    //System.out.println("Estoy a la escucha");
    try {
      ServerSocket servidor = new ServerSocket(9000);
      while(true){
        Socket socket = servidor.accept();
        DataInputStream flujo_entrada = new DataInputStream(socket.getInputStream());
        String mensaje_texto = flujo_entrada.readUTF();
        areatexto.append("\n"+mensaje_texto);
        socket.close();
      }
    }catch (Exception e) {
      e.printStackTrace();
    }

  }
}
