import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.lang.*;
import java.net.*;
import java.util.Date;
import java.text.SimpleDateFormat;

class VentanaMenu extends JFrame implements ActionListener{

//IMAGENES
BufferedImage fotosPortada;
ImageIcon imagenITT = new ImageIcon("C:/Users/atond/Desktop/Proyecto_Final/Imagenes/logo carrera2.png");
ImageIcon tituloPNG = new ImageIcon("C:/Users/atond/Desktop/Proyecto_Final/Imagenes/ImagenPNGumf.png");

//OBJETOS
Portada encabezado;
JLabel titulo;
JLabel itt;
JLabel umf;
JLabel uno;
JLabel dos;
JButton agendar;
JLabel nombres; 
JTextField campoNombre;
JTextField campoNSS;

JButton masHora;
JButton menosHora;
JButton masMin;
JButton menosMin;

JLabel hh;
JLabel mm;
JLabel ampm;
JLabel puntitos;

JLabel dddd;
JLabel mmmm;
JLabel anioo;

JLabel consultorioNum;

JComboBox numeroDia;
JComboBox numeroMes;
JComboBox numeroConsultorio;

//VARIABLES NECESARIAS...
int width;
int height;
Thread hilo1; 

String [] treintayundias = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
String [] docedias = {"1","2","3","4","5","6","7","8","9","10","11","12"};
String [] capacidad = {"1","2","3","4"};

int hora = 8;
int minutos = 15;

