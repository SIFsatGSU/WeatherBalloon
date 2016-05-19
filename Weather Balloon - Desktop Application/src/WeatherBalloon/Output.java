/*
This class outputs the incoming weather balloon data to the desktop application. This application allows the user
to view the incoming data from the weather balloon in real-time. The user can also save the data to a text file. The text 
file will be stored in a created directory called "Weather Balloon Data" on the users device. 

This class makes an instance of the WeatherBalloon class and therefore requires that the Xbee Explorer usb is 
connected to a port on the device running the desktop application. 
 */
package WeatherBalloon;

import java.awt.Toolkit;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

/*This class uses Java Swing to create the desktop form for displaying the weather related data that is coming in from 
  the arduino. */
public final class Output extends javax.swing.JFrame {

    /**
     * Creates new form Output
     */
    
    //Global Variables
    public int count = 0;
 
    /*Initializes the form for the desktop application. Sets the icon for the application
     and runs the method to constant redirect the system to update the text area and
    show the new incoming data from the weather balloon*/ 
    public Output() {
        initComponents();
        setIcon();        
        run();
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textArea1 = new java.awt.TextArea();
        saveData = new javax.swing.JButton();
        openWebsite = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea2 = new java.awt.TextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        saveData.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        saveData.setText("Save Data to Computer");
        saveData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDataActionPerformed(evt);
            }
        });

        openWebsite.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        openWebsite.setText("Upload Data to Site");
        openWebsite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openWebsiteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Humidity (%)");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Temperature (F)");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Pressure (Pa)");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Entry Number");

        textArea2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jScrollPane2.setViewportView(textArea2);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Altitude (m)");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Time (s)");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane1.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(saveData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(43, 43, 43)
                .addComponent(openWebsite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(71, 71, 71)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(74, 74, 74)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(68, 68, 68)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(109, 109, 109)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(86, 86, 86)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveData)
                            .addComponent(openWebsite))
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   //once the button is pressed the Climate Literacy Labs website is opened 
    private void openWebsiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openWebsiteActionPerformed
        openWebpage("http://localhost:8080/Weather_Balloon_Website/");
    }//GEN-LAST:event_openWebsiteActionPerformed

    /*once the button is pressed, the data is saved to the users computer. If the user has not already saved before,
     a directory will be created on the users computer named "Weather Balloon Data". Every time the save button is pressed,
     everything in the text area will be saved as a new file in the directory.*/
    private void saveDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDataActionPerformed
    //each new file will have a unique file name, with the current date and time as part of the file name
    Date date = new Date() ;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH-mm-ss");

    //name of the file directory
    File theDir = new File("Weather Balloon Data");

    // if the directory does not exist, create it
    if (!theDir.exists()) {
        boolean result = false;
    try{
        theDir.mkdir();
        result = true;
    } 
    //exception handling for the directory creation
    catch(SecurityException se){
    } 
    
    //alert the user when the new directory has been created
    if(result) {    
        jTextArea2.append("DIR created");  
        jTextArea2.append("\n");
    }
}

    //Creating the unique name for each file and storing each line of data into a string array
    String fileName = "Weather_Balloon_Data_"+dateFormat.format(date)+".txt";
    String [] lines = textArea2.getText().split("#");
    
    //adding the ne file to the directory
    File actualFile = new File (theDir, fileName);

    //writing the data to the file line by line
    try (BufferedWriter fileOut = new BufferedWriter(new FileWriter(actualFile))) {
        fileOut.write(lines[0]+"\r\n");
    
    for( int i = 1; i<lines.length;i++){ 
        fileOut.write("#"+lines[i]+"\r\n");
    }
    
    //alerts the user that the data has been saved
    jTextArea2.append("Data Saved");
    jTextArea2.append("\n");
    
    //exception handling for saving the data
}       catch (IOException ex) {
            Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveDataActionPerformed

    //method to open the Climate Literacy Labs webpage
public static void openWebpage(String urlString) {
    try {
        Desktop.getDesktop().browse(new URL(urlString).toURI());
        //exception handling for opening the webpage
    } catch (URISyntaxException | IOException e) {
    }
}
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String args[]) throws Exception {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Output.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
       
        java.awt.EventQueue.invokeLater(() -> {
            new Output().setVisible(true);
        });
        
        //creating an instance of the WeatherBalloon class
            WeatherBalloon main = new WeatherBalloon(); 
            //initializing the ports to recieve the data from the weather balloon
            main.initialize();
            
            Thread t;
            t = new Thread() {
            @Override
             //running the thread constantly to listen for new incoming data to be sent over the port
            public void run() {
                //the following line will keep this app alive for 1000    seconds,
                //waiting for events to occur and responding to them    (printing incoming messages to console).
                try {Thread.sleep(1000000);} catch (InterruptedException    ie) {}
            }
        };
    //starting the thread
    t.start();
    //writing the headers for the data entries 
    textArea2.append("Entry Number,                         Humidity,                           Temperature,                            Pressure,                                   Altitude,                               Time,");
    textArea2.append("\n");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton openWebsite;
    private javax.swing.JButton saveData;
    private java.awt.TextArea textArea1;
    public static java.awt.TextArea textArea2;
    // End of variables declaration//GEN-END:variables

    //setting the icon image for the desktop application
    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }

 //this method redirects the data to the desktop form 
 public  void run()
    {
       redirectSystemStreams();        
    }
     
//The following codes set where the text get redirected. In this case, jTextArea2  
  private void updateTextArea(final String text) throws IOException {
    SwingUtilities.invokeLater(() -> {
        //adds the entry number for each new line of data
        if(text.contains(".")){
            count++;
            textArea2.append(text.replace(text,"#"+count+",                                              "));
        }
        //filters the new data of all non-data related messages
        String subText = text.substring(text.indexOf("$")+1);
        String pattern1 = "#";
        String pattern2 = ",";
        Pattern p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
        Matcher m = p.matcher(subText);
         
        //adds the data, line by line to the text area
        while (m.find()) {
            textArea2.append(m.group(1) + ",");
            textArea2.append("                                   ");
        }
        textArea2.append("\n");
    });
  }
 
//Followings are The Methods that do the Redirect, you can simply Ignore them. 
  private void redirectSystemStreams() {
    OutputStream out = new OutputStream() {
      @Override
      public void write(int b) throws IOException {
        updateTextArea(String.valueOf((char) b));
      }
 
      @Override
      public void write(byte[] b, int off, int len) throws IOException {
        updateTextArea(new String(b, off, len));
      }
 
      @Override
      public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
      }
    };
 
    System.setOut(new PrintStream(out, true));
    System.setErr(new PrintStream(out, true));
  }
}
