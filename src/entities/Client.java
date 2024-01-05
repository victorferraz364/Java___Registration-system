package entities;

import java.util.Objects;

public class Client {

	private String name;
	private Long cpf;
	private Long phone;
	private String end;
	private Integer number;
	private String city;
	private String state;
	
	public Client() {}
	
	public Client(String name, String cpf, String phone, String end, String number, String city, String state) {
		
		this.name = name;
		this.cpf = Long.valueOf(cpf.trim());
		this.phone = Long.valueOf(phone.trim());
		this.end = end;
		this.number = Integer.valueOf(number.trim());
		this.city = city;
		this.state = state; 
		}

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public Long getCpf() { return cpf; }

	public void setCpf(Long cpf) { this.cpf = cpf; }

	public Long getPhone() { return phone; }

	public void setPhone(Long phone) { this.phone = phone; }

	public String getEnd() { return end; }

	public void setEnd(String end) { this.end = end; }

	public Integer getNumber() { return number; }

	public void setNumber(Integer number) { this.number = number; }

	public String getCity() { return city; }

	public void setCity(String city) { this.city = city;}

	public String getState() { return state; }

	public void setState(String state) { this.state = state; }

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", cpf=" + cpf + "]";
	}
	
	
	
	
	
}
