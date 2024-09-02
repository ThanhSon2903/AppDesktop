package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controller.QLSVcontroller;
import Model.QLSVmodel;
import Model.ThiSinh;
import Model.Tinh;

import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class QLSVview extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTable table;
	public JTextField textField_maSV;
	public JTextField textField_ID;
	public JTextField textField_name;
	public JTextField textField_date;
	public JTextField textField_mon1;
	public JTextField textField_mon2;
	public JTextField textField_mon3;
	public QLSVmodel model;
	public JComboBox<String> comboBox;
	public ButtonGroup btn_gioiTinh;
	public JRadioButton radioButton_Nam;
	public JRadioButton radioButton_Nu;
	public JComboBox comboBox_Tìm_kiếm_quê_quán;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QLSVview frame = new QLSVview();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public QLSVview() {
		this.setTitle("Project Java");
		this.model = new QLSVmodel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 684);
		ActionListener actionListener = new QLSVcontroller(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 99, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_file = new JMenu("File");
		mnNewMenu_file.addActionListener(actionListener);
		mnNewMenu_file.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnNewMenu_file);
		
		JMenuItem mntmNewMenuItem_open = new JMenuItem("Open");
		mntmNewMenuItem_open.addActionListener(actionListener);
		mntmNewMenuItem_open.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnNewMenu_file.add(mntmNewMenuItem_open);
		
		JMenuItem mntmNewMenuItem_Save = new JMenuItem("Save");
		mntmNewMenuItem_Save.addActionListener(actionListener);
		mntmNewMenuItem_Save.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnNewMenu_file.add(mntmNewMenuItem_Save);
		
		JSeparator separator = new JSeparator();
		mnNewMenu_file.add(separator);
		
		JMenuItem mntmNewMenuItem_exit = new JMenuItem("Exit");
		mntmNewMenuItem_exit.addActionListener(actionListener);
		mntmNewMenuItem_exit.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnNewMenu_file.add(mntmNewMenuItem_exit);
		
		JMenu mnNewMenu_About = new JMenu("About");
		mnNewMenu_About.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnNewMenu_About);
		
		JMenuItem mntmNewMenuItem_About_me = new JMenuItem("About me");
		mntmNewMenuItem_About_me.addActionListener(actionListener);
		mntmNewMenuItem_About_me.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnNewMenu_About.add(mntmNewMenuItem_About_me);
		
		JLabel lblNewLabel_quê_quán = new JLabel("Quê quán");
		lblNewLabel_quê_quán.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_quê_quán.setBounds(20, 26, 79, 63);
		contentPane.add(lblNewLabel_quê_quán);
		
		comboBox_Tìm_kiếm_quê_quán = new JComboBox();
		ArrayList<Tinh>listTinh = Tinh.getDSTinh();
		comboBox_Tìm_kiếm_quê_quán.addItem("");
		for(Tinh tinh : listTinh) {
			comboBox_Tìm_kiếm_quê_quán.addItem(tinh.getTenTinh());
		}
		comboBox_Tìm_kiếm_quê_quán.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_Tìm_kiếm_quê_quán.setBounds(93, 46, 99, 22);
		contentPane.add(comboBox_Tìm_kiếm_quê_quán);
		
		JLabel lblNewLabel_maSV = new JLabel("Mã sinh viên");
		lblNewLabel_maSV.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_maSV.setBounds(228, 26, 104, 63);
		contentPane.add(lblNewLabel_maSV);
		
		JButton btnNewButton_tìm_kiếm = new JButton("Tìm kiếm");
		btnNewButton_tìm_kiếm.addActionListener(actionListener);
		btnNewButton_tìm_kiếm.setBounds(435, 47, 89, 23);
		contentPane.add(btnNewButton_tìm_kiếm);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 87, 624, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_danh_sách_thí_sinh = new JLabel("Danh sách thí sinh");
		lblNewLabel_danh_sách_thí_sinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_danh_sách_thí_sinh.setBounds(20, 72, 136, 63);
		contentPane.add(lblNewLabel_danh_sách_thí_sinh);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m m\u00F4n 1", "\u0110i\u1EC3m m\u00F4n 2",
				"\u0110i\u1EC3m m\u00F4n 3"
			}
		));
		table.setRowHeight(30);
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(10, 115, 624,190);
		contentPane.add(scrollPane_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 330, 624, 2);
		contentPane.add(separator_1_1);
		
		JLabel lblNewLabel_thông_tin_thí_sinh_1 = new JLabel("Thông tin thí sinh");
		lblNewLabel_thông_tin_thí_sinh_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_thông_tin_thí_sinh_1.setBounds(20, 316, 128, 63);
		contentPane.add(lblNewLabel_thông_tin_thí_sinh_1);
		
		JLabel lblNewLabel_thông_tin_thí_sinh_1_1 = new JLabel("Mã thí sinh");
		lblNewLabel_thông_tin_thí_sinh_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_thông_tin_thí_sinh_1_1.setBounds(20, 361, 128, 63);
		contentPane.add(lblNewLabel_thông_tin_thí_sinh_1_1);
		
		textField_maSV = new JTextField();
		textField_maSV.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_maSV.setBounds(321, 46, 104, 22);
		contentPane.add(textField_maSV);
		textField_maSV.setColumns(10);
		
		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_ID.setColumns(10);
		textField_ID.setBounds(107, 383, 136, 22);
		contentPane.add(textField_ID);
		
		JLabel lblNewLabel_maSV_1 = new JLabel("Họ tên");
		lblNewLabel_maSV_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_maSV_1.setBounds(20, 414, 104, 63);
		contentPane.add(lblNewLabel_maSV_1);
		
		textField_name = new JTextField();
		textField_name.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_name.setColumns(10);
		textField_name.setBounds(107, 435, 136, 22);
		contentPane.add(textField_name);
		
		JLabel lblNewLabel_maSV_2 = new JLabel("Quê quán\r\n");
		lblNewLabel_maSV_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_maSV_2.setBounds(20, 466, 104, 63);
		contentPane.add(lblNewLabel_maSV_2);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.addItem("");
		for(Tinh t : listTinh) {
			comboBox.addItem(t.getTenTinh());
		}
		comboBox.setBounds(107, 488, 136, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_maSV_2_1 = new JLabel("Ngày sinh");
		lblNewLabel_maSV_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_maSV_2_1.setBounds(20, 521, 104, 63);
		contentPane.add(lblNewLabel_maSV_2_1);
		
		textField_date = new JTextField();
		textField_date.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_date.setColumns(10);
		textField_date.setBounds(107, 543, 136, 22);
		contentPane.add(textField_date);
		
		JLabel lblNewLabel_chọn_giới_tính = new JLabel("Giới tính");
		lblNewLabel_chọn_giới_tính.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_chọn_giới_tính.setBounds(317, 361, 128, 63);
		contentPane.add(lblNewLabel_chọn_giới_tính);
		
		radioButton_Nam = new JRadioButton("Nam\r\n");
		radioButton_Nam.setFont(new Font("Tahoma", Font.BOLD, 10));
		radioButton_Nam.setBounds(408, 382, 89, 23);
		contentPane.add(radioButton_Nam);
		
		radioButton_Nu = new JRadioButton("Nữ");
		radioButton_Nu.setFont(new Font("Tahoma", Font.BOLD, 10));
		radioButton_Nu.setBounds(494, 382, 71, 23);
		contentPane.add(radioButton_Nu);
		
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(radioButton_Nam);
		btn_gioiTinh.add(radioButton_Nu);
		JLabel lblNewLabel_môn1 = new JLabel("Môn 1");
		lblNewLabel_môn1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_môn1.setBounds(317, 414, 128, 63);;
		contentPane.add(lblNewLabel_môn1);
		
		textField_mon1 = new JTextField();
		textField_mon1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_mon1.setColumns(10);
		textField_mon1.setBounds(408, 436, 71, 20);
		contentPane.add(textField_mon1);
		
		JLabel lblNewLabel_môn2 = new JLabel("Môn 2\r\n");
		lblNewLabel_môn2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_môn2.setBounds(317, 466, 128, 63);
		contentPane.add(lblNewLabel_môn2);
		
		textField_mon2 = new JTextField();
		textField_mon2.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_mon2.setColumns(10);
		textField_mon2.setBounds(408, 488, 71, 20);
		contentPane.add(textField_mon2);
		
		JLabel lblNewLabel_môn_3 = new JLabel("Môn 3");
		lblNewLabel_môn_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_môn_3.setBounds(317, 521, 128, 63);
		contentPane.add(lblNewLabel_môn_3);
		
		textField_mon3 = new JTextField();
		textField_mon3.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_mon3.setColumns(10);
		textField_mon3.setBounds(408, 543, 71, 20);
		contentPane.add(textField_mon3);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 582, 624, 2);
		contentPane.add(separator_1_1_1);
		
		JButton btnNewButton_thêm = new JButton("Thêm");
		btnNewButton_thêm.addActionListener(actionListener);
		btnNewButton_thêm.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_thêm.setBounds(20, 595, 89, 54);
		contentPane.add(btnNewButton_thêm);
		
		JButton btnNewButton_xóa = new JButton("Xóa");
		btnNewButton_xóa.addActionListener(actionListener);
		btnNewButton_xóa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_xóa.setBounds(154, 595, 89, 54);
		contentPane.add(btnNewButton_xóa);
		
		JButton btnNewButton_cập_nhật = new JButton("Cập nhật");
		btnNewButton_cập_nhật.addActionListener(actionListener);
		btnNewButton_cập_nhật.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_cập_nhật.setBounds(281, 595, 89, 54);
		contentPane.add(btnNewButton_cập_nhật);
		
		JButton btnNewButton_lưu = new JButton("Lưu");
		btnNewButton_lưu.addActionListener(actionListener);
		btnNewButton_lưu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_lưu.setBounds(408, 595, 89, 54);
		contentPane.add(btnNewButton_lưu);
		
		JButton btnNewButton_hủy_bỏ = new JButton("Hủy bỏ");
		btnNewButton_hủy_bỏ.addActionListener(actionListener);
		btnNewButton_hủy_bỏ.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_hủy_bỏ.setBounds(529, 595, 89, 54);
		contentPane.add(btnNewButton_hủy_bỏ);
		
		JButton btnNewButton_tìm_kiếm_1 = new JButton("Huỷ tìm");
		btnNewButton_tìm_kiếm_1.addActionListener(actionListener);
		btnNewButton_tìm_kiếm_1.setBounds(534, 47, 89, 23);
		contentPane.add(btnNewButton_tìm_kiếm_1);
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_ID.setText("");
		textField_name.setText("");
		textField_date.setText("");
		textField_mon1.setText("");
		textField_mon2.setText("");
		textField_mon3.setText("");
		comboBox.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}
	
	protected void them1SinhVienVaoTable(ThiSinh new_Thi_Sinh) {
		DefaultTableModel dtm_table = (DefaultTableModel)table.getModel();
		dtm_table.addRow(new Object[] {new_Thi_Sinh.getMaThiSinh()+"",
				new_Thi_Sinh.getTenThiSinh(),
				new_Thi_Sinh.getQueQuan().getTenTinh(),
				new_Thi_Sinh.getNgaySinh().getDate()+"/"+(new_Thi_Sinh.getNgaySinh().getMonth()+1)+"/"+(new_Thi_Sinh.getNgaySinh().getYear()+1900),
				new_Thi_Sinh.isGioiTinh()?"Nam":"Nữ",
				new_Thi_Sinh.getDiemMon1()+"",
				new_Thi_Sinh.getDiemMon2()+"",
				new_Thi_Sinh.getDiemMon3()+""});
	}
	
	@SuppressWarnings({ "deprecation", "unused" })
	public void themSinhVienHoacCapNhat(ThiSinh new_Thi_Sinh) {
		DefaultTableModel dtm_table = (DefaultTableModel)table.getModel();
		if(!this.model.kiemTraTonTai(new_Thi_Sinh)) {//Kiem tra khong ton tai thi them
			this.model.insert(new_Thi_Sinh);
			this.them1SinhVienVaoTable(new_Thi_Sinh);
		}
		else {//Neu co thi cap nhat
			this.model.update(new_Thi_Sinh);
			int soLuongDong = dtm_table.getRowCount();
			for(int i=0;i<soLuongDong;++i) {
				String fix_Id = dtm_table.getValueAt(i,0) + "";
				if(fix_Id == new_Thi_Sinh.getMaThiSinh()+"") {//Tim thay dong trung voi ID thi sinh
					dtm_table.setValueAt(new_Thi_Sinh.getMaThiSinh() + "",i,0);
					dtm_table.setValueAt(new_Thi_Sinh.getTenThiSinh() +"",i,1);
					dtm_table.setValueAt(new_Thi_Sinh.getQueQuan().getTenTinh() + "",i,2);
					dtm_table.setValueAt(new_Thi_Sinh.getNgaySinh().getDate()+"/"+(new_Thi_Sinh.getNgaySinh().getMonth()+1)+"/"+(new_Thi_Sinh.getNgaySinh().getYear()+1900),i,3);
					dtm_table.setValueAt(new_Thi_Sinh.isGioiTinh()?"Nam":"Nữ",i,4);
					dtm_table.setValueAt(new_Thi_Sinh.getDiemMon1()+"",i,5);
					dtm_table.setValueAt(new_Thi_Sinh.getDiemMon2()+"",i,6);
					dtm_table.setValueAt(new_Thi_Sinh.getDiemMon3()+"",i,7);
					
				}
			}
		}
	}
	
	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel dtm_table = (DefaultTableModel)table.getModel();
		int i_row = table.getSelectedRow();
		int maThiSinh = Integer.valueOf(dtm_table.getValueAt(i_row,0) + "");
		String name = dtm_table.getValueAt(i_row, 1) + "";
		Tinh t = Tinh.getTinhByTen(dtm_table.getValueAt(i_row, 2) + "");
		String d = dtm_table.getValueAt(i_row, 3) + "";
		Date date = new Date(d);
		String textGioiTinh = dtm_table.getValueAt(i_row, 4) + "";
		boolean sex = textGioiTinh.equals("Nam"); 
		float diem_mon_1 = Float.valueOf(dtm_table.getValueAt(i_row, 5) + "");
		float diem_mon_2 = Float.valueOf(dtm_table.getValueAt(i_row, 6) + "");
		float diem_mon_3 = Float.valueOf(dtm_table.getValueAt(i_row, 7) + "");
		ThiSinh ts = new ThiSinh(maThiSinh, name, t, date, sex, diem_mon_1, diem_mon_2, diem_mon_3);
		return ts;
	}
	
	
	public void hienThiThongTinThiSinhDaChon() {
		ThiSinh ts = getThiSinhDangChon();
			
		this.textField_ID.setText(ts.getMaThiSinh()+"");
		this.textField_name.setText(ts.getTenThiSinh()+"");
		this.comboBox.setSelectedItem(ts.getQueQuan().getTenTinh());
		String s_ngaySinh = ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900);
		this.textField_date.setText(s_ngaySinh+"");
