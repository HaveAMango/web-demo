package lv.accenture.bootcamp.webdemo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
public class Cat implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 2, max = 256)
	private String nickname;
	
	@NotNull
	@PositiveOrZero(message = "Please enter something adequate")
	private Integer age;
	
	@Size(min=10, max=2000)
	private String image;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Cat(Long id, String nickname, Integer age, String image) {
		this.id = id;
		this.nickname = nickname;
		this.age = age;
		this.image = image;
	}

	public Cat() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
