package KontaktOOP;

public class Kontakt {
	private String name;
	private String tel;
	private String eMail;
	
	public Kontakt(String name,String tel,String eMail) {
		this.name = name;
		this.tel = tel;
		this.eMail = eMail;
	}
	
	// Getter & Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	
	
}
