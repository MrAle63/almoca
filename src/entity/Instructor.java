package entity;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="instructor")
public class Instructor {

	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "instructor_detail_id")
	private Instructor_detail instructor_detail;
	
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH},
			mappedBy = "instructor")
	private Set<Course> course;
	
	public Instructor() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instructor_detail getInstructor_detail() {
		return instructor_detail;
	}

	public void setInstructor_detail(Instructor_detail instructor_detail) {
		this.instructor_detail = instructor_detail;
	}
	
	
}
