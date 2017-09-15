package ua.nure.poliakov.SummaryTask3.controller;

import java.io.IOException;
import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.poliakov.SummaryTask3.entity.Flower;
import ua.nure.poliakov.SummaryTask3.entity.Greenhouse;
import ua.nure.poliakov.SummaryTask3.entity.GrowingTips;
import ua.nure.poliakov.SummaryTask3.entity.VisualParameters;
import ua.nure.poliakov.SummaryTask3.enumeration.Tag;

/**
 * Controller for StAX parser.
 *
 * @author Yaroslav Poliakov
 */
public class STAXController extends DefaultHandler {

    private String xmlFile;

    private Greenhouse greenhouse;
    private Flower flower;
    private VisualParameters visualParameters;
    private GrowingTips growingTips;

    public Greenhouse getGreenhouse() {
        return greenhouse;
    }

    public STAXController(String xmlFile) {
        this.xmlFile = xmlFile;
    }

    /**
     * Parses Tag document with StAX (based on event reader). There is no validation during the
     * parsing.
     */
    public void parse() throws ParserConfigurationException, SAXException, IOException, XMLStreamException {

        String currentElement = null;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        xmlInputFactory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);

        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new StreamSource(xmlFile));

        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();

            if (xmlEvent.isCharacters() && xmlEvent.asCharacters().isWhiteSpace()) {
                continue;
            }

            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();
                currentElement = startElement.getName().getLocalPart();

                if (Tag.GREENHOUSE.equalsTo(currentElement)) {
                    greenhouse = new Greenhouse();
                    continue;
                }

                if (Tag.FLOWER.equalsTo(currentElement)) {
                    flower = new Flower();
                    continue;
                }

                if (Tag.VISUALPARAMETERS.equalsTo(currentElement)) {
                    visualParameters = new VisualParameters();
                    Attribute steamColor = startElement.getAttributeByName(new QName(Tag.STEMCOLOR.value()));
                    Attribute leafColor = startElement.getAttributeByName(new QName(Tag.LEAFCOLOR.value()));
                    Attribute averageSize = startElement.getAttributeByName(new QName(Tag.AVERAGESIZE.value()));
                    if (steamColor != null) {
                        visualParameters.setLeafColor(steamColor.getValue());
                    }
                    if (leafColor != null) {
                        visualParameters.setStemColor(leafColor.getValue());
                    }
                    if (averageSize != null) {
                        visualParameters.setAverageSize(averageSize.getValue());
                    }
                    continue;
                }

                if (Tag.GROWINGTIPS.equalsTo(currentElement)) {
                    growingTips = new GrowingTips();
                    Attribute temperature = startElement.getAttributeByName(new QName(Tag.TEMPERATURE.value()));
                    Attribute lightning = startElement.getAttributeByName(new QName(Tag.LIGHTNING.value()));
                    Attribute watering = startElement.getAttributeByName(new QName(Tag.WATERING.value()));
                    if (temperature != null) {
                        growingTips.setTemperature(Integer.valueOf(temperature.getValue()));
                    }
                    if (lightning != null) {
                        growingTips.setLightning(Boolean.valueOf(lightning.getValue()));
                    }
                    if (watering != null) {
                        growingTips.setWatering(Integer.valueOf(watering.getValue()));
                    }
                    continue;
                }
            }

            if (xmlEvent.isCharacters()) {
                Characters characters = xmlEvent.asCharacters();

                if (Tag.NAME.equalsTo(currentElement)) {
                    flower.setName(characters.getData());
                    continue;
                }

                if (Tag.SOIL.equalsTo(currentElement)) {
                    flower.setSoil(characters.getData());
                    continue;
                }

                if (Tag.ORIGIN.equalsTo(currentElement)) {
                    flower.setOrigin(characters.getData());
                    continue;
                }

                if (Tag.MULTIPLYING.equalsTo(currentElement)) {
                    flower.setMultiplying(characters.getData());
                    continue;
                }
            }

            if (xmlEvent.isEndElement()) {
                EndElement endElement = xmlEvent.asEndElement();
                String localName = endElement.getName().getLocalPart();

                if (Tag.FLOWER.equalsTo(localName)) {
                    greenhouse.getGreenhouses().add(flower);
                    continue;
                }

                if (Tag.VISUALPARAMETERS.equalsTo(localName)) {
                    flower.setVisualParameters(visualParameters);
                }

                if (Tag.GROWINGTIPS.equalsTo(localName)) {
                    flower.setGrowingTips(growingTips);
                }
            }
        }
        xmlEventReader.close();
    }
}