
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;

public class Exercise2 {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//question1();
		//question4();
		//question5();
		//question6();
		//question8();
		question9();
	}
	/*Question 1:
Nhập số liệu cho dãy số thực a0 , a1 ,..., an-1 .
Hãy liệt kê các phần tử xuất hiện trong dãy đúng một lần*/
	public static void question1() {
		System.out.println("Nhap vao so luong N: ");
		int n = sc.nextInt();
		float[] input = new float[n];
		for (int i=0; i<n; i++) {
			input[i] = sc.nextFloat();
		}
		Map<Float, Integer> map = new TreeMap<Float, Integer>();
        for (int i = 0; i < n; i++) {
            addElement( map, input[i]);
        }
        
        System.out.println("Cac phan tu xuat hien 1 lan trong day: ");
        for(int i = 0; i < n; i++) {
        if (map.get(input[i]) == 1) {
        	System.out.print(input[i]+ " ");
        }
        }
	}
	private static void addElement(Map<Float, Integer> map, float element) {
		if (map.containsKey(element)) {
            int count = map.get(element) + 1;
            map.put(element, count);
        } else {
            map.put(element, 1);		
	}
	}

	/*
Question 4:
Hãy viết chương trình tính tổng các chữ số của một số nguyên bất kỳ.
Ví dụ: Số 8545604 có tổng các chữ số là: 8+5+4+5+6+0+4= 32*/
	public static void question4() {
		
		System.out.println("Nhap so nguyen: ");
		int input = sc.nextInt();
		int sum = 0;
		do {
			sum = sum + input % 10;
			input = input / 10;
		} while (input != 0);
		System.out.println("Sum: "+ sum);
	}
	/*
Question 5:
Viết chương trình phân tích một số nguyên thành các thừa số nguyên tố
Ví dụ: Số 28 được phân tích thành 2 x 2 x 7 */
	
	public static void question5() {
	
		System.out.println("Nhap so nguyen: ");
		int input = sc.nextInt();
		// phân tích số nguyên input
        List<Integer> listNumbers = phanTichSoNguyen(input);
        // in kết quả ra màn hình
        System.out.printf("Kết quả: %d = ", input);
        int size = listNumbers.size();
        for (int i = 0; i < size - 1; i++) {
            System.out.print(listNumbers.get(i) + " x ");
        }
        System.out.print(listNumbers.get(size - 1));
    }
     
    /**
     * Phân tích số nguyên thành tích các thừa số nguyên tố 
     * 
     * @param positiveInt
     * @return
     */
    public static List<Integer> phanTichSoNguyen(int n) {
        int i = 2;
        List<Integer> listNumbers = new ArrayList<Integer>();
        // phân tích
        while (n > 1) {
            if (n % i == 0) {
                n = n / i;
                listNumbers.add(i);
            } else {
                i++;
            }
        }
        // nếu listNumbers trống thì add n vào listNumbers
        if (listNumbers.isEmpty()) {
            listNumbers.add(n);
        }
        return listNumbers;
    }

	/*
Question 6:
Viết chương trình liệt kê tất cả các số nguyên tố nhỏ hơn n cho trước.
Question 7:
Viết chương trình liệt kê n số nguyên tố đầu tiên.*/
    public static void question7() {
		System.out.println("Nhap so nguyen: ");
		int input = sc.nextInt();	
		
		System.out.printf("%d số nguyên tố đầu tiên là: \n", input);
        int dem = 0; // đếm số số nguyên tố
        int i = 2;   // tìm số nguyên tố bắt dầu từ số 2
        while (dem < input) {
            if (isPrimeNumber(i)) {
                System.out.print(i + " ");
                dem++;
            }
            i++;
        } }
        public static boolean isPrimeNumber(int n) {
            // so nguyen n < 2 khong phai la so nguyen to
            if (n < 2) {
                return false;
            }
            // check so nguyen to khi n >= 2
            int squareRoot = (int) Math.sqrt(n);
            for (int i = 2; i <= squareRoot; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    
    /*
Question 8:
Viết chương trình tìm ước số chung lớn nhất, bội số chung nhỏ nhất của hai số tự nhiên a và b.*/
       public static void question8() {
        System.out.print("Nhập số nguyên dương a: ");
        int a = sc.nextInt();
        System.out.print("Nhập số nguyên dương b: ");
        int b = sc.nextInt();
        // tính USCLN của a và b
        System.out.println("USCLN của " + a + " và " + b
                + " là: " + USCLN(a, b));
        // tính BSCNN của a và b
        System.out.println("BSCNN của " + a + " và " + b
                + " là: " + BSCNN(a, b));
    }
       public static int USCLN(int a, int b) {
           if (b == 0) return a;
           return USCLN(b, a % b);
       }
       public static int BSCNN(int a, int b) {
           return (a * b) / USCLN(a, b);
       }
     /*
Question 9:
Dãy số Fibonacci được định nghĩa như sau:
F0 =1, F1 = 1; Fn = Fn-1 + Fn-2 với n>=2.
Hãy viết chương trình tìm số Fibonacci thứ n.
*/
       public static void question9() {
    	   System.out.println("Nhap so nguyen: ");
   			int input = sc.nextInt();
   			System.out.println("So Fibonacci thu "+ input + " la: "+ fibo(input));
       }
       //Tim so fibo thu n bang de quy
       public static int fibo(int n) {
           if (n < 0) {
               return -1;
           } else if (n == 0 || n == 1) {
               return n;
           } else {
               return fibo(n - 1) + fibo(n - 2);
           }
       }
       
       /*
Question 10:
Một số được gọi là số thuận nghịch độc nếu ta đọc từ trái sang phải hay từ phải sang trái số đó ta vẫn nhận được một số giống nhau.
Hãy liệt kê tất cả các số thuận nghịch độc có sáu chữ số (Ví dụ số: 558855).
Question 11:
Viết chương trình liệt kê tất cả các hoán vị của 1, 2, .., n.
Question 12:
Nhập số liệu cho 2 dãy số thực a0 , a1 ,..., am-1 và b0 , b1 ,..., bn-1. Giả sử cả 2 dãy này đã được sắp theo thứ tự tăng dần.
Hãy tận dụng tính sắp xếp của 2 dãy và tạo dãy c0 , c1 ,..., cm+n-1 là hợp của 2 dãy trên, sao cho dãy ci cũng có thứ tự tăng dần .
Question 13:
Nhập số n và dãy các số thực a0 , a1 ,..., an-1. Không đổi chỗ các phần tử và không dùng thêm mảng số thực nào khác (có thể dùng mảng số nguyên nếu cần)
Hãy cho hiện trên màn hình dãy trên theo thứ tự tăng dần
Question 14:
Nhập một số tự nhiên n.
Hãy liệt kê các số Fibonaci nhỏ hơn n là số nguyên tố
Question 15:
Viết chương trình nhập một số nguyên dương n và thực hiện các chức năng sau:
a) Tính tổng các chữ số của n.
b) Phân tích n thành các thừa số nguyên tố.
Question 16:
Viết chương trình nhập một số nguyên dương n và thực hiện các chức năng sau:
a) Liệt kê các ước số của n. Có bao nhiêu ước số.
b) Liệt kê các ước số là nguyên tố của n.
Question 17:
Viết chương trình liệt kê các số nguyên có 7 chữ số thoả mãn:
a) Là số nguyên tố.
b) Là số thuận nghịch.
c) Tổng các chữ số của số đó là một số thuận nghịch
Question 18:
Viết chương trình nhập vào vào mảng A có n phần tử
(các phần tử là những số nguyên lớn hơn 0 và nhỏ hơn 100 được nhập vào từ bàn phím. )
4
Thực hiện các chức năng sau:
a) Tìm phần tử lớn nhất và lớn thứ 2 trong mảng cùng chỉ số của các số đó.
b) Sắp xếp mảng theo thứ tự giảm dần .
c) Nhập một số nguyên x và chèn x vào mảng A sao cho vẫn đảm bảo tính sắp xếp giảm dần.
Question 19:
Viết chương trình nhập vào vào mảng A có n phần tử, các phần tử là những số nguyên lớn hơn 0 và nhỏ hơn 100 được nhập vào từ bàn phím.
Thực hiện các chức năng sau:
a) Tìm phần tử lớn nhất và lớn thứ 2 trong mảng cùng chỉ số của các số đó.
b) Sắp xếp mảng theo thứ tự giảm dần .
c) Nhập một số nguyên x và chèn x vào mảng A sao cho vẫn đảm bảo tính sắp xếp giảm dần.
Question 20:
Viết chương trình thực hiện chuẩn hoá một xâu ký tự nhập từ bàn phím (loại bỏ các dấu cách thừa, chuyển ký tự đầu mỗi từ thành chữ hoa, các ký tự khác thành chữ thường)
Question 21:
Viết chương trình thực hiện nhập một xâu ký tự
a) Tìm từ dài nhất trong xâu đó.
b) Từ đó xuất hiện ở vị trí nào?
(Chú ý. nếu có nhiều từ có độ dài giống nhau thì chọn từ đầu tiên tìm thấy). */

}
