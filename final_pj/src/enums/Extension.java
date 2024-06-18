package enums;

public enum Extension {
	KEY_EXT(".txt");
	
	private String extension;
	
	Extension(String e){
		this.extension = e;
	}
	
	public String getExtension() {
		return extension;
	}
}
