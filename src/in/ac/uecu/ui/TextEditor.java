package in.ac.uecu.ui;
import in.ac.uecu.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class TextEditor extends JFrame
{
public DataModel dataModel;
public TopMenuBar topMenuBar;
public TextCanvas textCanvas;
public JScrollPane jScrollPane;
public StatusBar statusBar;
private Container container;
public TextEditor()
{
this.dataModel=new DataModel("Untitled");
this.initialize();
}
public TextEditor(String fileName)
{
this.dataModel=new DataModel(fileName);
this.initialize();
}
private void initialize()
{
this.container=this.getContentPane();
container.setLayout(new BorderLayout());
topMenuBar=new TopMenuBar(this.dataModel);
textCanvas=new TextCanvas(this.dataModel);
statusBar=new StatusBar(this.dataModel);
this.container.add(topMenuBar,BorderLayout.NORTH);
jScrollPane=new JScrollPane(textCanvas,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
this.container.add(jScrollPane,BorderLayout.CENTER);
this.setDefaultCloseOperation(EXIT_ON_CLOSE);
this.setSize(700,700);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
this.setLocation(d.width/2-350,d.height/2-350);
this.setVisible(true);
textCanvas.requestFocus();
}
}