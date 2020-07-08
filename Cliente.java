import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

class Cliente extends JFrame implements ActionListener{
	JTextField campo1;
	JPanel panel;
	JButton btnInicio;
	JLabel lblTexto;

	public Cliente(){
		panel = new JPanel();
		panel.setLayout(null);

		lblTexto=new JLabel("CLIENTE");
		lblTexto.setBounds(75,0,150,30);
		campo1=new JTextField(20);
		campo1.setBounds(10,40,225,30);
		btnInicio=new JButton("Enviar");
		btnInicio.setBounds(75,100,75,30);
		btnInicio.addActionListener(this);

		panel.add(btnInicio);
		panel.add(campo1);
		panel.add(lblTexto);

		this.add(panel);
		this.setBounds(600,300,280,350);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == this.btnInicio){
			try {
				Socket misocket = new Socket("192.168.1.90",9000); //IP del servidor
				DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
				flujo_salida.writeUTF(campo1.getText());
				flujo_salida.close();
				campo1.setText("");
			}catch (Exception e) {
				System.out.println("No conecto");
			}

		}
	}
}
