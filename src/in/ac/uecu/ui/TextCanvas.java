package in.ac.uecu.ui;
import in.ac.uecu.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class TextCanvas extends Canvas implements KeyListener,MouseListener,MouseMotionListener,MouseWheelListener
{
public DataModel dataModel;
public StringBuilder sb;
public TextCanvas(DataModel dataModel)
{
this.sb=new StringBuilder();
this.setVisible(true);
this.dataModel=dataModel;
this.addKeyListener(this);
this.addMouseListener(this);
this.addMouseMotionListener(this);
this.addMouseWheelListener(this);
this.setFont(this.dataModel.font);
Thread caretThread= new Thread(()->{
while(true)
{
if(this.dataModel.caretLock)
{
try
{
Thread.sleep(500);
}catch(Exception exception)
{
System.out.println(exception);
}
continue;
}
try
{
Thread.sleep(500);
}catch(Exception exception)
{
System.out.println(exception);
}
this.repaint(this.dataModel.canvasCaret.x,this.dataModel.canvasCaret.y,this.dataModel.canvasCaret.width,this.dataModel.canvasCaret.height);
}
});
caretThread.start();
this.setBackground(Color.WHITE);
this.setCursor(new Cursor(Cursor.TEXT_CURSOR));
}
public void paint(Graphics g)
{
if(this.dataModel.canvasCaret.isFocused)
{
if(this.dataModel.canvasCaret.isVisible)
{
g.clearRect(this.dataModel.canvasCaret.x,this.dataModel.canvasCaret.y,this.dataModel.canvasCaret.width,this.dataModel.canvasCaret.height);
this.dataModel.canvasCaret.isVisible=false;
}
else
{
g.setColor(this.dataModel.canvasCaret.color);
g.fillRect(this.dataModel.canvasCaret.x,this.dataModel.canvasCaret.y,this.dataModel.canvasCaret.width,this.dataModel.canvasCaret.height);
this.dataModel.canvasCaret.isVisible=true;
}
}
}

public void keyTyped(KeyEvent ke)
{
this.dataModel.caretLock=true;
int x,y,width,height;
x=this.dataModel.canvasCaret.x;
y=this.dataModel.canvasCaret.y;
width=this.dataModel.canvasCaret.width;
height=this.dataModel.canvasCaret.height;
Graphics g=this.getGraphics();
char chars[]=new char[1];
chars[0]=ke.getKeyChar();
this.sb.append(chars[0]);
g.setColor(this.dataModel.textColor);
int charWidth=g.getFontMetrics().charWidth(chars[0]);
int lineHeight=g.getFontMetrics().getHeight();
int topMargin=this.dataModel.textTopMargin+lineHeight-10;
int leftMargin=this.dataModel.textLeftMargin;
g.clearRect(x,y,width,height);
this.dataModel.canvasCaret.isVisible=false;
if(chars[0]=='\n')
{
this.dataModel.canvasCaret.x=2;
this.dataModel.canvasCaret.y+=lineHeight;
this.dataModel.caretLock=false;
return;
}
else if(chars[0]=='\b')
{
sb.deleteCharAt(sb.length()-1);
char previousChar=this.sb.charAt(sb.length()-1);
sb.deleteCharAt(sb.length()-1);
int previousCharWidth=g.getFontMetrics().charWidth(previousChar);
if(previousChar=='\n')
{

}
else
{
this.dataModel.canvasCaret.x-=previousCharWidth;
this.dataModel.canvasCaret.column-=1;
}
g.clearRect(this.dataModel.canvasCaret.x,this.dataModel.canvasCaret.y,previousCharWidth,lineHeight);
this.dataModel.caretLock=false;
return;
}
else if(chars[0]=='\t')
{
this.dataModel.caretLock=false;
return;
}
g.drawChars(chars,0,1,x+leftMargin,y+topMargin);
this.dataModel.canvasCaret.x+=charWidth;
this.dataModel.canvasCaret.column+=1;
g.setColor(this.dataModel.canvasCaret.color);
g.fillRect(this.dataModel.canvasCaret.x,this.dataModel.canvasCaret.y,this.dataModel.canvasCaret.width,this.dataModel.canvasCaret.height);
this.dataModel.canvasCaret.isVisible=true;
this.dataModel.caretLock=false;
}

public void keyPressed(KeyEvent ke)
{
}
public void keyReleased(KeyEvent ke)
{
}
public void mouseClicked(MouseEvent me)
{
}
public void mouseEntered(MouseEvent me)
{
}
public void mouseExited(MouseEvent me)
{
}
public void mousePressed(MouseEvent me)
{
}
public void mouseReleased(MouseEvent me)
{
}
public void mouseWheelMoved(MouseWheelEvent me)
{
}
public void mouseDragged(MouseEvent me)
{
}
public void mouseMoved(MouseEvent me)
{
}
}