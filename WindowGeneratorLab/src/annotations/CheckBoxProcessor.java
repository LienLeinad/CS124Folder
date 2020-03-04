package annotations;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

@GUIAnnotation(target = CheckBox.class)
public class CheckBoxProcessor implements GUIInterface {
	public String[] process(Field f, String label) throws Exception {
		System.out.println("CheckBoxProcessor START");
		String result[] = {"", "", ""};
		String JCheckBoxTemplate = FileUtils.readFileToString(new File("templates/JCheckBoxTemplate.txt"), Charset.defaultCharset());
		String fieldInitText = "";
		String fieldText = "";
		String processString = FileUtils.readFileToString(new File("templates/otherShitProcessor2.txt"),Charset.defaultCharset());
		String fieldName = f.getName();
		String capName = fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
		String capLabel = label.substring(0,1).toUpperCase()+label.substring(1);
		processString = processString.replaceAll("<VAR_NAME_WITHCAPS>", capName);
		processString = processString.replaceAll("<VAR_NAME>", fieldName);
		processString += "\n";
		
		fieldInitText += JCheckBoxTemplate + "\n";
		fieldInitText = fieldInitText.replaceAll("<FIELD_NAME>",f.getName() );
		fieldInitText = fieldInitText.replaceAll("<LABEL>","Employed" );
		fieldText += "    	private JCheckBox " + f.getName() + ";\n";
		result[0] += fieldInitText;
		result[1] += fieldText;
		result[2] += processString;
		return result;
	}
}
