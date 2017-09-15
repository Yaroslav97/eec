package ua.nure.poliakov.SummaryTask3.writer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ua.nure.poliakov.SummaryTask3.entity.Flower;
import ua.nure.poliakov.SummaryTask3.entity.Greenhouse;
import ua.nure.poliakov.SummaryTask3.enumeration.Tag;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLWriter {

    /**
     * Creates and returns DOM of the Test container.
     *
     * @param greenhouse Test object.
     * @throws ParserConfigurationException
     */
    public static Document getDocument(Greenhouse greenhouse) throws ParserConfigurationException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        documentBuilderFactory.setNamespaceAware(true);

        DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
        Document document = db.newDocument();

        Element tElement = document.createElement(Tag.GREENHOUSE.value());

        document.appendChild(tElement);

        for (Flower flower : greenhouse.getGreenhouses()) {

            Element element = document.createElement(Tag.FLOWER.value());
            tElement.appendChild(element);

            Element name = document.createElement(Tag.NAME.value());
            name.setTextContent(flower.getName());
            element.appendChild(name);

            Element soil = document.createElement(Tag.SOIL.value());
            soil.setTextContent(flower.getSoil());
            element.appendChild(soil);

            Element origin = document.createElement(Tag.ORIGIN.value());
            origin.setTextContent(flower.getOrigin());
            element.appendChild(origin);

            Element visualParameters = document.createElement(Tag.VISUALPARAMETERS.value());
            visualParameters.setAttribute(Tag.STEMCOLOR.value(), flower.getVisualParameters().getStemColor());
            visualParameters.setAttribute(Tag.LEAFCOLOR.value(), flower.getVisualParameters().getLeafColor());
            visualParameters.setAttribute(Tag.AVERAGESIZE.value(), flower.getVisualParameters().getAverageSize());
            element.appendChild(visualParameters);

            Element growingTips = document.createElement(Tag.GROWINGTIPS.value());
            growingTips.setAttribute(Tag.TEMPERATURE.value(), String.valueOf(flower.getGrowingTips().getTemperature()));
            growingTips.setAttribute(Tag.LIGHTNING.value(), String.valueOf(flower.getGrowingTips().getLightning()));
            growingTips.setAttribute(Tag.WATERING.value(), String.valueOf(flower.getGrowingTips().getWatering()));
            element.appendChild(growingTips);

            Element multiplying = document.createElement(Tag.MULTIPLYING.value());
            multiplying.setTextContent(flower.getMultiplying());
            element.appendChild(multiplying);
        }
        return document;
    }

    /**
     * Saves Test object to XML file.
     *
     * @param greenhouse  Test object to be saved.
     * @param xmlFileName Output XML file name.
     */
    public static void saveToXML(Greenhouse greenhouse, String xmlFileName) throws ParserConfigurationException, TransformerException {
        saveToXML(getDocument(greenhouse), xmlFileName);
    }

    /**
     * Save DOM to XML.
     *
     * @param document    DOM to be saved.
     * @param xmlFileName Output XML file name.
     */
    public static void saveToXML(Document document, String xmlFileName) throws TransformerException {

        StreamResult result = new StreamResult(new File(xmlFileName));

        TransformerFactory tf = TransformerFactory.newInstance();
        javax.xml.transform.Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");

        t.transform(new DOMSource(document), result);
    }
}