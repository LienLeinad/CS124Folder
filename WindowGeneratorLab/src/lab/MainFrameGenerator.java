package lab;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import annotations.TextPane;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;
import annotations.ButtonGroup; 
import annotations.CheckBox;
import annotations.GUIAnnotation;
import annotations.GUIInterface;


public class MainFrameGenerator {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String template = FileUtils.readFileToString(new File("templates/MainFrame.java.txt"), Charset.defaultCharset());
		
		
		String result = process(template);

		
		FileUtils.write(new File("src/output/MainFrame.java"), result, Charset.defaultCharset());
	}


	
	public static String process(String template) throws Exception
	{
		HashMap<Class, GUIInterface> map = new HashMap<>();
		Class c = UIModel.class;
		String fieldText = "";
		String fieldInitText = "";
		String processString = "";
		// do stuff with template
		// template vars
//		String JTextPanelTemplate = FileUtils.readFileToString(new File("templates/JTextPaneTemplate.txt"),Charset.defaultCharset());
		
		
		// NOTE: MainFrame.java has 4 replacement areas
		// 3 of them are affected for each field instance
		ScanResult results = new FastClasspathScanner("annotations").scan();
		List<String> allResults = results.getNamesOfClassesWithAnnotation(GUIAnnotation.class);
		for(String s: allResults) {
			
			Class c1 = Class.forName(s);
			GUIAnnotation gi = (GUIAnnotation) c1.getAnnotation(GUIAnnotation.class);
			map.put(gi.target(), (GUIInterface)c1.newInstance() );
		}
		
		// add all fields into a hashmap, with their specific annotations as their key
		
		for (Field field : c.getDeclaredFields())
		{
			Annotation[] alist = field.getAnnotations();
			Annotation a = alist[0];
			GUIInterface gi = (GUIInterface) map.get(a.annotationType());
			// index 0 == fieldInitText
			// index 1 == fieldText
			// index 2 == processString
			String[] textToAdd = {};
			if(gi != null) {
				textToAdd = gi.process(field,  field.getName());
				fieldInitText += textToAdd[0];
				fieldText += textToAdd[1];
				processString += textToAdd[2];
			}
			
			
			//Fixing the field declarations of MainFrame
//			if(field.isAnnotationPresent(TextPane.class)) {
//				fieldInitText += JTextPanelTemplate + "\n";
//				fieldInitText = fieldInitText.replaceAll("<FIELD_NAME>",field.getName() );
//				fieldInitText = fieldInitText.replaceAll("<LABEL>",field.getName() );
//				fieldText += "    	private JTextPane " + field.getName() + ";\n";
//			}
//			else if(field.isAnnotationPresent(CheckBox.class)) {
//				fieldInitText += JCheckBoxTemplate + "\n";
//				fieldInitText = fieldInitText.replaceAll("<FIELD_NAME>",field.getName() );
//				fieldInitText = fieldInitText.replaceAll("<LABEL>","Employed" );
//				fieldText += "    	private JCheckBox " + field.getName() + ";\n";
//			}
//			else if(field.isAnnotationPresent(ButtonGroup.class)) {
//				fieldInitText += ButtonGroupTemplate + "\n";
//				fieldInitText = fieldInitText.replaceAll("<FIELD_NAME>",field.getName() );
//				fieldInitText = fieldInitText.replaceAll("<LABEL>",field.getName() );
//				fieldText += "    	private ButtonGroup " + field.getName() + ";\n";
//				String JbuttonText = "";
//				String JButtonTemplate = FileUtils.readFileToString(new File("templates/JRadioButtonTemplate.txt"),Charset.defaultCharset());
//				ButtonGroup bg = field.getAnnotation(ButtonGroup.class);
//				String[] options = bg.options();
//				for(String s: options) {
//					JbuttonText += "\n" + JButtonTemplate;
//					JbuttonText = JbuttonText.replaceAll("<LABEL>", s);
//					JbuttonText = JbuttonText.replaceAll("<BUTTON_GROUP_NAME>", field.getName());
//					JbuttonText += "\n";
//				}
//				fieldInitText = fieldInitText.replaceAll("<RADIO_BUTTON_INITS>", JbuttonText);
//			}
//			
			// HashMapVersion
			// add all fields into a hashmap, with their specific annotations as their key
			
		}

		
		// replace <UI_FIELD_DECLERATIONS>
		template = template.replaceAll("<UI_FIELD_DECLARATIONS>",fieldText);
		template = template.replaceAll("<UI_FIELD_INIT>", fieldInitText);
		template = template.replaceAll("<FULL_MODEL_NAME>", c.getName());
		
//		String bgproc = FileUtils.readFileToString(new File("templates/ButtonGroupProcessingTemplate.txt"), Charset.defaultCharset());
//		processString += "		model.setName(name.getText());\n";
//		processString += "		model.setStatus(status.isSelected());\n";
//		bgproc = bgproc.replaceAll("<FIELD_NAME>", c.getDeclaredField("programmingLevel").getName());
//		bgproc = bgproc.replaceAll("<U_FIELD_NAME>", "ProgrammingLevel");
//		processString += bgproc + "\n";
		
		
		template = template.replaceAll("<UI_FIELD_PROCESSING>", processString);
		return template;
	}
	

}
