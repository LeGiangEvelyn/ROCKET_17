package com.vti.backend;



import com.vti.entity.Gender;
import com.vti.entity.Person;
import com.vti.entity.Student;
import java.util.Random;
import java.util.Scanner;

public class Exercise2 {
	private Student[] listStudent;
	private Random random;
	private Scanner sc;
	Person person;

	public static void main(String[] args) {
		Exercise2 e = new Exercise2();
		e.question1();
	}
	public Exercise2() {
		listStudent = new Student[10];
		random = new Random();
		sc = new Scanner(System.in);
		person = new Person();
	}


	/*Question 1: Interface Management
	Tạo 1 class Student gồm các property id, name, group(int)
	Tạo 1 interface IStudent bao gồm các method : điểmDanh(), họcBài(), đi dọn vệ sinh()
	Class Student sẽ implement interface như sau:
	Method điểm danh() sẽ in ra nội dung như sau:
	"Nguyễn Văn A điểm danh"
	"Nguyễn Văn B điểm danh"
	"Nguyễn Văn C điểm danh"
	….
	Method học Bài () sẽ in ra nội dung như sau:
	"Nguyễn Văn A đang học bài"
	"Nguyễn Văn B đang học bài "
	"Nguyễn Văn C đang học bài "
	…
	Tương tự với các method còn lại
	Hãy viết chương trình thực hiện các lệnh sau:
	a) Tạo 10 học sinh, chia thành 3 nhóm
	b) Kêu gọi cả lớp điểm danh.
	c) Gọi nhóm 1 đi học bài
	d) Gọi nhóm 2 đi dọn vệ sinh
	*/
	public void question1() {
		while (true) {
			System.out.println("=======================================================================");
			System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng===================");
			System.out.println("=== 1. Tạo danh sách sinh viên. ===");
			System.out.println("=== 2. Hiển thị ds sv trong lớp. ===");
			System.out.println("=== 3. Điểm danh lớp ===");
			System.out.println("=== 4. Gọi nhóm 1 đi học bài ===");
			System.out.println("=== 5. Gọi nhóm 2 đi dọn vệ sinh ===");
			System.out.println("=== 6. Exit. ===");
			System.out.println("=======================================================================");
			int menuChoose = sc.nextInt();
			switch (menuChoose) {
				case 1:
					initStudent();
					System.out.println("Tạo thành công 10 sinh viên.");
					break;
				case 2:
					for (Student student : listStudent) {
						System.out.println(student);
					}
					break;
				case 3:
					System.out.println("Cả lớp điểm danh: ");
					for (Student student : listStudent) {
						student.diemDanh();
					}
					break;
				case 4:
					System.out.println("Nhóm 1 đi học bài: ");
					for (Student student : listStudent) {
						if (student.getGroup() == 1) {
							student.hocBai();
						}
					}
					break;
				case 5:
					System.out.println("Nhóm 2 đi dọn vệ sinh: ");
					for (Student student : listStudent) {
						if (student.getGroup() == 2) {
							student.donVeSinh();
							;
						}
					}
					break;
				case 6:
					return;
				default:
					System.out.println("Alarm: Lựa chọn đúng số trên menu");
					break;
			}
		}
	}
	private void initStudent() {
		for (int i = 0; i < 10; i++) {
			Student st = new Student("Student " + (i + 1), random.nextInt(3)+1);
			listStudent[i] = st;
		}
	};

		/*Ques2: Tạo 1 class Person chứa các property sau: tên, giới tính, ngày sinh, địa chỉ với đầy đủ getter setter, constructor không tham số, constructor đầy đủ tham số
	a) Viết phương thức inputInfo(), nhập thông tin Person từ bàn phím
	b) Viết phương thức showInfo(), hiển thị tất cả thông tin Person
	3
	Tạo class Student thừa kế Person, lưu trữ các thông tin một sinh viên: Mã sinh viên, Điểm trung bình, Email
	a) Override phương thức inputInfo(), nhập thông tin Student từ bàn phím
	b) Override phương thức showInfo(), hiển thị tất cả thông tin Student
	c) Viết phương thức xét xem Student có được học bổng không? Điểm trung bình từ 8.0 trở lên là được học bổng */
	public void question2(){



		}

}