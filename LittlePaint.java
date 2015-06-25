import java.awt.*;
import java.awt.event.*;




class mouse extends Panel implements MouseListener,MouseMotionListener{

    int x1,y1,
        x2,y2;
    int pweight,pmode=3;
    Color pcolor;
    		
    public mouse() {
		// TODO Auto-generated constructor stub
    	addMouseListener(this);
    	addMouseMotionListener(this);
	}
    
    public void setpencolor(Color c){
    	pcolor = c;
    }
    public void setpenmode(int m){
    	pmode = m;
    }
    public void setpenweight(int w){
    	pweight = w;
    }
    
    public void paint(Graphics g){
    	g.setColor(pcolor);
    	Graphics2D g2 = (Graphics2D) g.create();
    	Stroke stroke = new BasicStroke( pweight,  BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 10);
    	g2.setStroke(stroke);
    	if(pmode == 1){
   		    int width = Math.abs(x2 - x1);
   	        int height = Math.abs(y2 - y1);
            g2.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), width, height, 15, 15);
   	    }
    	if(pmode == 2){
    		 int width = Math.abs(x2 - x1);
    	     int height = Math.abs(y2 - y1);
             g2.drawOval(Math.min(x1, x2), Math.min(y1, y2), width, height);
    	}
        if(pmode == 3){
       	g2.drawLine(x1, y1, x2, y2);
        }
        if(pmode == 4){
        	int width = Math.abs(x2 - x1);
   	        int height = Math.abs(y2 - y1);
           	g2.drawRect(Math.min(x1, x2), Math.min(y1, y2), width, height);
        }     	
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
		if(pmode==3)
		{
		  Graphics g=getGraphics();//取得視窗繪圖區
		  x2=e.getX();//取得滑鼠按下時的X座標(繪圖起始點X座標)
		  y2=e.getY();//取得滑鼠按下時的Y座標(繪圖起始點Y座標)
		  paint(g);
		  x1=x2;
		  y1=y2;
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//圓角矩形
		if(pmode==1){      //圓矩形
		   Graphics g=getGraphics();//取得視窗繪圖區
		   x2=e.getX();//取得滑鼠按下時的X座標(繪圖起始點X座標)
		   y2=e.getY();//取得滑鼠按下時的Y座標(繪圖起始點Y座標)
		   paint(g);
	    }
		if(pmode==2){      //圓形
		   Graphics g=getGraphics();//取得視窗繪圖區
		   x2=e.getX();//取得滑鼠按下時的X座標(繪圖起始點X座標)
		   y2=e.getY();//取得滑鼠按下時的Y座標(繪圖起始點Y座標)
		   paint(g);
		}
		if(pmode==4){     //矩形
			   Graphics g=getGraphics();//取得視窗繪圖區
			   x2=e.getX();//取得滑鼠按下時的X座標(繪圖起始點X座標)
			   y2=e.getY();//取得滑鼠按下時的Y座標(繪圖起始點Y座標)
			   paint(g);
		}
	}
	
}
class mFrame extends Frame{
	int penweight,colorchoose=3,penmode=3;
    Color[] color;
    mouse mouse = new mouse();
    public mFrame(){
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
		
		add(mouse);
		setMenuBar(mb);
		setTitle("小畫家阿");
    	setVisible(true);
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
			mouse.setpenweight(penweight);
		}
	}
	class Pencolor extends Menu implements ActionListener{
		MenuItem m1,m2,m3,x;
		public Pencolor(){
			color = new Color[5];
			color[0] = Color.RED;
			color[1] = Color.blue;
			color[2] = Color.green;
			color[3] = Color.black;
			color[4] = Color.white;
			
			setLabel("顏色");
			m1 = new MenuItem("紅");
			m2 = new MenuItem("藍");
			m3 = new MenuItem("綠");
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
            	colorchoose=0;
            else if(x == m2)
            	colorchoose=1;
            else if(x == m3)
            	colorchoose=2;
            else 
            	colorchoose=3;
			mouse.setpencolor(color[colorchoose]);
		}
	}
	class Penmodel extends Menu implements ActionListener{
		MenuItem m1,m2,m3,m4,x;
		public Penmodel(){
			setLabel("圖形");
			m1 = new MenuItem("圓矩形");
			m2 = new MenuItem("圓形");
			m3 = new MenuItem("直線");
			m4 = new MenuItem("矩形");
			add(m1);
			add(m2);
			add(m3);
			add(m4);
			m1.addActionListener(this);
			m2.addActionListener(this);
			m3.addActionListener(this);
			m4.addActionListener(this);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		    x = (MenuItem) e.getSource();
		    if(x == m1)
		    	penmode=1;
		    else if(x == m2)
		    	penmode=2;
		    else if(x ==m4)
		    	penmode=4;
		    else
		    	penmode=3;
		    mouse.setpenmode(penmode);
		}
	}
	class Penother extends Menu implements ActionListener{
		MenuItem m1,m2,m3,x;
		public Penother(){
			setLabel("其他");
			m1 = new MenuItem("清除圖型");
			m2 = new MenuItem("橡皮擦");
			m3 = new MenuItem("烏龜畫法");
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
				mouse.repaint();
			else if(x == m2)
				colorchoose=4;
			mouse.setpencolor(color[colorchoose]);	
		}
	}
}
public class LittlePaint{
	public static void main(String args[]){
		mFrame f = new mFrame();
	}
}