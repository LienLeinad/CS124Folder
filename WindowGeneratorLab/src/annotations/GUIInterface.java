package annotations;
import java.lang.reflect.Field;


public interface GUIInterface 
{
	public String[] process(Field f, String label) throws Exception;
}
