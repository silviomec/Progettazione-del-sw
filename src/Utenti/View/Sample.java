package Utenti.View;

import javax.lang.model.element.Element;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.ListView;

public class Sample extends JFrame   {
    public Sample(){
        JEditorPane pane = new JEditorPane();
        pane.setContentType("text/html");
        pane.setText("<ol id='foo'><li>One</li><li>Two</li></ol>"); 
        HTMLDocument doc = (HTMLDocument) pane.getDocument();
        add(pane);

        //Get the ref of foo element
        Element ele=(Element) doc.getElement("foo");
        ListView view=new ListView((javax.swing.text.Element) ele);
        System.out.println(((javax.swing.text.Element) ele).getElementCount());
        try{
             Object anchor = null;
			doc.insertBeforeEnd(((HTMLDocument) ele).getElement(null, 0, anchor), "<ul><li>Test");          
        }catch(Exception ex){}
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setVisible(true);
    }
}
