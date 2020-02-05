package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
	
	@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="email")
	private String email;
	
	@ManyToMany(cascade = {CascadeType.ALL})
		@JoinTable(
				name="course_student",
				joinColumns = @JoinColumn(name = "student_id"),
				inverseJoinColumns = @JoinColumn(name = "course_id")
				)
	private Set<Course> list_course;
	
	public Student() {}

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

	public Set<Course> getList_course() {
		return list_course;
	}

	public void setList_course(Set<Course> list_course) {
		this.list_course = list_course;
	}
	
	public void setOneCourse_list(Course c) {
		if(this.list_course == null) {
			this.list_course = new HashSet<Course>();
		}
		list_course.add(c);
	}
}
