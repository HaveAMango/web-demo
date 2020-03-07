package lv.accenture.bootcamp.webdemo.model;

import java.io.Serializable;

public class Cat implements Serializable {

	private Long id;
	private String nickname;
	private int age;
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Cat(Long id, String nickname, int age, String image) {
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
