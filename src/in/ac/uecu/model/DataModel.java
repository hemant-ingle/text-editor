package in.ac.uecu.model;
import java.awt.*;
public class DataModel
{
public String fileName;
public int textTopMargin;
public int textLeftMargin;
public int fontSize;
public Font font;
public CanvasCaret canvasCaret;
public Color textColor;
public boolean caretLock;
public DataModel(String fileName)
{
this.textTopMargin=2;
this.textLeftMargin=0;
this.fileName=fileName;
this.fontSize=24;
this.font=new Font("Times New Roman",Font.PLAIN,this.fontSize);
this.canvasCaret=new CanvasCaret();
this.textColor=Color.RED;
this.caretLock=false;
}
}
