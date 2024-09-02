package Model;

import java.util.ArrayList;
import java.util.Objects;

public class QLSVmodel {
	public ArrayList<ThiSinh>dsThiSinh;
	private String luaChon,tenFile;
	public QLSVmodel() {
		this.dsThiSinh = new ArrayList<ThiSinh>();
		this.luaChon = "";
		this.tenFile = "";
	}
	public ArrayList<ThiSinh> getDsThiSinh() {
		return dsThiSinh;
	}
	public String getTenFile() {
		return tenFile;
	}
	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}
	
	public void insert(ThiSinh ts) {
		this.dsThiSinh.add(ts);
	}
	
	public void delete(ThiSinh ts) {
		this.dsThiSinh.remove(ts);
	}
	
	public void update(ThiSinh ts) {
		this.dsThiSinh.remove(ts);
		this.dsThiSinh.add(ts);
	}
	public String getLuaChon() {
		return luaChon;
	}
	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}
	public boolean kiemTraTonTai(ThiSinh new_Thi_Sinh) {
		for(ThiSinh ts : dsThiSinh) {
			if(ts.getMaThiSinh() == new_Thi_Sinh.getMaThiSinh()) {
				return true;
			}
		}
		return false;
	}
	
	
}
