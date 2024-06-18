package enums;

public enum ID {
	CHARACTERS("0123456789abcdefghijklmnopqrstuvwxyz");
	
	private String characters;
	
	ID(String characters){
		this.characters = characters;
	}
	
	public String getCharacters() {
		return characters;
	}
}
