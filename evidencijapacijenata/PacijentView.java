
package evidencijapacijenata;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class PacijentView extends JFrame {
    
    Pacijent pac=new Pacijent();
    
  
    
    private JLabel lblime=new JLabel("Ime pacijenta: ");
     JTextField ime_pacijenta= new JTextField(20);
    private JLabel lblprezime=new JLabel("Prezime pacijenta: ");
     JTextField prezime_pacijenta= new JTextField(20);
    
     private JLabel lbladresa=new JLabel("Adresa:");
     JTextField adresap=new JTextField(60);
    
    private JLabel lblspol=new JLabel("Spol: ");
    
    
            
    JComboBox sp=new JComboBox(pac.spol);
    
    private JLabel krvnaG= new JLabel("Krvna grupa:");
    JComboBox krvna_grupaP=new JComboBox(pac.krvna_grupa);
    
   
    private JLabel lblkontak=new JLabel("Kontakt podaci: ");
    private JLabel lblkontakvrsta=new JLabel("(e-mail, telefon) ");
 
    JTextField kontak_podaci= new JTextField(60);
   
 
 
    private JLabel lblMBO= new JLabel ("MBO: ");
    JTextField MBO_pac=new JTextField(10);
    
    
    private JButton btnUpisp=new JButton("UPIS");
    private JButton btnBrisip=new JButton("BRISANJE");
    private JButton btnSearchp=new JButton("PRETRAŽI");
    JTextField searchp=new JTextField(20);
     private JButton btnExportp=new JButton("IZVOZ PODATAKA U TXT DATOTEKU");
   
      private JButton btnImportp=new JButton("UVOZ PODATAKA IZ TXT DATOTEKE");
   
     DefaultTableModel model = new DefaultTableModel();
       JTable tablicap=new JTable(model);
    
    
    PacijentView(){
        
        JPanel pacijentPanel=new JPanel();
        
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
           
       this.addWindowListener(new WindowAdapter(){
                public void windowClosing (WindowEvent a){
                     int odabir= JOptionPane.showConfirmDialog(pacijentPanel, "Kraj programa?\n \nNapomena: Kako bi sačuvali unesene podatke,\n"
                             + "napravite izvoz podataka u txt datoteku!","Verifikacija",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

                                     if(odabir==JOptionPane.YES_OPTION){
                                         System.exit(0);
                                     }
                }
       
          });
        
       
         this.setSize(1100, 600);
         this.setTitle("PACIJENTI");
         pacijentPanel.setBackground(Color.CYAN);
         
       Dimension sizeime=lblime.getPreferredSize();
       lblime.setBounds(50,20, sizeime.width, sizeime.height);
       
       Dimension sizeimep=ime_pacijenta.getPreferredSize();
       ime_pacijenta.setBounds(170,20, sizeimep.width, sizeimep.height);
       
       Dimension sizeprezime=lblprezime.getPreferredSize();
       lblprezime.setBounds(430,20, sizeprezime.width, sizeprezime.height);
       
       Dimension sizeprezimep=prezime_pacijenta.getPreferredSize();
       prezime_pacijenta.setBounds(565,20, sizeprezimep.width, sizeprezimep.height);
          
       
       Dimension sizeadresa=lbladresa.getPreferredSize();
       lbladresa.setBounds(50,60, sizeadresa.width, sizeadresa.height);
       
       Dimension sizeadresap=adresap.getPreferredSize();
       adresap.setBounds(170,60, sizeadresap.width, sizeadresap.height);
       

       
       Dimension sizekontak=lblkontak.getPreferredSize();
       lblkontak.setBounds(50,100, sizekontak.width, sizekontak.height);
       
       Dimension sizekontakvrsta=lblkontakvrsta.getPreferredSize();
       lblkontakvrsta.setBounds(50,120, sizekontakvrsta.width, sizekontakvrsta.height);
       
       Dimension sizekontakp=kontak_podaci.getPreferredSize();
       kontak_podaci.setBounds(170,100, sizekontakp.width, 40);
       
       
       
       Dimension sizespol=lblspol.getPreferredSize();
       lblspol.setBounds(50,160, sizespol.width, sizespol.height);
       Dimension sizespolp1=sp.getPreferredSize();
       sp.setBounds(170, 160, sizespolp1.width, sizespolp1.height);
       

       Dimension sizekrvnaGP=krvnaG.getPreferredSize();
       krvnaG.setBounds(350,160, sizekrvnaGP.width, sizekrvnaGP.height);
       Dimension sizekrvnaGp=krvna_grupaP.getPreferredSize();
       krvna_grupaP.setBounds(450, 160, sizekrvnaGp.width, sizekrvnaGp.height);
       
 
       Dimension sizeMBO=lblMBO.getPreferredSize();
       lblMBO.setBounds(600,160, sizeMBO.width, sizeMBO.height);
       
       Dimension sizeMBOp=MBO_pac.getPreferredSize();
       MBO_pac.setBounds(660,160, sizeMBOp.width, sizeMBOp.height);
       
       
       Dimension sizeUpis=btnUpisp.getPreferredSize();
       btnUpisp.setBounds(100, 210, sizeUpis.width, sizeUpis.height);
       
       Dimension sizeBrisi=btnBrisip.getPreferredSize();
       btnBrisip.setBounds(240, 210, sizeBrisi.width, sizeBrisi.height);
       
       Dimension sizeSearchp=btnSearchp.getPreferredSize();
       btnSearchp.setBounds(390, 210, sizeSearchp.width, sizeSearchp.height);
       
      
       searchp.setBounds(490, 210, 300, 27);

       Dimension sizeImportp=btnImportp.getPreferredSize();
       btnImportp.setBounds(150, 500, sizeImportp.width, sizeImportp.height);
       
  
       Dimension sizeExportp=btnExportp.getPreferredSize();
       btnExportp.setBounds(600, 500, sizeExportp.width, sizeExportp.height);
      
       /////////////////TABLICA////////////////////////
       
      
       model.addColumn("Ime");
       model.addColumn("Prezime");
       model.addColumn("Adresa");
       model.addColumn("Kontakt podaci");
       model.addColumn("Spol");
       model.addColumn("Krvna grupa");
       model.addColumn("MBO");
       
       
     
       JScrollPane scrollPanep=new JScrollPane(tablicap);
       tablicap.setFillsViewportHeight(true);
       scrollPanep.setBounds(50, 280, 1000, 150);
          
       
       tablicap.getColumnModel().getColumn(2).setPreferredWidth(200);
       tablicap.getColumnModel().getColumn(3).setPreferredWidth(200);
       tablicap.getColumnModel().getColumn(4).setPreferredWidth(40);
        tablicap.getColumnModel().getColumn(5).setPreferredWidth(40);
       
      pacijentPanel.setLayout(null);
             
      
         pacijentPanel.add(lblime);
         pacijentPanel.add(ime_pacijenta);
         pacijentPanel.add(lblprezime);
         pacijentPanel.add(prezime_pacijenta);
         pacijentPanel.add(lbladresa);
         pacijentPanel.add(adresap);
         pacijentPanel.add(lblkontak);
         pacijentPanel.add(lblkontakvrsta);
         pacijentPanel.add(kontak_podaci);
         pacijentPanel.add(lblspol);
         pacijentPanel.add(sp);
         pacijentPanel.add(krvnaG);
         pacijentPanel.add(krvna_grupaP);
         pacijentPanel.add(lblMBO);
         pacijentPanel.add(MBO_pac);
         
         pacijentPanel.add(btnUpisp);
         
         pacijentPanel.add(btnBrisip);
         
         pacijentPanel.add(btnSearchp);
         pacijentPanel.add(searchp);
       pacijentPanel.add(scrollPanep);
       pacijentPanel.add(btnImportp);
       pacijentPanel.add(btnExportp);
       
         
         this.add(pacijentPanel);
    }
     
    ////////////////////////////////////////////////////////////////////////////////////
    
     void addbtnUpispListener(ActionListener upispGumb){
        btnUpisp.addActionListener(upispGumb);
        
    }
   
      void addbtnBrisipListener(ActionListener brisipGumb){
        btnBrisip.addActionListener(brisipGumb);
    }
     
      
         void addbtnSearchpListener(ActionListener searchpGumb){
        btnSearchp.addActionListener(searchpGumb);
    }
         
         
     void addbtnImportpListener(ActionListener importpGumb){
        btnImportp.addActionListener(importpGumb);
    }     
         
         
      void addbtnExportpListener(ActionListener exportpGumb){
        btnExportp.addActionListener(exportpGumb);
    }
  
     
     void displayErrorMessage(String errorMessage){
        
        JOptionPane.showMessageDialog(this, errorMessage);
    }
   
}
