/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocr_gui;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import static jdk.nashorn.internal.objects.NativeRegExp.source;
import org.bytedeco.javacpp.opencv_core.CvMemStorage;
import org.bytedeco.javacpp.opencv_core.CvPoint;
import org.bytedeco.javacpp.opencv_core.CvPoint2D32f;
import org.bytedeco.javacpp.opencv_core.CvPoint3D32f;
import org.bytedeco.javacpp.opencv_core.CvScalar;
import org.bytedeco.javacpp.opencv_core.CvSeq;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_core.Size;
import static org.bytedeco.javacpp.opencv_core.cvCreateImage;
import static org.bytedeco.javacpp.opencv_core.cvGetSeqElem;
import static org.bytedeco.javacpp.opencv_core.cvGetSize;
import static org.bytedeco.javacpp.opencv_core.cvPointFrom32f;
import static org.bytedeco.javacpp.opencv_highgui.cvShowImage;
import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
import static org.bytedeco.javacpp.opencv_imgproc.CV_AA;
import static org.bytedeco.javacpp.opencv_imgproc.CV_BGR2GRAY;
import static org.bytedeco.javacpp.opencv_imgproc.CV_GAUSSIAN;
import static org.bytedeco.javacpp.opencv_imgproc.CV_HOUGH_GRADIENT;
import static org.bytedeco.javacpp.opencv_imgproc.cvCircle;
import static org.bytedeco.javacpp.opencv_imgproc.cvCvtColor;
import static org.bytedeco.javacpp.opencv_imgproc.cvHoughCircles;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Orges
 */
public class Aplikacioni extends javax.swing.JPanel
{

    /**
     * Creates new form Aplikacioni
     */
    public Aplikacioni()
    {
        initComponents();
        this.add( jPanel1 );
        this.add( jLabel1 );
        this.add( opencvJLabel );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        imageJLabel = new javax.swing.JLabel();
        opencvJLabel = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(97, 212, 195));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Projekti OCR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jButton1.setText("Lexo Foto");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 170, 50));

        jButton2.setText("Mbyll");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 170, 50));

        jButton3.setText("jButton1");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 170, 50));

        jButton4.setBackground(getBackground());
        jButton4.setText("Zgjidh Foto");
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 170, 50));

        imageJLabel.setBackground(getBackground());

        setBackground(new java.awt.Color(36, 47, 65));
        setLayout(new java.awt.GridLayout(1, 3));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
            IplImage src = cvLoadImage( filePath );
            IplImage gray = cvCreateImage(cvGetSize(src), 8, 1);

            cvCvtColor(src, gray, CV_BGR2GRAY);  
            //cvSmooth(gray, gray, CV_GAUSSIAN, 3);
            //Mat matImage = new Mat( gray );
            //Imgproc.GaussianBlur(gray, gray, new Size(5, 5) ,1 ,1);
         
            
            CvMemStorage mem = CvMemStorage.create();

            CvSeq circles = cvHoughCircles( 
              gray, //Input image
              mem, //Memory Storage
              CV_HOUGH_GRADIENT, //Detection method
              1, //Inverse ratio
              10, //Minimum distance between the centers of the detected circles
              100, //Higher threshold for canny edge detector
              100, //Threshold at the center detection stage
              0, //min radius
              0 //max radius
              );

            for(int i = 0; i < circles.total(); i++){
                CvPoint3D32f circle = new CvPoint3D32f(cvGetSeqElem(circles, i));
                CvPoint center = cvPointFrom32f(new CvPoint2D32f(circle.x(), circle.y()));
                int radius = Math.round(circle.z());      
                cvCircle(src, center, radius, CvScalar.GREEN, 6, CV_AA, 0);    
               }

             cvShowImage("Result",src);  
             cvWaitKey(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
    {//GEN-HEADEREND:event_jButton4ActionPerformed
       JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "JPG | PNG | GIF Images", "jpg",  "png", "gif");
        
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        
        if(returnVal == JFileChooser.APPROVE_OPTION) 
        {
            filePath = chooser.getSelectedFile().getAbsolutePath();
            
            jLabel1.setIcon(new ImageIcon( filePath ) );
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    
    private JPanel p2;
    private String filePath;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageJLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel opencvJLabel;
    // End of variables declaration//GEN-END:variables
}