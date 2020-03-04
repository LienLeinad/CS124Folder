package annotations;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

@GUIAnnotation(target = ButtonGroup.class)
public class ButtonGroupProcessor implements GUIInterface {
	public String[] process(Field f, String label) throws Exception {
		System.out.println("ButtonGroupProcessor START");
		String result[] = {"", "", ""};
		String fieldInitText = "" ;
		String fieldText = "";
		String ButtonGroupTemplate = FileUtils.readFileToString(new File("templates/ButtonGroupTemplate.txt"), Charset.defaultCharset());
		String bgproc = FileUtils.readFileToString(new File("templates/ButtonGroupProcessingTemplate.txt"), Charset.defaultCharset());
		fieldInitText += ButtonGroupTemplate + "\n";
		fieldInitText = fieldInitText.replaceAll("<FIELD_NAME>",f.getName() );
		fieldInitText = fieldInitText.replaceAll("<LABEL>",f.getName() );
		fieldText += "    	private ButtonGroup " + f.getName() + ";\n";
		String JbuttonText = "";
		String JButtonTemplate = FileUtils.readFileToString(new File("templates/JRadioButtonTemplate.txt"),Charset.defaultCharset());
		ButtonGroup bg = f.getAnnotation(ButtonGroup.class);
		String[] options = bg.options();
		for(String s: options) {
			JbuttonText += "\n" + JButtonTemplate;
			JbuttonText = JbuttonText.replaceAll("<LABEL>", s);
			JbuttonText = JbuttonText.replaceAll("<BUTTON_GROUP_NAME>", f.getName());
			JbuttonText += "\n";
		}
		fieldInitText = fieldInitText.replaceAll("<RADIO_BUTTON_INITS>", JbuttonText);
		bgproc = bgproc.replaceAll("<FIELD_NAME>", f.getName());
		bgproc = bgproc.replaceAll("<U_FIELD_NAME>",f.getName().substring(0,1).toUpperCase() + f.getName().substring(1));
		
		result[0] += fieldInitText;
		result[1] += fieldText;
		result[2] += bgproc + "\n";
		return result;
	}
}
