package explorando_marte;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Janela extends JFrame{
	
	Planalto planalto;

	public Janela(Planalto planalto){
		this.planalto = planalto;
		setTitle("Planalto de Dimensões X : "+planalto.getLatitudeX()+" Y : "+planalto.getLongitudeY());
		setSize((planalto.getLatitudeX()*50+82),(planalto.getLongitudeY()*50+100));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setForeground(new Color(0, 128, 0));
		setAlwaysOnTop(true);
	}
	
	public void paint(Graphics g) {
		int x = 25;
		int y = 25;
		
		//Coluna Y
			for(int i = 0; i<=(planalto.getLatitudeX()+1);i++) {
				g.drawLine(x,25,x, (planalto.getLongitudeY()*60+50));
					g.drawString(""+(i-1)+"", x-30, (planalto.getLongitudeY()*50+90));
				x += 50;
			}
		
		//Linha X
			for(int i = 0; i<= (planalto.getLongitudeY()+1);i++) {
				g.drawLine(0,y,(planalto.getLatitudeX()*60+50), y);
					g.drawString(""+((i-planalto.getLongitudeY()-1)*-1), 10, y-20);
				y += 50;
			}
		
		//insersão das sondas
			for(Sonda i : planalto.sondas) {
				int lx;
				int ly = (planalto.getLongitudeY()+1)*50-(i.posicao.getLongitudeY()*50);
				
				if(i.posicao.getLatitudeX() == 0) {
					lx = 50;
				}
				else {
					lx = i.posicao.getLatitudeX()*50+50;
				}
				g.drawString(i.pontosCardeais.toString(), (lx-20), ly);
				g.drawString(i.getNome(), (lx-20), (ly-10));
			}
		
	}
	
}

