package ua.nure.poliakov.SummaryTask3;

import org.xml.sax.SAXException;
import ua.nure.poliakov.SummaryTask3.controller.DOMController;
import ua.nure.poliakov.SummaryTask3.controller.SAXController;
import ua.nure.poliakov.SummaryTask3.controller.STAXController;
import ua.nure.poliakov.SummaryTask3.entity.Greenhouse;
import ua.nure.poliakov.SummaryTask3.sort.Sort;
import ua.nure.poliakov.SummaryTask3.writer.XMLWriter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {

    public static void print() {
        System.out.println("Usage:\njava -jar ST3ExampleSimple.jar input");
        System.out.println("java ua.nure.poliakov.SummaryTask3.Main input");
    }

    public static void main(String[] args) throws IOException, SAXException,
            ParserConfigurationException, TransformerException, XMLStreamException {

        if (args.length != 1) {
            print();
            return;
        }

        String xmlFileName = args[0];
        System.out.println("Input ==> " + xmlFileName);

        DOMController domController = new DOMController(xmlFileName);
        domController.parse(true);
        Greenhouse greenhouse = domController.getGreenhouse();

        Sort.sortByFlowerName(greenhouse);

        String outputXmlFile = "output.dom.xml";
        XMLWriter.saveToXML(greenhouse, outputXmlFile);
        System.out.println("Output ==> " + outputXmlFile);


        SAXController saxController = new SAXController(xmlFileName);
        saxController.parse(true);
        greenhouse = saxController.getGreenhouse();

        Sort.sortBySolid(greenhouse);

        outputXmlFile = "output.sax.xml";

        XMLWriter.saveToXML(greenhouse, outputXmlFile);
        System.out.println("Output ==> " + outputXmlFile);


        STAXController staxController = new STAXController(xmlFileName);
        staxController.parse();
        greenhouse = staxController.getGreenhouse();

        Sort.sortByCountry(greenhouse);

        outputXmlFile = "output.stax.xml";
        XMLWriter.saveToXML(greenhouse, outputXmlFile);
        System.out.println("Output ==> " + outputXmlFile);

        System.out.println(System.lineSeparator());

        System.out.println(greenhouse);
    }
}