package model;

public class JuristischePartei extends Partei{
	
	private String firmenname;
	private String handelsregister;
	
	
	public String getFirmenname() {
		return firmenname;
	}
	public void setFirmenname(String firmenname) {
		this.firmenname = firmenname;
	}
	public String getHandelsregister() {
		return handelsregister;
	}
	public void setHandelsregister(String handelsregister) {
		this.handelsregister = handelsregister;
	}
	
}
