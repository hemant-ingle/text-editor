package in.ac.uecu;
import in.ac.uecu.ui.*;
class Main
{
public static void main(String arguments[])
{
TextEditor textEditor;
if(arguments.length==1) textEditor=new TextEditor(arguments[0]);
else textEditor=new TextEditor();
}
}