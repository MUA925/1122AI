import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	int x=120,y=100,count=0;
	Image img[][]=new Image[4][3];
	Image currentImg;
	public MainCanvas(){
	try{
		for(int i=0;i<4;i++){
		   for(int j=0;j<3;j++){
		    img[i][j]=Image.createImage("/sayo"+i+j+".png");
			/*
			i值的含义：
			0为left
			1为down
			2为right
			3为up
			*/
		   
		   }
		}
		
		currentImg=img[0][1];
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,255,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
	int action=getGameAction(keyCode);
//left
	if(action==LEFT){
		if(count==0){
		currentImg=img[0][1];
		count++;
		}else if(count==1){
		currentImg=img[0][0];
		count++;
  		}else if(count==2){
		currentImg=img[0][2];
		count=1;
		}
		this.x=this.x-5;
	}


//right
	if(action==RIGHT){
		if(count==0){
		currentImg=img[2][1];
		count++;
		}else if(count==1){
		currentImg=img[2][0];
		count++;
  		}else if(count==2){
		currentImg=img[2][2];
		count=1;
		}	
		this.x=this.x+5;
	}

//up
	if(action==UP){
		if(count==0){
		currentImg=img[3][1];
		count++;
		}else if(count==1){
		currentImg=img[3][0];
		count++;
  		}else if(count==2){
		currentImg=img[3][2];
		count=1;
		}	
		this.y=this.y-5;
	}


//down
	if(action==DOWN){
		if(count==0){
		currentImg=img[1][1];
		count++;
		}else if(count==1){
		currentImg=img[1][0];
		count++;
  		}else if(count==2){
		currentImg=img[1][2];
		count=1;
		}	
		this.y=this.y+5;
	}
	repaint();
	}
}