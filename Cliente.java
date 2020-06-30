import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

class Cliente extends JFrame implements ActionListener{
	JTextField campoNombre;
	JTextField campoSinNombre;
	JPanel panel;
	JButton btnEnviar;
	JLabel lblTexto;

	public Cliente(){
		panel = new JPanel();
		panel.setLayout(null);

		lblTexto=new JLabel("CLIENTE");
		lblTexto.setBounds(75,0,150,30);
		campoNombre=new JTextField(20);
		campoNombre.setBounds(10,40,225,30);
		campoSinNombre=new JTextField(20);
		campoSinNombre.setBounds(10,80,225,30);
		btnEnviar=new JButton("Enviar");
		btnEnviar.setBounds(75,100,75,30);
		btnEnviar.addActionListener(this);

		panel.add(btnEnviar);
		panel.add(campoNombre);
		panel.add(campoSinNombre);
		panel.add(lblTexto);

		this.add(panel);
		this.setBounds(600,300,275,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == this.btnEnviar){
			try {
				Socket socket = new Socket("201.130.104.179",9000); //IP del servidor
				ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
				Objeto o = new Objeto(campoNombre.getText(),campoSinNombre.getText());
				os.writeObject(o);
				os.close();
				campoNombre.setText("");
				campoSinNombre.setText("");
			}catch (Exception e) {
				System.out.println("Error en la conexion");
			}

		}
	}
}
