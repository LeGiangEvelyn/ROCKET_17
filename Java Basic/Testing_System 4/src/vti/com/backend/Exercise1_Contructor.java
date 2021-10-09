package vti.com.backend;
import vti.com.entity.Department;

public class Exercise1_Contructor {
	public static void main(String[] args) {
		/* Question 1:
	Tạo constructor cho department:
	a) không có parameters
	b) Có 1 parameter là nameDepartment và default id của Department = 0
	Khởi tạo 1 Object với mỗi constructor ở trên */
		Department department1 = new Department();
		Department department2 = new Department("Lam");
		System.out.println(department2.getId() + " " + department2.getName());
		System.out.println(department1.getId() + " "+ department1.getName());
		
			/* Question 1:
	Tạo Object Student có các property id, name, hometown, điểm học lực
	a) Tất cả các property sẽ để là private để các class khác không chỉnh sửa hay nhìn thấy
	b) Tạo constructor cho phép khi khởi tạo mỗi student thì người dùng sẽ nhập vào tên, hometown và có điểm học lực = 0
	c) Tạo 1 method cho phép set điểm vào
	d) Tạo 1 method cho phép cộng thêm điểm
	e) Tạo 1 method để in ra thông tin của sinh viên bao gồm có tên, điểm học lực ( nếu điểm <4.0 thì sẽ in ra là Yếu, nếu điểm > 4.0 và < 6.0 thì sẽ in ra là trung bình, nếu điểm > 6.0 và < 8.0 thì sẽ in ra là khá, nếu > 8.0 thì in ra là Giỏi)
	Demo các chức năng trên bằng class ở front-end. */
		
			/*Question 1: inheritance
	Một đơn vị sản xuất gồm có các cán bộ là công nhân, kỹ sư, nhân viên. Mỗi cán bộ cần quản lý các dữ liệu: Họ tên, tuổi, giới tính(name, nữ, khác), địa chỉ.
	Cấp công nhân sẽ có thêm các thuộc tính riêng: Bậc (1 đến 10).
	Cấp kỹ sư có thuộc tính riêng: Nghành đào tạo.
	Các nhân viên có thuộc tính riêng: công việc.
	Hãy xây dựng các lớp CongNhan, KySu, NhanVien kế thừa từ lớp CanBo. */
	}
}
