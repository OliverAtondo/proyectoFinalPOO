import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;

class Servidor extends JFrame implements Runnable{
  JLabel lblNombre;
  JLabel lblNSS;
  JPanel panel;
  Thread hilo1;

  public Servidor(){
    panel= new JPanel();
		panel.setLayout(null);
		lblNombre = new JLabel("");
    lblNombre.setBounds(0,0,150,30);
    lblNSS = new JLabel("");
    lblNSS.setBounds(0,40,150,30);
    panel.add(lblNombre);panel.add(lblNSS);

    hilo1 = new Thread(this);
    hilo1.start();


		this.add(panel);
    this.setBounds(1200,300,280,350);
		this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
  public void run(){
    //System.out.println("Estoy a la escucha");
    try {
      ServerSocket server = new ServerSocket(9000); //Socket del servidor
      while(true){
        Socket socket = server.accept(); //Socket del Cliente
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        Objeto o = (Objeto)is.readObject();
        lblNombre.setText(o.nombre);
        lblNSS.setText(o.nss);
        socket.close();
      }
    }catch (Exception e) {
      e.printStackTrace();
    }

  }
}
