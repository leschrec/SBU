package ui;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import controller.Controller;


@SuppressWarnings("serial")
public class ContextMenu extends JPopupMenu{

	int windowWidth=Constants.padding*8;
	int windowHeight=Constants.padding*4;
	
	int fileID;
	String ficken="b";
	
	JMenuItem items[]=new JMenuItem[7];
	
	public ContextMenu(Controller controller, Object object, String username, int fileID, boolean ownsFile){

		this.fileID=fileID;

		items[0]=new JMenuItem("Teilen");
		items[1]=new JMenuItem("Umbenennen");
		items[2]=new JMenuItem("Öffnen");
		items[3]=new JMenuItem("Herunterladen");
		items[4]=new JMenuItem("Verschieben");
		items[5]=new JMenuItem("Löschen");
		items[6]=new JMenuItem("Kopieren");
		
		for(int i=0; i<items.length; i++){
			if(i==0&&!ownsFile){} else	//bei fremden dateien kein Teilen möglich machen
			add(items[i]);
		}
		
		if(ownsFile)
			items[0].addActionListener(controller.shareFileButtonListener(username, fileID));
	}
	
}
