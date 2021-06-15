package in.ac.uecu.model;
import java.awt.*;
public class CanvasCaret
{
public int x;
public int y;
public int width;
public int height;
public int row;
public int column;
public Color color;
public boolean isVisible;
public boolean isFocused;

public CanvasCaret()
{
this.x=2;
this.y=2;
this.width=2;
this.height=30;
this.row=1;
this.column=1;
this.color=Color.BLUE;
this.isVisible=false;
this.isFocused=true;
}
}