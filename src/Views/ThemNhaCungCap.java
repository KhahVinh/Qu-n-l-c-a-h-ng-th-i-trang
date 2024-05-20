
package Views;

import Models.NhaCungCap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class ThemNhaCungCap extends javax.swing.JFrame {
    private static final String FILE_NAME = "NhaCungCap.txt";
    private static ArrayList<NhaCungCap> list = new ArrayList<NhaCungCap>();
    
    public ThemNhaCungCap() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void showMessage(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "Cảnh báo nhập dữ liệu", JOptionPane.WARNING_MESSAGE);
    }
    
    private boolean checkInput() {
        boolean check = true;
        try {
            String ma = inputMaNCC.getText();
            String ten = inputTenNCC.getText();
            String dienThoai = inputSdtNCC.getText();
            System.out.println(dienThoai);
            String diaChi = inputDiaChiNCC.getText();
            if (ma.length() == 0) {
                showMessage("Không được để trống mã nhà cung cấp");
                check = false;
            }
            if (ten.length() == 0) {
                showMessage("Không được để trống tên nhà cung cấp");
                check = false;
            }
            if (dienThoai.length() == 0) {
                showMessage("Không được để trống số điện thoại");
                check = false;
            } else if (dienThoai.length() < 7 || dienThoai.length() > 11) {
                showMessage("Độ dài số điện thoại không hợp lệ");
                check = false;
            } else if (dienThoai.length() != 0) {
                Long sdt = Long.parseLong(inputSdtNCC.getText());
            }
            if (diaChi.length() == 0) {
                showMessage("Không được để trống địa chỉ");
                check = false;
            }
        } catch (NumberFormatException e) {
            showMessage("Số điện thoại không thể chứa kí tự");
            check = false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return check;
    }
    
    private void resetInput() {
        inputMaNCC.setText("");
        inputTenNCC.setText("");
        inputSdtNCC.setText("");
        inputDiaChiNCC.setText("");
    }
    
    private boolean listHasData() {
        if (this.list.size() != 0) {
            return true;
        } 
        return false;
    }
    
    private void getInfor() {
        if (checkInput()) {
            NhaCungCap newValue = new NhaCungCap(inputMaNCC.getText(), inputTenNCC.getText(), inputSdtNCC.getText(), inputDiaChiNCC.getText());
            list.add(newValue);
            resetInput();
            JOptionPane.showMessageDialog(null, "Đã thêm vào danh sách chờ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void handleAddData() {
        if (!listHasData()) {
            int rely = JOptionPane.showConfirmDialog(null, "Bạn chưa có dữ liệu trong danh sách chờ. Bạn muốn kết thúc chứ?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (rely == JOptionPane.YES_NO_OPTION) {
                this.dispose();
            }
        } else {
            try {
                FileWriter fw = new FileWriter(FILE_NAME, true);
                BufferedWriter bw = new BufferedWriter(fw);
                for (NhaCungCap i : list) {
                    bw.write(i.toString());
                    bw.newLine();
                }
                bw.close();
                fw.close();
                JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Thêm mới không thành công", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
            NhaCungCapView nccView = new NhaCungCapView();
            nccView.showListData();
            this.dispose();
        }
    }
    
    
    
    private void handleCancel() {
        if (listHasData()) {
            int rely = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm các nhà cung cấp trước đó không?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (rely == JOptionPane.YES_NO_OPTION) {
                handleAddData();
            } else {
                this.dispose();
            }
        } else {
            this.dispose();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        titleTab = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        inputMaNCC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inputTenNCC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputSdtNCC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputDiaChiNCC = new javax.swing.JTextField();
        btnHuy = new javax.swing.JButton();
        btnThemMoi = new javax.swing.JButton();
        btnHoanThanh = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thêm mới nhà cung cấp");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(700, 400));
        setMinimumSize(new java.awt.Dimension(700, 400));
        setPreferredSize(new java.awt.Dimension(700, 400));
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setLayout(new java.awt.CardLayout(20, 20));

        titleTab.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleTab.setForeground(new java.awt.Color(255, 255, 255));
        titleTab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleTab.setText("THÊM NHÀ CUNG CẤP");
        jPanel2.add(titleTab, "card2");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Mã nhà cung cấp:");

        inputMaNCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputMaNCCFocusLost(evt);
            }
        });
        inputMaNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inputMaNCCMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inputMaNCCMouseReleased(evt);
            }
        });

        jLabel3.setText("Tên nhà cung cấp:");

        inputTenNCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputTenNCCFocusLost(evt);
            }
        });

        jLabel4.setText("Số điện thoại:");

        inputSdtNCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputSdtNCCFocusLost(evt);
            }
        });

        jLabel5.setText("Địa chỉ:");

        inputDiaChiNCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputDiaChiNCCFocusLost(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(225, 47, 64));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy");
        btnHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnThemMoi.setBackground(new java.awt.Color(75, 174, 79));
        btnThemMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnThemMoi.setText("Thêm mới");
        btnThemMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnHoanThanh.setBackground(new java.awt.Color(51, 153, 255));
        btnHoanThanh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHoanThanh.setForeground(new java.awt.Color(255, 255, 255));
        btnHoanThanh.setText("Hoàn thành");
        btnHoanThanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanThanhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputMaNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(inputTenNCC)
                            .addComponent(inputSdtNCC)
                            .addComponent(inputDiaChiNCC)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(btnHuy)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHoanThanh)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputSdtNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputDiaChiNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        handleCancel();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        getInfor();
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnHoanThanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanThanhActionPerformed
        handleAddData();
    }//GEN-LAST:event_btnHoanThanhActionPerformed

    private void inputMaNCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputMaNCCMouseExited
    }//GEN-LAST:event_inputMaNCCMouseExited

    private void inputMaNCCMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputMaNCCMouseReleased
    }//GEN-LAST:event_inputMaNCCMouseReleased

    private void inputMaNCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputMaNCCFocusLost
        inputMaNCC.setText(inputMaNCC.getText().trim());
    }//GEN-LAST:event_inputMaNCCFocusLost

    private void inputTenNCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTenNCCFocusLost
        inputTenNCC.setText(inputTenNCC.getText().trim());
    }//GEN-LAST:event_inputTenNCCFocusLost

    private void inputSdtNCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputSdtNCCFocusLost
        inputSdtNCC.setText(inputSdtNCC.getText().trim());
    }//GEN-LAST:event_inputSdtNCCFocusLost

    private void inputDiaChiNCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputDiaChiNCCFocusLost
        inputDiaChiNCC.setText(inputDiaChiNCC.getText().trim());
    }//GEN-LAST:event_inputDiaChiNCCFocusLost

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowLostFocus


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHoanThanh;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JTextField inputDiaChiNCC;
    private javax.swing.JTextField inputMaNCC;
    private javax.swing.JTextField inputSdtNCC;
    private javax.swing.JTextField inputTenNCC;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel titleTab;
    // End of variables declaration//GEN-END:variables
}
