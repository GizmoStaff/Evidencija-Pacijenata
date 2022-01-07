/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencijapacijenata;

/**
 *
 * @author Lilith
 */
public class EvidencijaPacijenata {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         
        PacijentView pView=new PacijentView();
       
        
        Pacijent pModel= new Pacijent();
      
        PacijentController ltController=new PacijentController(pView,pModel);
        
        pView.setVisible(true);
        
        
    }
    
}
