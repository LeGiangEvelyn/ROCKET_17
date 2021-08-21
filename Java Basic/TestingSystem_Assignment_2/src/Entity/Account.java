package Entity;

import java.time.LocalDateTime;


public class Account {
	public int id;
	public String email;
	public String userName;
	public String fullName;
	public Department department;
	public Position position;
	public LocalDateTime createDate;
	public Group[] groups;
}
