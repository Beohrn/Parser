import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.w3c.dom.*;

import javax.xml.parsers.*;

public class Parser {

    private String path;
    private Map<String, String> map;
    private String fileContent;

    public Parser(String path) throws FileNotFoundException {
        this.path = path;
        this.fileContent = FileWorker.read(path);
    }

    public void parse() {
        Map<String, String> map = parser();
        for (Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getValue().equals("")) {
                iterator.remove();
            }
        }
        this.map = map;

    }

    public Map<String, String> parser() {
        Map<String, String> map = new HashMap<String, String>();
        String style = "";
        String id = "";
        try {
            File file = new File("C://Users//Alexander//IdeaProjects//Parser//map.svg");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            NodeList list = document.getElementsByTagName("path");
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    style = element.getAttribute("style");
                    id = element.getAttribute("id");
                    map.put(id, style);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//29.759766
        return map;
    }

}
