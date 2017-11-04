package dibuja;


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dibuja {
	
	public static void main( String[] args ){
		JFrame frame = new JFrame( "José Carlos Flores Morán" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		MiPanel panel = new MiPanel();
		frame.add( panel );
		
		frame.setSize( 626, 626 );		
 
		frame.setLocationRelativeTo(null);
		frame.setVisible( true );
		frame.setResizable(false);
		
	}
	
}

class MiPanel extends JPanel{

        @Override
	public void paintComponent (Graphics g){
		
		 super.paintComponent(g);
		 
		 Graphics2D g2d = (Graphics2D) g;
		 
		 //Cielo
		 Color azulbase = new Color(118, 199, 255);
		 Color azulclaro = new Color(255,255,255,60);
                 Color azulito = new Color(170, 240, 240);
                 g2d.setPaint(azulito);
                 g2d.fillRect(0, 0, getWidth(), getHeight());
		 GradientPaint verticalGradient = new GradientPaint(500, 0, azulbase, 500, 300, azulclaro);
		 g2d.setPaint(verticalGradient);
		 g2d.fillRect(0, 0, getWidth(), 360);

		 //Sol
		 g2d.setPaint(azulclaro);
		 g2d.fillOval(1, -40, 90, 90);
		 
		 //Resplandor del sol
		 int pasos = 4;
		 int logitud = (120 / pasos);
		 g2d.setPaint(new Color(255,255,255,25));
		 for (int i = 0; i < logitud; i++) {
		     g.fillOval(50 - i * pasos, -16 - i * pasos, i * pasos * 2, i * pasos * 2);
		 }
                 
                 //Pared de fondo
		 Color pared_base = new Color(245,100,28);
		 Color pared_base_sombra = new Color(200,180,164);
		 GradientPaint color_pared_base = new GradientPaint(500, 360, pared_base, 500, 560, pared_base_sombra);
		 g2d.setPaint(color_pared_base);
		 g2d.fillRect(50, 382, 526 , 180);
		 //Pared largo: 1419
		 //Pared ancho: 190
		 
		 //Ladrillos de pared
		 Color ladrillo_pared_1 = new Color(225,98,8);
		 Color ladrillo_pared_2 = new Color(255,120,48);
		 Color ladrillo_pared_3 = new Color(245,90,38);
		 
		 int ancho_ladrillo = (210 / 17);
		 int separacion_horizontal = 4;
		 int contador = 1;
		
		 //Añade tablas a la pared
		 for(int i = 0; i < 26; i++) {
			 
			 for (int j = 0; j < 16; j++) {
				
				int posicion_ladrillo_ancho = (210 / 17)*j;
				
                             switch (contador) {
                                 case 1:
                                     g2d.setPaint(ladrillo_pared_1);
                                     contador = 2;
                                     break;
                                 case 2:
                                     g2d.setPaint(ladrillo_pared_2);
                                     contador = 3;
                                     break;
                                 case 3:
                                     g2d.setPaint(ladrillo_pared_3);
                                     contador = 1;
                                     break;
                                 default:
                                     break;
                             }
				
				
				
				
				g2d.fillRect(50, 382 + posicion_ladrillo_ancho + separacion_horizontal, 526, ancho_ladrillo-2);
                                //g2d.fillRect(240, 382 + posicion_ladrillo_ancho + separacion_horizontal, 146, ancho_ladrillo-2);
				
			}
			 
		 }
                 
                 //Separacion del techo
                 Color separacion = new Color(251, 148, 53);
                 g2d.setPaint(separacion);
                 g2d.fillRect(45, 390, 536, 15);
                 
                 //Techo base del edificio 
                 int x[]={30,100,526,596};
                 int y[]={396,345,345,396};
                 Color techo = new Color(114, 102, 88);
                 g.setColor(techo);
                 g.fillPolygon(x,y,4);
                 
		 //Base del edificio 
                 Color base = new Color(185,190,193);
                 Color base_blanca = new Color(242, 223, 224);
                 g2d.setPaint(base);
                 g2d.fillRect(40, 550, 546, 300 );
                 g2d.setPaint(base_blanca);
                 g2d.fillRect(40, 550, 546, 5);
                 
                 //Sombra del cuadro frontal
                 Color sombra_cuadro = new Color(0, 0, 0, 80);
                 g2d.setPaint(sombra_cuadro);
                 g2d.fillRect(230, 405, 166, 145);
		 
		 //Banqueta
		 Color gris_calle = new Color(167,168,170);
		 Color gris_calle_sombra = new Color(146,147,149);
		 g2d.setPaint(gris_calle);
		 g2d.fillRect(0, 580, getWidth(), 220);
                 
                 //Calle negra
                 g2d.setPaint(gris_calle_sombra);
                 g2d.fillRect(0, 595, getWidth(), 220);
                
		 
		 
        }
}
