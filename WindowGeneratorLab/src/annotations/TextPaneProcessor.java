package annotations;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

@GUIAnnotation(target = TextPane.class)
public class TextPaneProcessor implements GUIInterface {
	
	public String[] process(Field f, String label) throws Exception {
		String JTextPanelTemplate = FileUtils.readFileToString(new File("templates/JTextPaneTemplate.txt"),Charset.defaultCharset());
		System.out.println("TextPaneProcessor START");
		String result[] = {"","", ""};
		String fieldInitText = "";
		String fieldText = "";
		String processString = FileUtils.readFileToString(new File("templates/otherShitProcessor.txt"),Charset.defaultCharset());
		String fieldName = f.getName();
		String capName = fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
		
		processString = processString.replaceAll("<VAR_NAME_WITHCAPS>", capName);
		processString = processString.replaceAll("<VAR_NAME>", fieldName);
		processString += "\n";
		
		fieldInitText += JTextPanelTemplate + "\n";
		fieldInitText = fieldInitText.replaceAll("<FIELD_NAME>",f.getName() );
		fieldInitText = fieldInitText.replaceAll("<LABEL>",f.getName() );
		fieldText += "    	private JTextPane " + f.getName() + ";\n";
		result [0] += fieldInitText;
		result[1] += fieldText;
		result[2] += processString;
		return result;
	}
}
