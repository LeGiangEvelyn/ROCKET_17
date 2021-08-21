import java.util.Scanner;

public class Exercise1 {
	public static void main(String[] args) {
		//question1();
		//question2();
		//question3();
		question6();
	}

	
	

	/*Question 1:
Viết chương trình nhập vào một số thực. Đơn vị tính cho số này là centimet (cm).
Hãy in ra số tương đương tính bằng foot (số thực, có 2 số lẻ thập phân) và inch (số thực, có 2 số lẻ thập phân).
Với 1 inch = 2.54 cm và 1 foot = 12 inches. */
	public static void question1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao 1 so thuc: (cm) ");
		double input = sc.nextDouble();
		System.out.printf("%f cm =  %.2f foot", input, input*12*2.54);
		System.out.printf("%f cm =  %.2f inch", input, input*2.54);
	}
	
	/*Question 2:
Viết chương trình nhập vào số giây từ 0 tới 68399, đổi số giây này thành dạng [giờ:phút:giây], mỗi thành phần là một số nguyên có 2 chữ số.
Ví dụ: 02:11:05 */

	public static void question2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao so giay:(< 68399)  ");
		 int input = sc.nextInt();
		 int gio = input/3600;
		 int phut = (input%3600) /60;
		 int giay = input - gio*3600 - phut * 60; 
		System.out.printf("%dgio:%dphut:%dgiay", gio, phut, giay);
	}

/*
Question 3:
Viết chương trình nhập vào 4 số nguyên.
Hiển thị ra số lớn nhất và nhỏ nhất
Ví dụ:
nhập vào 4 số 1,2,3,4 thì kết quả là:
Số lớn nhất là: 4
Số nhỏ nhất là: 1 */
	public static void question3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao 4 so nguyen: ");
		int[] input = new int[4];
		for (int i=0; i<4; i++) {
			input[i] = sc.nextInt();
		}
		int max = input[1]; int min = input[3];
		for (int i=0; i<4; i++) {
			if (input[i] >= max) {
				max = input[i];
			}
			if (input[i] <= min) {
				min = input[i];
			}
		}
		System.out.println("So lon nhat la: "+ max);
		System.out.println("So nho nhat la: "+ min);
		
	}

/*
Question 6:
Xếp loại sinh viên theo các qui luật dưới đây:
Nếu điểm >= 9.0 - Loại xuất sắc
Nếu 8.0<= điểm < 9.0 - Loại giỏi
Nếu 7.0<= điểm < 8.0 - Loại khá
2
Nếu 6.0 <= điểm < 7.0 - Loại trung bình khá
Nếu 5.0 <= điểm < 6.0 - Loại trung bình
Nếu điểm < 5.0 - Loại kém
Với điểm = ( (điểm toán)*2 + điểm lý + điểm hóa )/4
Viết Chương trình:
a. Nhập vào điểm 3 môn học
b. Tính điểm trung bình
c. Xác định học lực của học sinh dựa trên điểm trung bình
d. Hiển thị học lực của học sinh */
	public static void question6() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Nhap vao diem Toan, Ly, Hoa: ");
	float[] input = new float[3];
	for (int i=0; i<3; i++) {
		input[i] = sc.nextFloat();
	}
	double tb = (input[0] *2 + input[1]+input[2])/4;
	System.out.println(tb);
	if (tb <5.0) {
		System.out.println("Loai Kem");
	} else if (tb <6.0 && tb>=5.0) {
		System.out.println("Loai Trung Binh ");
	} else if (tb<7.0 && tb >=6.0) {
		System.out.println("Loai Trung Binh Kha");
	} else if (tb<8.0 && tb>=7.0) {
		System.out.println("Loai Kha");
	} else if (tb<9.0 && tb >=8.0) {
		System.out.println("Loai Gioi");
	} else {
		System.out.println("Loai Xuat Sac");
	}
	}
}
