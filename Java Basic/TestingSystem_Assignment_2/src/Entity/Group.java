package Entity;

import java.time.LocalDateTime;

public class Group {
	public int id;
	public String name;
	public Account creator;
	public LocalDateTime createDate;
	public Account[] accounts;
}
