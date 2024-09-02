package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import Model.ThiSinh;
import Model.Tinh;
import View.QLSVview;

public class QLSVcontroller implements ActionListener{
	public QLSVview view;
	public QLSVcontroller(QLSVview view) {
		this.view = view;
	}
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		JOptionPane.showMessageDialog(view,"Bạn vừa nhấn vào: " + action);
		if(action.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm");
		}
		else if(action.equals("Lưu")) {
			try {
				this.view.thucHienThem();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		else if(action.equals("Cập nhật")) {
			this.view.hienThiThongTinThiSinhDaChon();
		}
		else if(action.equals("Xoá")) {
			this.view.thucHienXoa();
		}
		else if(action.equals("Huỷ bỏ")) {
			this.view.xoaForm();
		}
		else if(action.equals("Tìm kiếm")) {
			this.view.thucHienTimKiem();
		}
		else if(action.equals("Huỷ tìm")) {
			this.view.thucHienHuyTim();
		}
		else if(action.equals("About me")) {
			this.view.hienThiAbout();
		}
		else if(action.equals("Exit")) {
			this.view.thoatKhoiChuongTrinh();
		}
		else if(action.equals("Save")) {
			this.view.thucHienSave();
		}
		else if(action.equals("Open")) {
			this.view.thucHienOpen();
		}
	}

}
