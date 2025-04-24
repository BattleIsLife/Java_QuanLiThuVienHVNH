package controller;
import java.util.ArrayList;
import service.NhanVienService;
import controller.BaseController;
import model.Nhanvien;
public class NhanVienController implements BaseController
{
	 private NhanVienService userService = new NhanVienService();
	@Override
	public int Them(Object t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Sua(Object t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Xoa(Object t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object selectById(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean Login(String u,String p) {
		Nhanvien user= userService.findByCredentials(u, p);
		if(user !=null) {
			return true;
		}
		return false;
		
	}
	
	

}