	public VentanaMenu()
	{
		try
		{
			fotosPortada = ImageIO.read(new File("C:/Users/atond/Desktop/Proyecto_Final/Imagenes/SpritePortada.png"));
		}catch(Exception foto)
		{
			System.out.println("Error en foto Portada");
		}
		this.setSize(1080,720);


		width = this.getWidth();
        height = this.getHeight();

		encabezado = new Portada(3,fotosPortada,width);

		titulo = new JLabel("AGENDA DE CITAS");
		titulo.setBounds(20,0,180,390);
		titulo.setOpaque(false);

		itt = new JLabel(imagenITT,JLabel.CENTER);
		itt.setBounds(620,90,90,87);
		itt.setOpaque(false);

		umf = new JLabel(tituloPNG,JLabel.CENTER);
		umf.setBounds(0,0,400,100);
		umf.setOpaque(false);

		uno = new JLabel("NOMBRE:");
		uno.setBounds(120,320,60,30);
		uno.setOpaque(false);

		dos = new JLabel("NSS:");
		dos.setBounds(145,350,60,30);
		dos.setOpaque(false);

		campoNombre = new JTextField();
		campoNombre.setBounds(180,320,120,30);
		campoNombre.setOpaque(false);

		campoNSS = new JTextField();
		campoNSS.setBounds(180,350,120,30);
		campoNSS.setOpaque(false);

		agendar = new JButton("AGENDAR");
		agendar.setBounds(150,390,100,30);

		masHora = new JButton("+");
		masHora.setBounds(400,400,50,25);
		menosHora = new JButton("-");
		menosHora.setBounds(400,500,50,25);
		masMin = new JButton("+");
		masMin.setBounds(500,400,50,25);
		menosMin = new JButton("-");
		menosMin.setBounds(500,500,50,25);

		hh = new JLabel(Integer.toString(hora),JLabel.CENTER);
		hh.setFont(new Font("Serif", Font.PLAIN, 36));
		hh.setBounds(400,425,50,75);
		hh.setOpaque(true);

		mm = new JLabel(Integer.toString(minutos),JLabel.CENTER);
		mm.setFont(new Font("Serif", Font.PLAIN, 36));
		mm.setBounds(500,425,50,75);
		mm.setOpaque(true);

		puntitos = new JLabel(":",JLabel.CENTER);
		puntitos.setFont(new Font("Serif", Font.PLAIN, 36));
		puntitos.setBounds(450,425,50,75);
		puntitos.setOpaque(true);

		numeroDia = new JComboBox(treintayundias);
		numeroDia.setBounds(450,300,50,25);

		dddd = new JLabel("Dia:");
		dddd.setFont(new Font("Serif", Font.PLAIN, 24));
		dddd.setBounds(400,300,50,25);

		mmmm = new JLabel("Mes:");
		mmmm.setFont(new Font("Serif", Font.PLAIN, 24));
		mmmm.setBounds(505,300,60,25);

		numeroMes = new JComboBox(docedias);
		numeroMes.setBounds(560,300,50,25);

		anioo = new JLabel(", 2020");
		anioo.setFont(new Font("Serif", Font.PLAIN, 24));
		anioo.setBounds(615,300,100,25);

		consultorioNum = new JLabel("Consultorio No.: ");
		consultorioNum.setFont(new Font("Serif", Font.PLAIN, 24));
		consultorioNum.setBounds(400,350,175,25);

		numeroConsultorio = new JComboBox(capacidad);
		numeroConsultorio.setBounds(575,350,50,25);

		encabezado.add(masHora);
		encabezado.add(menosHora);
		encabezado.add(masMin);
		encabezado.add(menosMin);
		encabezado.add(hh);
		encabezado.add(mm);
		encabezado.add(puntitos);
		encabezado.add(numeroDia);
		encabezado.add(dddd);
		encabezado.add(mmmm);
		encabezado.add(numeroMes);
		encabezado.add(anioo);
		encabezado.add(consultorioNum);
		encabezado.add(numeroConsultorio);

		nombres = new JLabel("Creado por Atondo Gastelum y Lorenzana Belli.");
		nombres.setBounds(10,645,1080,30);
		nombres.setOpaque(false);

		encabezado.add(itt);
		encabezado.add(titulo);

		encabezado.add(nombres);
		encabezado.add(umf);
		encabezado.add(uno);
		encabezado.add(dos);
		encabezado.add(campoNSS);
		encabezado.add(campoNombre);
		encabezado.add(agendar);
		

		encabezado.setLayout(null);

		titulo.putClientProperty("JComponent.sizeVariant","large");

		this.add(encabezado);

		SwingUtilities.updateComponentTreeUI(this);	
		this.pack();
		this.setTitle("CREA TU CITA");
		this.setBounds(20,40,760,720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);		

		masHora.addActionListener(this);
		menosHora.addActionListener(this);
		menosMin.addActionListener(this);
		masMin.addActionListener(this);
		agendar.addActionListener(this);
	}

public void actionPerformed(ActionEvent event){
		
		if(event.getSource() == this.masHora)
		{
			hora = hora + 1 ;
			hh.setText(Integer.toString(hora));
			
			if (hora == 20)
			{
				hora = 8;
				hh.setText(Integer.toString(hora));
			}
			
		}

		else if(event.getSource() == this.menosHora)
		{
			hora = hora - 1 ;
			hh.setText(Integer.toString(hora));
			
			if (hora == 7)
			{
				hora = 19;
				hh.setText(Integer.toString(hora));
			} 

		}	

		else if(event.getSource() == this.masMin)
		{
			minutos = minutos + 15 ;
			mm.setText(Integer.toString(minutos));
			
			if (minutos == 60)
			{
			minutos = 00;
			mm.setText(Integer.toString(minutos));
			}

		}

		else if(event.getSource() == this.menosMin)
		{
			minutos = minutos - 15 ;
			mm.setText(Integer.toString(minutos));
			
			if (minutos == -15)
			{
			minutos = 45;
			mm.setText(Integer.toString(minutos));
			}

		}

		else if(event.getSource() == this.agendar){

			String cita = Fecha.agendarFecha(String.valueOf(numeroDia.getSelectedItem()),String.valueOf(numeroMes.getSelectedItem()),hh.getText(),mm.getText());
			try {
				Socket socket = new Socket("201.130.104.179",9000); //IP del servidor
				ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
				Objeto o = new Objeto(campoNombre.getText()+" "+campoNSS.getText(),cita + "\nConsultorio: "+String.valueOf(numeroConsultorio.getSelectedItem()));
				os.writeObject(o);
				os.close();
				campoNombre.setText("");
				campoNSS.setText("");



			}catch (Exception e) {
				System.out.println("Error en la conexion");
			}

		}
	}


}