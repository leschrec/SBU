import java.util.ArrayList;
import java.util.List;

public class Model extends java.util.Observable{

	List fileList = new ArrayList();

	public Model() {
		System.out.println("Model erstellt");

		fileList.add("gdfihlu.png");
		fileList.add("iuhdsf.mp3");
		fileList.add("dfsgiuh.doc");
		fileList.add("asdfsadf.xml");
		
	}

	public boolean loginAction(String user, String password) {

		if (user.equals("a")) {
			if (password.equals("a")) {
				return true;
			}
		}
		return false;
	}
	
	public String[] files(){
		
		String fileString[]=new String[99];
		
		for(int i=0; i<fileList.size(); i++){
			fileString[i]=(String) fileList.get(i);
		}
		
		return fileString;
	}

	public void deleteSomething() {
		// TODO Auto-generated method stub
		
	}

	public void addFile(String file) {
		// TODO Auto-generated method stub
		fileList.add(file);
		System.out.println(file+" hochgeladen.");
		
		setChanged();
		notifyObservers();
	}

	public void shareFile(int fileID) {
		// TODO Auto-generated method stub
		System.out.println("Shared file "+fileID+" equals "+fileList.get(fileID));
	}

}
