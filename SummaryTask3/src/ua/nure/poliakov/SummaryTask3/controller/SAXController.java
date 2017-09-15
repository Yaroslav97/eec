package ua.nure.poliakov.SummaryTask3.controller;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.poliakov.SummaryTask3.entity.GrowingTips;
import ua.nure.poliakov.SummaryTask3.entity.VisualParameters;
import ua.nure.poliakov.SummaryTask3.enumeration.Tag;
import ua.nure.poliakov.SummaryTask3.enumeration.Constant;
import ua.nure.poliakov.SummaryTask3.entity.Flower;
import ua.nure.poliakov.SummaryTask3.entity.Greenhouse;

/**
 * Controller for SAX parser.
 *
 * @author Yaroslav Poliakov
 */
public class SAXController extends DefaultHandler {

    private String xmlFile;
    private String currentElement;
    private Greenhouse greenhouse;
    private Flower flower;
    private VisualParameters visualParameters;
    private GrowingTips growingTips;

    public SAXController(String xmlFile) {
        this.xmlFile = xmlFile;
    }

    /**
     * Parses Tag document.
     *
     * @param validate If true validate Tag document against its Tag schema. With
     *                 this parameter it is possible make parser validating.
     */
    public void parse(boolean validate) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        saxParserFactory.setNamespaceAware(true);

        if (validate) {
            saxParserFactory.setFeature(Constant.FEATURE_TURN_VALIDATION_ON, true);
            saxParserFactory.setFeature(Constant.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
        }

        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse(xmlFile, this);
    }

    @Override
    public void error(org.xml.sax.SAXParseException e) throws SAXException {
        throw e;
    }

    public Greenhouse getGreenhouse() {
        return greenhouse;
    }

    @Override
    public void startElement(String uri, String localName, String fName, Attributes attributes) throws SAXException {

        currentElement = localName;

        if (Tag.GREENHOUSE.equalsTo(currentElement)) {
            greenhouse = new Greenhouse();
            return;
        }

        if (Tag.FLOWER.equalsTo(currentElement)) {
            flower = new Flower();
            return;
        }

        if (Tag.VISUALPARAMETERS.equalsTo(currentElement)) {
            visualParameters = new VisualParameters();
            if (attributes.getLength() > 0) {
                visualParameters.setStemColor(attributes.getValue(uri, Tag.STEMCOLOR.value()));
                visualParameters.setLeafColor(attributes.getValue(uri, Tag.LEAFCOLOR.value()));
                visualParameters.setAverageSize(attributes.getValue(uri, Tag.AVERAGESIZE.value()));
            }
        }

        if (Tag.GROWINGTIPS.equalsTo(currentElement)) {
            growingTips = new GrowingTips();
            if (attributes.getLength() > 0) {
                growingTips.setTemperature(Integer.valueOf(attributes.getValue(uri, Tag.TEMPERATURE.value())));
                growingTips.setLightning(Boolean.valueOf(attributes.getValue(uri, Tag.LIGHTNING.value())));
                growingTips.setWatering(Integer.valueOf(attributes.getValue(uri, Tag.WATERING.value())));
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String elementText = new String(ch, start, length).trim();

        if (elementText.isEmpty()) {
            return;
        }

        if (Tag.NAME.equalsTo(currentElement)) {
            flower.setName(elementText);
            return;
        }

        if (Tag.SOIL.equalsTo(currentElement)) {
            flower.setSoil(elementText);
            return;
        }

        if (Tag.ORIGIN.equalsTo(currentElement)) {
            flower.setOrigin(elementText);
            return;
        }

        if (Tag.MULTIPLYING.equalsTo(currentElement)) {
            flower.setMultiplying(elementText);
            return;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (Tag.FLOWER.equalsTo(localName)) {
            greenhouse.getGreenhouses().add(flower);
            return;
        }

        if (Tag.VISUALPARAMETERS.equalsTo(localName)) {
            flower.setVisualParameters(visualParameters);
            return;
        }

        if (Tag.GROWINGTIPS.equalsTo(localName)) {
            flower.setGrowingTips(growingTips);
            return;
        }
    }
}