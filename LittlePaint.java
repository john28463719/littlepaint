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
		setTitle("小畫家阿");
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
		x1=e.getX();//取得滑鼠按下時的X座標(繪圖起始點X座標)
		y1=e.getY();//取得滑鼠按下時的Y座標(繪圖起始點Y座標)
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
        Graphics g = getGraphics();
		x2=e.getX();//取得滑鼠按下時的X座標(繪圖起始點X座標)
		y2=e.getY();//取得滑鼠按下時的Y座標(繪圖起始點Y座標)
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
			setLabel("筆的大小");
			m1 = new MenuItem("大");
			m2 = new MenuItem("中");
			m3 = new MenuItem("小");
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
			setLabel("顏色");
			m1 = new MenuItem("紅");
			m2 = new MenuItem("藍");
			m3 = new MenuItem("綠");
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
			setLabel("圖形");
			m1 = new MenuItem("圓形");
			m2 = new MenuItem("矩形");
			m3 = new MenuItem("三角形");
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
			setLabel("其他");
			m1 = new MenuItem("清除圖型");
			m2 = new MenuItem("烏龜畫法");
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