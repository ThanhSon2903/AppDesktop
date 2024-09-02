package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Tinh implements Serializable{
	private int maTinh;
	private String tenTinh;
	
	public int getMaTinh() {
		return maTinh;
	}
	
	public void setMaTinh(int maTinh) {
		this.maTinh = maTinh;
	}

	public String getTenTinh() {
		return tenTinh;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTinh, tenTinh);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tinh other = (Tinh) obj;
		return maTinh == other.maTinh && Objects.equals(tenTinh, other.tenTinh);
	}

	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}	
	
	public Tinh(int maTinh, String tenTinh) {
		super();
		this.maTinh = maTinh;
		this.tenTinh = tenTinh;
	}

	@Override
	public String toString() {
		return "Tinh [maTinh=" + maTinh + ", tenTinh=" + tenTinh + "]";
	}
	
	public static ArrayList<Tinh>getDSTinh(){
			String arr_Tinh[] = {"An Giang",
								"Ba Ria - Vung Tau",
								"Bac Lieu",
								"Bac Kan",
								"Bac Ninh",
								"Ben Tre",
								"Binh Duong",
								"Binh Dinh",
								"Binh Phuoc",
								"Binh Thuan",
								"Ca Mau",
								"Cao Bang",
								"Can Tho",
								"Da Nang",
								"Dak Lak",
								"Dak Nong",
								"Dien Bien",
								"Dong Nai",
								"Dong Thap",
								"Gia Lai",
								"Ha Giang",
								"Ha Nam",
								"Ha Noi",
								"Ha Tinh",
								"Hai Duong",
								"Hai Phong",
								"Hau Giang",
								"Hoa Binh",
								"Thanh Pho Ho Chi Minh",
								"Hung Yen",
								"Khanh Hoa",
								"Kien Giang",
								"Kon Tum",
								"Lai Chau",
								"Lang Son",
								"Lao Cai",
								"Lam Dong",
								"Long An",
								"Nam Dinh",
								"Nghe An",
								"Ninh Binh",
								"Ninh Thuan",
								"Phu Tho",
								"Phu Yen",
								"Quang Binh",
								"Quang Nam",
								"Quang Ngai",
								"Quang Ninh",
								"Quang Tri",
								"Soc Trang",
								"Son La",
								"Tay Ninh",
								"Thai Binh",
								"Thai Nguyen",
								"Thanh Hoa",
								"Thua Thien Hue",
								"Tien Giang",
								"Tra Vinh",
								"Tuyen Quang",
								"Vinh Long",
								"Vinh Phuc",
								"Yen Bai"};
			int cnt = 1;
			ArrayList<Tinh>res = new ArrayList<Tinh>();
			for(String tenTinh : arr_Tinh) {
				Tinh t = new Tinh(cnt,tenTinh);
				res.add(t);
				cnt++;
			}
			return res;
	}

	public static Tinh getTinhByID(int que) {
		return Tinh.getDSTinh().get(que);
	}

	public static Tinh getTinhByTen(String tenTinh) {
		ArrayList<Tinh>res = Tinh.getDSTinh();
		for(Tinh tinh : res) {
			if(tinh.tenTinh.equals(tenTinh)) {
				return tinh;
			}
		}
		return null;
	}
	
}
