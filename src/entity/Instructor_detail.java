package entity;

import javax.persistence.*;

@Entity
@Table(name="instructor_detail")
public class Instructor_detail {
	
	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtube_channel;
	
	@Column(name="hobby")
	private String hobby;
	
	@OneToOne(
			mappedBy="instructor_detail"
			,cascade = CascadeType.ALL
			)
	
	private Instructor instructor;
	
	public Instructor_detail() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutube_channel() {
		return youtube_channel;
	}

	public void setYoutube_channel(String youtube_channel) {
		this.youtube_channel = youtube_channel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
}
