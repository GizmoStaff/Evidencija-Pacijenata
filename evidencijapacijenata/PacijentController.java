package evidencijapacijenata;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class PacijentController {

    private PacijentView pView;

    private Pacijent pModel;

    private Pacijent pacijent = new Pacijent();

    public PacijentController(PacijentView pView, Pacijent pModel) {

        this.pView = pView;

        this.pModel = pModel;

        this.pView.addbtnUpispListener(new btnUpispListener());
        this.pView.addbtnBrisipListener(new btnBrisipListener());
        this.pView.addbtnSearchpListener(new btnSearchpListener());
        this.pView.addbtnImportpListener(new btnImportpListener());
        this.pView.addbtnExportpListener(new btnExportpListener());
    }

    class btnUpispListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {

            String imep = pModel.getIme(pView.ime_pacijenta.getText());
            pView.ime_pacijenta.setText("");
            String prezimep = pModel.getPrezime(pView.prezime_pacijenta.getText());
            pView.prezime_pacijenta.setText("");

            String adresaPa = pModel.getAdresa(pView.adresap.getText());
            pView.adresap.setText("");

            String spp = (String) pView.sp.getSelectedItem();

            String kontak_podacip = pModel.getKontakPodaci(pView.kontak_podaci.getText());

            String krG = (String) pView.krvna_grupaP.getSelectedItem();

            pView.kontak_podaci.setText("");

            String text = pView.MBO_pac.getText();
            pView.MBO_pac.setText("");

            if (imep.isEmpty() || prezimep.isEmpty() || adresaPa.isEmpty() || kontak_podacip.isEmpty() || text.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Potrebno je popuniti sva polja");

            }

            else if (text.length() < 9 || text.length() > 9) {

                JOptionPane.showMessageDialog(null, "Uneseni MBO nije valjan.");

            } else if (text.length() == 9) {

                  if (text.matches("([0-9]{9})")) {
                    
                      
                      boolean textEntryexists=false;
                      
                      
                for (int i = 0; i <pView.model.getRowCount(); i++) {
                        if (pView.model.getValueAt(i, 6).equals(text)) {
                            JOptionPane.showMessageDialog(null, "Pacijent sa tim MBO brojem postoji!");
                            textEntryexists=true;
                            
                        }
  
                         }   
        
                    if(textEntryexists==false){
                   JOptionPane.showMessageDialog(null, "Sva polja su popunjena");
                   pView.model.addRow(new Object[]{imep, prezimep, adresaPa, kontak_podacip, spp, krG, text});
                    }
                   
                            
        
                }

            } else {

                JOptionPane.showMessageDialog(null, "Uneseni MBO nije valjan.");
            }

        }

    }

    class btnBrisipListener extends btnSearchpListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {

            int i = pView.tablicap.getSelectedRow();

            int odabir = 0;
            try {
                if (i >= 0) {
                    odabir = JOptionPane.showConfirmDialog(pView, "Sigurno želite izbrisati odabranu stavku?", "Brisanje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                }

                if (odabir == JOptionPane.YES_OPTION) {
                    pView.model.removeRow(i);
                    JOptionPane.showMessageDialog(pView, "Stavka izbrisana!");
                }

            } catch (Exception d) {
                pView.displayErrorMessage("Desila se greška!");
            }
        }
    }

    class btnSearchpListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {

            final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(pView.model);

            pView.tablicap.setRowSorter(sorter);

            String text = pView.searchp.getText();
            if (text.length() == 0) {

                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.regexFilter(text));

            }

        }

    }

    class btnImportpListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {

            JFileChooser odabir = new JFileChooser();
            odabir.showOpenDialog(null);
            File fimportp = odabir.getSelectedFile();
            String nazivdat = fimportp.getAbsolutePath();

            DefaultTableModel model = (DefaultTableModel) pView.tablicap.getModel();

            try (BufferedReader br = new BufferedReader(new FileReader(nazivdat))) {

                String dataLine;

                Object[] dataArray;
                // citanje podataka i import u tabelu
                while ((dataLine = br.readLine()) != null) {

                    // ignorira praznu podatkovnu liniju ukoliko ih ima
                    if (dataLine.equals("")) {
                        continue;
                    }
                    // Podijelite podatkovnu liniju razdvojenu zarezom u Object Array

                    dataArray = dataLine.split(",");
                    model.addRow(dataArray);

                }
            } catch (FileNotFoundException ex) {
                System.err.println("Data File Not Found!");
            } catch (IOException ex) {
                System.err.println("IO Exception Encounterd!\n" + ex.getMessage());
            }
        }
    }

    class btnExportpListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {

            try {
                File filep = new File("Lista pacijenti.txt");
                if (!filep.exists()) {
                    filep.createNewFile();
                }

                int odabir = JOptionPane.showConfirmDialog(pView, "Da li želite prepisati (''overwrite'') postojeću datoteku Pacijenti.txt?", "Verifikacija", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (odabir == JOptionPane.YES_OPTION) {
                    FileWriter fileWp = new FileWriter(filep);
                    BufferedWriter fileBWp = new BufferedWriter(fileWp);

                    // UPISIVANJE IMENA STUPACA U DATOTEKU
                    /* for(int i = 0 ; i < pView.model.getColumnCount() ; i++)
                                              {
                                                fileBWp.write( pView.model.getColumnName(i));
                                                fileBWp.write(",");
                                              }*/
                    for (int i = 0; i < pView.model.getRowCount(); i++) {
                        fileBWp.newLine();
                        for (int j = 0; j < pView.model.getColumnCount(); j++) {
                            fileBWp.write((String) (pView.model.getValueAt(i, j)));
                            fileBWp.write(" , ");
                        }
                    }

                    fileBWp.close();
                    fileWp.close();

                    JOptionPane.showMessageDialog(null, "Podaci uspješno spremljeni u datoteku!");

                } else {
                    FileWriter fileWp = new FileWriter(filep, true); //  false overwrite-a postojeću datoteku
                    BufferedWriter fileBWp = new BufferedWriter(fileWp);

                    // UPISIVANJE IMENA STUPACA U DATOTEKU
                    /* for(int i = 0 ; i < pView.model.getColumnCount() ; i++)
                                              {
                                                fileBWp.write( pView.model.getColumnName(i));
                                                fileBWp.write(",");
                                              }*/
                    for (int i = 0; i < pView.model.getRowCount(); i++) {
                        fileBWp.newLine();
                        for (int j = 0; j < pView.model.getColumnCount(); j++) {
                            fileBWp.write((String) (pView.model.getValueAt(i, j)));
                            fileBWp.write(" , ");
                        }
                    }

                    fileBWp.close();
                    fileWp.close();

                    JOptionPane.showMessageDialog(null, "Podaci uspješno spremljeni u datoteku!");

                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }
    }
}
