import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.lang.*;

class VentanaMenu extends JFrame implements KeyListener{

//IMAGENES
BufferedImage fotosPortada;

//OBJETOS
Portada encabezado;
JLabel 

//PANELES


//VARIABLES NECESARIAS...

	public VentanaMenu()
	{
		try
		{
			fotosPortada = ImageIO.read(new File("C:/Users/atond/Desktop/Proyecto Final/Imagenes/SpritePortada.png"));
		}catch(Exception foto)
		{
			System.out.println("Error en foto Portada");
		}
		encabezado = new Portada(3,fotosPortada);


		this.add(encabezado);				
		this.setTitle("PRACTICA 4");
		this.setBounds(20,40,1080,720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(this);




	}
	

	public void keyPressed(KeyEvent e)
	{

	}

	public void keyReleased(KeyEvent e)
	{	


	}
		

	public void keyTyped(KeyEvent e)
	{

	}


}