package algoritmokaratsuba;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Principal extends javax.swing.JFrame {

       
    public Principal() {
        initComponents();
    }
    
    private static final int Break = 1536;
    
    @SuppressWarnings("unchecked")
    
    public void ValidarLetras(JTextField a)
    {
        a.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent evt)
        {   
            char c;        
            c=evt.getKeyChar();
            if(!Character.isDigit(c))
            evt.consume();
        }
        });
    }
    public void ValidarForm(JTextField a, JTextField b)
    {
        String mensaje= "Uno de los campos se encuentra vacio";
        if(a.getText().equals("") || b.getText().equals("") )
        {JOptionPane.showMessageDialog(null, mensaje, "advertencia",JOptionPane.WARNING_MESSAGE);
        }
        else
        this.BtnCalcular.setEnabled(true);
    }
    
    public BigInteger karatsuba(BigInteger x, BigInteger y) {
		if (x.bitLength() <= Break || y.bitLength() <= Break) {  
			return x.multiply(y);
                } else {
			int n = Math.max(x.bitLength(), y.bitLength());
			int half = (n + 32) / 64 * 32;  
			BigInteger mask = BigInteger.ONE.shiftLeft(half).subtract(BigInteger.ONE);
			BigInteger xlow = x.and(mask);
			BigInteger ylow = y.and(mask);
			BigInteger xhigh = x.shiftRight(half);
			BigInteger yhigh = y.shiftRight(half);
			
			BigInteger a = karatsuba(xhigh, yhigh);
			BigInteger b = karatsuba(xlow.add(xhigh), ylow.add(yhigh));
			BigInteger c = karatsuba(xlow, ylow);
			BigInteger d = b.subtract(a).subtract(c);
			return a.shiftLeft(half).add(d).shiftLeft(half).add(c);
		}
	}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Txtnum1 = new javax.swing.JTextField();
        Txtnum2 = new javax.swing.JTextField();
        BtnCalcular = new javax.swing.JButton();
        Lblmostrar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BtnBorrar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Txtnum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txtnum1ActionPerformed(evt);
            }
        });
        Txtnum1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Txtnum1KeyPressed(evt);
            }
        });

        BtnCalcular.setText("Calcular");
        BtnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCalcularActionPerformed(evt);
            }
        });

        Lblmostrar.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Algoritmo Karatsuba");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel3.setText("By: Aldair Romario Enrique Garcia Conde");

        BtnBorrar.setText("Borrar");
        BtnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 55, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(73, 73, 73))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BtnCalcular)
                                    .addComponent(Txtnum1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Txtnum2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnBorrar))
                                .addGap(63, 63, 63))))
                    .addComponent(Lblmostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txtnum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txtnum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCalcular)
                    .addComponent(BtnBorrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Lblmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Txtnum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txtnum1ActionPerformed
       
    }//GEN-LAST:event_Txtnum1ActionPerformed

    private void BtnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCalcularActionPerformed
      Principal objP = new Principal();
      ValidarForm(Txtnum1, Txtnum2);
      BigInteger r;
      BigInteger a =  new BigInteger(this.Txtnum1.getText());
      BigInteger b =  new BigInteger(this.Txtnum2.getText());
      r =objP.karatsuba(a,b);  
      this.Lblmostrar.setText(""+r);
    }//GEN-LAST:event_BtnCalcularActionPerformed

      
    private void Txtnum1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txtnum1KeyPressed
      ValidarLetras(Txtnum1);
      ValidarLetras(Txtnum2);  
    }//GEN-LAST:event_Txtnum1KeyPressed

    private void BtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBorrarActionPerformed
      this.Txtnum1.setText("");
      this.Txtnum2.setText("");
      this.Lblmostrar.setText("");
    }//GEN-LAST:event_BtnBorrarActionPerformed

       public static void main(String args[]) {
 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBorrar;
    private javax.swing.JButton BtnCalcular;
    private javax.swing.JLabel Lblmostrar;
    private javax.swing.JTextField Txtnum1;
    private javax.swing.JTextField Txtnum2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