//		this.btn_gioiTinh.setSelected(null, sex);
		if(ts.isGioiTinh()) {
			radioButton_Nu.setSelected(true);
		}
		else {
			radioButton_Nam.setSelected(true);
		}
		this.textField_mon1.setText(ts.getDiemMon1() + "");
		this.textField_mon2.setText(ts.getDiemMon2() + "");
		this.textField_mon3.setText(ts.getDiemMon3() + "");
	}

	public void thucHienXoa() {
		DefaultTableModel dtm_table = (DefaultTableModel)table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn xoá dòng đang chọn hay không?");
		if(luaChon==JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDangChon();
			this.model.delete(ts);
			dtm_table.removeRow(i_row);
		}
	}

	@SuppressWarnings("deprecation")
	public void thucHienThem() {
		int maThiSinh = Integer.valueOf(this.textField_ID.getText()+"");
		String name = this.textField_name.getText()+"";
		int queQuan = this.comboBox.getSelectedIndex()-1;
		Tinh tinh = Tinh.getTinhByID(queQuan);
		Date ngaySinh = new Date(this.textField_date.getText());
		boolean gioiTinh = true;
		if(this.radioButton_Nam.isSelected()) {
			gioiTinh = true;
		}
		else if(this.radioButton_Nu.isSelected()){
			gioiTinh = false;
		}	
		float diemMon1 = Float.valueOf(this.textField_mon1.getText()+"");
		float diemMon2 = Float.valueOf(this.textField_mon2.getText()+"");
		float diemMon3 = Float.valueOf(this.textField_mon3.getText()+"");
		
		
		ThiSinh ts = new ThiSinh(maThiSinh, name, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		this.themSinhVienHoacCapNhat(ts);
	}
	
	
	
	public void thucHienHuyTim() {
		while(true) {
			DefaultTableModel dtm_table = (DefaultTableModel)table.getModel();
			int soLuongDong = dtm_table.getRowCount();
			if(soLuongDong==0) {
				break;
			}
			else {
				try {
					dtm_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		for(ThiSinh ts : this.model.getDsThiSinh()) {
			this.them1SinhVienVaoTable(ts);
		}
		
	}

	public void thucHienTimKiem() {
		
		//Goi ham huy tim kiem
		thucHienHuyTim();
		
		//Thuc hien ham tiem kiem
		DefaultTableModel dtm_table = (DefaultTableModel)table.getModel();
		int queQuan = this.comboBox_Tìm_kiếm_quê_quán.getSelectedIndex() - 1;
		int soLuongDong = dtm_table.getRowCount();
		String maThiSinh = this.textField_maSV.getText();
		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
		if(queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhByID(queQuan);
			for(int i=0;i<soLuongDong;i++) {
				String tenTinh = dtm_table.getValueAt(i,2) + "";
				String id = dtm_table.getValueAt(i,0) + "";
				if(!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if(maThiSinh.length() > 0) {
			for(int i=0;i<soLuongDong;i++) {
				String id = dtm_table.getValueAt(i,0) + "";
				if(!id.equals(maThiSinh)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for(Integer idCanXoa : idCuaThiSinhCanXoa) {
			System.out.println(idCanXoa);
			soLuongDong = dtm_table.getRowCount();
			for(int i=0;i<soLuongDong;i++) {
				String idTrongTable = dtm_table.getValueAt(i,0) + "";
				if(idTrongTable.equals(idCanXoa.toString())) {
					try {
						dtm_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this,"Phần mềm quản lý thí sinh 1.0!");
	}

	public void thoatKhoiChuongTrinh() {
		int lc = JOptionPane.showConfirmDialog(
				this,
				"Ban co chac muon thoat khoi chuong trinh khong?",
				"Exit",
				JOptionPane.YES_OPTION);
		if(lc==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}

	@SuppressWarnings("unused")
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void thucHienSave() {
		if(this.model.getTenFile().length()>=1) {
			saveFile(this.model.getTenFile());
		}
		else {
			JFileChooser fc = new JFileChooser();
			int rVal = fc.showSaveDialog(this);
			if(rVal==JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
		
	}

	
	public void openFile(File file) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while((ts=(ThiSinh) ois.readObject())!=null) {
				ds.add(ts);	
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinh(ds);
	}
	
	public void thucHienOpen() {
		JFileChooser fc = new JFileChooser();
		int rVal = fc.showOpenDialog(this);
		if(rVal==JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienHuyTim();
		}
	}
}
