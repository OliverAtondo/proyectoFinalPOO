import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;

class Portada extends JPanel implements Runnable{

	BufferedImage imagen;
	int numeroImagenes;
	int actual;
	int x;

	public Portada(int numeroImagenes, BufferedImage imagen,int x)
	{
		this.setOpaque(false);
		this.numeroImagenes = numeroImagenes;
		this.imagen = imagen;
		this.x = x;
	}

	@Override
	public void run()
	{
		while(true)
		{
			for (int i=0;i<numeroImagenes-1;i++) {
				i = actual;
				this.repaint();
				if (i == 3)
				{
					i = 0;
				}
				retardo(3000);
			}		
		}

	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(imagen.getSubimage(1080*(actual),0,1080,720),0,0,x,180,null);
	}

	public void retardo(int ms)
	{
		try
		{
			Thread.sleep(ms);
		}catch(Exception e){
			System.out.println("Error: al ejecuar el sleep.");
		}

	}

}