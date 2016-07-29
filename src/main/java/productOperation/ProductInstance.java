package productOperation;

public class ProductInstance {
	
	private String name;
	
	public ProductInstance(String name) {
		this.name = name;
	}
	
	public String getVersion(){		
		return ProductVersion.Version(name);
	}

	public String getDate(){		
		return ProductDate.Date(name);
	}
	
	public String getName(){		
		return name;
	}
}
