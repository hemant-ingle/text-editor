package in.ac.uecu.ui;
import in.ac.uecu.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class TopMenuBar extends JMenuBar
{
public DataModel dataModel;
private JMenu fileMenu,editMenu,formatMenu,viewMenu,helpMenu;
private JMenuItem newMenuItem,openMenuItem,saveMenuItem,saveAsMenuItem,printMenuItem,exitMenuItem;
public TopMenuBar(DataModel dataModel)
{
this.dataModel=dataModel;
fileMenu=new JMenu("File");
fileMenu.setMnemonic('F');
editMenu=new JMenu("Edit");
editMenu.setMnemonic('E');
formatMenu=new JMenu("Format");
formatMenu.setMnemonic('o');
viewMenu=new JMenu("View");
viewMenu.setMnemonic('V');
helpMenu=new JMenu("Help");
helpMenu.setMnemonic('H');

newMenuItem=new JMenuItem("New    Ctrl+N");
openMenuItem=new JMenuItem("Open...    Ctrl+O");
saveMenuItem=new JMenuItem("Save      Ctrl+S");
saveAsMenuItem=new JMenuItem("Save As...        ");
printMenuItem=new JMenuItem("Print...     Ctrl+P");
exitMenuItem=new JMenuItem("Exit           ");
fileMenu.add(newMenuItem);
fileMenu.add(openMenuItem);
fileMenu.add(saveMenuItem);
fileMenu.add(saveAsMenuItem);
fileMenu.add(printMenuItem);
fileMenu.add(exitMenuItem);

this.add(fileMenu);
this.add(editMenu);
this.add(formatMenu);
this.add(viewMenu);
this.add(helpMenu);
}
}