package entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="course")
public class Course {
	
	@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(
			cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH})
		@JoinColumn(name="instructor_id", nullable=false )
	private Instructor instructor;
	
	@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name="course_id")
	private Set<Review> review_list = null;
	
	@ManyToMany(cascade = {CascadeType.ALL})
		@JoinTable(
				name="course_student",
				joinColumns = @JoinColumn(name = "course_id"),
				inverseJoinColumns = @JoinColumn(name = "student_id")
				)
	private Set<Student> student_list;
	
	public Course() {};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Set<Review> getReview_list() {
		return review_list;
	}

	public void setReview_list(Set<Review> review_list) {
		this.review_list = review_list;
	}
	
	public void setOneReview_list(Review new_review) {
		if(this.getReview_list() == null) {
			review_list = new HashSet<Review>();
		}
		review_list.add(new_review);
	}

	public Set<Student> getStudent_list() {
		return student_list;
	}

	public void setStudent_list(Set<Student> student_list) {
		this.student_list = student_list;
	}
	
	public void setOneStudent_list(Student student) {
		if(student_list == null) {
			student_list = new HashSet<Student>();
		}
		student_list.add(student);
	}
}
