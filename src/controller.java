import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import ui.Constants;
import ui.SFileButton;


public class Controller  implements ActionListener, MouseListener{

	Model model;
	View view;
	
	public Controller(Model model, View view) {
		// TODO Auto-generated constructor stub
		System.out.println("Controller erstellt.");
		this.model=model;
		this.view=view;
		
		
		
	}
	
	public ActionListener getDeleteListener () {
        return new ActionListener() {
            @Override public void actionPerformed (ActionEvent e) {
                model.deleteSomething();
            }
        };
    }
	
	public ActionListener addFileListener () {
        return new ActionListener() {
            @Override public void actionPerformed (ActionEvent e) {
                model.addFile(view.file1);
            }
        };
    }
	
	public ActionListener addShareFileListener(final int i) {
		return new ActionListener() {
            @Override public void actionPerformed (ActionEvent e) {
                //model.shareFile(view.file1);
                model.shareFile(i);
            	//model.shareFile(((ContextMenu)e.getSource()).ficken);
            //	model.shareFile(((ContextMenu)e.getClass()).ficken);
            }
        };
	}
	
	/*
	public ActionListener fileClickListener () {
        return new ActionListener() {
            @Override public void actionPerformed (ActionEvent et) {
                ContextMenu cm=new ContextMenu();
                //cm.show(invoker, x, y)
          //      e.getSource.setComponentPopupMenu(cm);
            	//.setComponentPopupMenu(cm);
              //  ((JComponent) et.getSource()).setComponentPopupMenu(cm);
                cm.show((Component) et.getSource(), 0, 0);
            }
        };
    }*/
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		 ContextMenu cm=new ContextMenu(this, e.getSource(), ((SFileButton) e.getSource()).getID());
		 
         cm.show((Component) e.getSource(), e.getX(), e.getY());
         
         
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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

	
	
	
}
