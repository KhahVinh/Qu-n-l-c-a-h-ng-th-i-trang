package Views;

import Component.ReadWriteProduct;
import Models.MatHang;
import Models.Product;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class QLXH extends javax.swing.JPanel {

    ArrayList<Product> listSP = new ArrayList<>();

    String fileQLSP = "QuanLySanPham.txt";
    String fileMatHang = "MatHang.txt";

    DefaultTableModel model;
    ReadWriteProduct rwp = new ReadWriteProduct();
    DecimalFormat f = new DecimalFormat("###,###đ");

    public QLXH() {
        initComponents();
        getData();
    }

    public void getData() {
        try {
            rwp.readFile(fileQLSP, listSP);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Danh sách rỗng");
        }
        model = (DefaultTableModel) tableThongTin.getModel();

        for (Product i : listSP) {
            String listMatHang = i.getProductCategory();
            String tenMatHang = loaiSP(listMatHang);
            String giaBan = f.format(i.getProductPrice());
            Object rows[] = {i.getProductID(), i.getProductName(), tenMatHang, i.getProductQuantity(), giaBan};
            model.addRow(rows);
        }
    }

    public ArrayList<MatHang> readFromFile(String url) {
        ArrayList<MatHang> list = new ArrayList<MatHang>();
        try {
            FileReader fr = new FileReader(fileMatHang);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                list.add(new MatHang(txt[0], txt[1]));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            list = new ArrayList<MatHang>();
        }
        return list;
    }

    public String loaiSP(String category) {
        ArrayList<Models.MatHang> listMatHang = new ArrayList<>();
        listMatHang = readFromFile(fileMatHang);
        String categoryItem = "";
        for (MatHang matHang : listMatHang) {
            if (category.equalsIgnoreCase(matHang.getMa())) {
                categoryItem = matHang.getTen();
            }
        }
        return categoryItem;
    }

    public void totalPrice() {
        model = (DefaultTableModel) tableXuat.getModel();
        int total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                Number num = f.parse((String) model.getValueAt(i, 5));
                total = total + (Integer.parseInt(num.toString()) * Integer.parseInt(txtSoLuong.getText()));
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
        txtTotalPrice.setText(Integer.toString(total) + "đ");
    }

    public void totalPriceNew() {
        int total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                Number num = f.parse((String) model.getValueAt(i, 5));
                total = total + (Integer.parseInt(model.getValueAt(i, 4).toString()) * Integer.parseInt(num.toString()));
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
        txtTotalPrice.setText(Integer.toString(total) + "đ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableThongTin = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableXuat = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        btnXuat = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        titleMaKH = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        titleTenKH = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txtTimKiem = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 153, 153));
        setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("XUẤT HÀNG");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Thông Tin Sản Phẩm");

        tableThongTin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Loại", "Số lượng", "Giá bán"
            }
        ));
        tableThongTin.setRowHeight(25);
        jScrollPane1.setViewportView(tableThongTin);

        btnThem.setBackground(new java.awt.Color(0, 153, 51));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setLabel("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Xuất Hàng");

        tableXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Loại", "Số lương", "Giá bán"
            }
        ));
        tableXuat.setRowHeight(25);
        jScrollPane2.setViewportView(tableXuat);

        btnXoa.setBackground(new java.awt.Color(255, 0, 51));
        btnXoa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa sản phẩm");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 204, 0));
        btnSua.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa số lượng");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Tổng tiền:");

        txtTotalPrice.setBackground(new java.awt.Color(242, 242, 242));
        txtTotalPrice.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtTotalPrice.setForeground(new java.awt.Color(204, 0, 0));
        txtTotalPrice.setText("0đ");
        txtTotalPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        btnXuat.setBackground(new java.awt.Color(0, 153, 51));
        btnXuat.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnXuat.setText("Xuất hàng");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Số lượng");

        txtSoLuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoLuong.setText("1");

        titleMaKH.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        titleMaKH.setText("Tên khách hàng");

        txtMaKH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtMaKH.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        titleTenKH.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        titleTenKH.setText("Số điện thoại");

        txtTenKH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTenKH.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel6.setText("Địa chỉ");

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(titleMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(titleTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        txtTimKiem.setBackground(new java.awt.Color(153, 153, 153));
        txtTimKiem.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        txtTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        txtTimKiem.setText("Nhập tên sản phẩm cần tìm kiếm");
        txtTimKiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtTimKiem))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        TableModel model1 = tableThongTin.getModel();
        DefaultTableModel model2 = (DefaultTableModel) tableThongTin.getModel();
        int selectedRowIndex = tableThongTin.getSelectedRow();
        int[] indexs = tableThongTin.getSelectedRows();
        Object[] row = new Object[6];
        String soLuong = txtSoLuong.getText();
        model = (DefaultTableModel) tableXuat.getModel();
        for (int i = 0; i < indexs.length; i++) {
            row[0] = i + 1;
            row[1] = model1.getValueAt(indexs[i], 0);
            row[2] = model1.getValueAt(indexs[i], 1);
            row[3] = model1.getValueAt(indexs[i], 2);
            if (Integer.parseInt(soLuong) > Integer.parseInt(model1.getValueAt(indexs[i], 3).toString())) {
                JOptionPane.showMessageDialog(this, "Số lượng vượt mức hiện có", "Thông báo", JOptionPane.ERROR_MESSAGE);
                break;
            } else {
                row[4] = soLuong;
            }
            row[5] = model1.getValueAt(indexs[i], 4);
            model.addRow(row);
            model2.removeRow(selectedRowIndex);
        }
        totalPrice();
        totalPriceNew();
        txtSoLuong.setText("1");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            model = (DefaultTableModel) tableXuat.getModel();
            int selectedRowIndex = tableXuat.getSelectedRow();
            model.removeRow(selectedRowIndex);
            JOptionPane.showMessageDialog(this, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm cần xóa", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
        }
        totalPriceNew();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            model = (DefaultTableModel) tableXuat.getModel();

            int selectedRowIndex = tableXuat.getSelectedRow();

            String soLuong = model.getValueAt(selectedRowIndex, 4).toString();

            String newSoLuong = JOptionPane.showInputDialog(null, "Nhập lại số lượng", soLuong);

            StringBuilder sb = new StringBuilder();

            if (newSoLuong.trim().equals("")) {
                sb.append("Số lượng không được để trống\n");
            }
            if (newSoLuong.equals("0")) {
                sb.append("Số lượng phải lớn hơn 0\n");
            }
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this,
                        sb.toString(),
                        "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (Product product : listSP) {
                if (Integer.parseInt(newSoLuong) > 100) {
                    JOptionPane.showMessageDialog(this, "Số lượng vượt mức cho phép", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    break;
                } else {
                    model.setValueAt(newSoLuong, selectedRowIndex, 4);
                    JOptionPane.showMessageDialog(this, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm cần sửa", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        totalPriceNew();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        if (txtTimKiem.getText().equals("Nhập tên sản phẩm cần tìm kiếm")) {
            txtTimKiem.setText("");
            txtTimKiem.setForeground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusLost
        if (txtTimKiem.getText().equals("")) {
            txtTimKiem.setText("Nhập tên sản phẩm cần tìm kiếm");
            txtTimKiem.setForeground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtTimKiemFocusLost

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        model = (DefaultTableModel) tableThongTin.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(model);
        tableThongTin.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtTimKiem.getText(), 1));
    }//GEN-LAST:event_txtTimKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tableThongTin;
    private javax.swing.JTable tableXuat;
    private javax.swing.JLabel titleMaKH;
    private javax.swing.JLabel titleTenKH;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTotalPrice;
    // End of variables declaration//GEN-END:variables
}
