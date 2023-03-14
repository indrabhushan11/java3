package lab3;

import javax.persistence.*;

@Entity
@Table(name="student")
public class student {

	@Id
	int usn;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUsn() {
		return usn;
	}
	public void setUsn(int usn) {
		this.usn = usn;
	}
	String name;
	
}
