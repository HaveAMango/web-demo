package lv.accenture.bootcamp.webdemo.model;

public class Cat {

	private Long id;
	private String nickname;

	public Cat(Long id, String nickname) {
		this.id = id;
		this.nickname = nickname;
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
