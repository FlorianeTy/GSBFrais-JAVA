package gsb.tests;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel;

public class TestApplication {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				
				
			try 
			    {
			      UIManager.setLookAndFeel(new SyntheticaClassyLookAndFeel());
			    } 
			    catch (Exception e) 
			    {
			      e.printStackTrace();
			    }
			
				
				
				//On crée une nouvelle instance de notre JDialog
				Application fenetre = new Application();
				fenetre.setVisible(true);//On la rend visible
			}
		});
}
}
