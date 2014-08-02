package net.start.amg;

public class DepartmentManager {
	private static DepartmentManager instance;
	
	private DepartmentManager() {
	}
	
	public static DepartmentManager getInstance() {
		if(instance == null) {
			instance = new DepartmentManager();
		}
		return instance;
	}
}
