import java.awt.*;
import java.awt.event.*;



class mouse extends Frame implements MouseListener,MouseMotionListener{

    int x1,y1,
        x2,y2;
    int penweight;
    public mouse() {
		// TODO Auto-generated constructor stub
    	setSize(400,400);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		MenuBar mb = new MenuBar();
		
		Pensize pensize = new Pensize();
		Pencolor pencolor = new Pencolor();
		Penmodel penmodel = new Penmodel();
		Penother penother = new Penother();
				
		mb.add(pensize);
		mb.add(pencolor);
		mb.add(penmodel);
		mb.add(penother);
		
		
		setMenuBar(mb);
		setTitle("�p�e�a��");
    	addMouseListener(this);
    	addMouseMotionListener(this);
    	setVisible(true);
	}
    public void paint(Graphics g){
    	Graphics2D g2 = (Graphics2D) g.create();
    	Stroke stroke = new BasicStroke( penweight,  BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 10);
    	g2.setStroke(stroke);
    	g2.drawLine(x1, y1, x2, y2);
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x1=e.getX();//���o�ƹ����U�ɪ�X�y��(ø�ϰ_�l�IX�y��)
		y1=e.getY();//���o�ƹ����U�ɪ�Y�y��(ø�ϰ_�l�IY�y��)
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
        Graphics g = getGraphics();
		x2=e.getX();//���o�ƹ����U�ɪ�X�y��(ø�ϰ_�l�IX�y��)
		y2=e.getY();//���o�ƹ����U�ɪ�Y�y��(ø�ϰ_�l�IY�y��)
		paint(g);
		x1=x2;
		y1=y2;
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	class Pensize extends Menu implements ActionListener{
		MenuItem m1,m2,m3,x;
		public Pensize(){
			setLabel("�����j�p");
			m1 = new MenuItem("�j");
			m2 = new MenuItem("��");
			m3 = new MenuItem("�p");
			add(m1);
			add(m2);
			add(m3);
			m1.addActionListener(this);
			m2.addActionListener(this);
			m3.addActionListener(this);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			x = (MenuItem) e.getSource();
			if(x == m1)
			    penweight = 10;
			else if(x == m2) 
				penweight = 5;
			else 
				penweight = 1;
		}
	}
	class Pencolor extends Menu implements ActionListener{
		MenuItem m1,m2,m3;
		public Pencolor(){
			setLabel("�C��");
			m1 = new MenuItem("��");
			m2 = new MenuItem("��");
			m3 = new MenuItem("��");
			add(m1);
			add(m2);
			add(m3);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	}
	class Penmodel extends Menu implements ActionListener{
		MenuItem m1,m2,m3;
		public Penmodel(){
			setLabel("�ϧ�");
			m1 = new MenuItem("���");
			m2 = new MenuItem("�x��");
			m3 = new MenuItem("�T����");
			add(m1);
			add(m2);
			add(m3);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
		}
	}
	class Penother extends Menu implements ActionListener{
		MenuItem m1,m2;
		public Penother(){
			setLabel("��L");
			m1 = new MenuItem("�M���ϫ�");
			m2 = new MenuItem("�Q�t�e�k");
			add(m1);
			add(m2);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}
	}
}


public class LittlePaint{
	public static void main(String args[]){
		mouse m = new mouse();
	}
}