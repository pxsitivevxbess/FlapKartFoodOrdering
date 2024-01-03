package Utils;

public class IDGenerator {
	private static Integer id = 0;
	public static Integer generateId()
	{
		id++;
		return id;
	}
	

}
