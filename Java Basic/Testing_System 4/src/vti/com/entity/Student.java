package vti.com.entity;

public class Student {
	private int id;
	private String name;
	private String hometown;
	private float score;	
	public Student( String name, String hometown) {
		this.name = name;
		this.hometown = hometown;
		this.score = 0f;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public float getScore() {
		return score;
	}
	public void serScore(float score) {
		this.score = score;
	}
	
	//Cong them diem
	public void plusScore(Float bonus) {
		this.score += bonus;
		}
	
	/* Tạo 1 method để in ra thông tin của sinh viên bao gồm có tên, điểm học lực ( nếu điểm <4.0 thì sẽ in ra là Yếu, 
	 * nếu điểm > 4.0 và < 6.0 thì sẽ in ra là trung bình, 
	 * nếu điểm > 6.0 và < 8.0 thì sẽ in ra là khá, nếu > 8.0 thì in ra là Giỏi)*/
	//nên để default là giỏi và dùng if chứ k cần else if
	@Override 
	public String toString() {
		String HL = "Gioi";
		if (this.score < 4.0) {
		HL = "Yeu";
		} if (this.score < 6.0) {
		HL = "Trung Binh";
		} if (this.score < 8.0) {
		HL = "Kha";
		}
		return "Student id: " + id + " |name: " + name + " |hometown: " + hometown + " |score: " + score + " |Hoc Luc: " + HL;
		}
}
