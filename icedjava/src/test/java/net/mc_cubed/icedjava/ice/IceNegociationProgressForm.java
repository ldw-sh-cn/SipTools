/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IceNegociationProgressForm.java
 *
 * Created on Dec 16, 2010, 12:09:25 PM
 */

package net.mc_cubed.icedjava.ice;

import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author charles
 */
public class IceNegociationProgressForm extends javax.swing.JFrame {

    /** Creates new form IceNegociationProgressForm */
    public IceNegociationProgressForm() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        localPeer = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        remotePeer = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout());

        jSplitPane1.setDividerSize(5);
        jSplitPane1.setResizeWeight(0.5);
        jSplitPane1.setEnabled(false);
        jSplitPane1.setFocusable(false);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("localPeer");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        localPeer.setModel(new PairStatusTableModel(new ArrayList<CandidatePair>()));
        jScrollPane1.setViewportView(localPeer);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("remotePeer");
        jPanel2.add(jLabel2, new java.awt.GridBagConstraints());

        remotePeer.setModel(new PairStatusTableModel(new ArrayList<CandidatePair>()));
        jScrollPane2.setViewportView(remotePeer);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jScrollPane2, gridBagConstraints);

        jSplitPane1.setRightComponent(jPanel2);

        getContentPane().add(jSplitPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IceNegociationProgressForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable localPeer;
    private javax.swing.JTable remotePeer;
    // End of variables declaration//GEN-END:variables

    public JTable getLocalPeer() {
        return localPeer;
    }

    public JTable getRemotePeer() {
        return remotePeer;
    }

}
