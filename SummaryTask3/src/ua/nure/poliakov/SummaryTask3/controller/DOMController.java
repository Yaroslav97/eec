package ua.nure.poliakov.SummaryTask3.controller;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.poliakov.SummaryTask3.entity.Flower;
import ua.nure.poliakov.SummaryTask3.entity.Greenhouse;
import ua.nure.poliakov.SummaryTask3.entity.GrowingTips;
import ua.nure.poliakov.SummaryTask3.entity.VisualParameters;
import ua.nure.poliakov.SummaryTask3.enumeration.Constant;
import ua.nure.poliakov.SummaryTask3.enumeration.Tag;

/**
 * Controller for DOM parser.
 *
 * @author Yaroslav Poliakov
 */
public class DOMController {

    private String xmlFileName;
    private Greenhouse greenhouse;

    public DOMController(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public Greenhouse getGreenhouse() {
        return greenhouse;
    }

    /**
     * Parses XML document.
     *
     * @param validate If true validate XML document against its XML schema.
     */
    public void parse(boolean validate) throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);

        if (validate) {
            documentBuilderFactory.setFeature(Constant.FEATURE_TURN_VALIDATION_ON, true);
            documentBuilderFactory.setFeature(Constant.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
        }

        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        documentBuilder.setErrorHandler(new DefaultHandler() {
            @Override
            public void error(SAXParseException e) throws SAXException {
                throw e;
            }
        });

        Document document = documentBuilder.parse(xmlFileName);
        Element root = document.getDocumentElement();
        greenhouse = new Greenhouse();
        NodeList questionNodes = root.getElementsByTagName(Tag.FLOWER.value());

        for (int j = 0; j < questionNodes.getLength(); j++) {
            Flower question = getFlower(questionNodes.item(j));
            greenhouse.getGreenhouses().add(question);
        }
    }

    /**
     * Extracts question object from the question XML node.
     *
     * @param fNode Question node.
     * @return Question object.
     */
    private Flower getFlower(Node fNode) {
        Flower flower = new Flower();
        Element qElement = (Element) fNode;

        Node name = qElement.getElementsByTagName(Tag.NAME.value()).item(0);
        flower.setName(name.getTextContent());

        Node soil = qElement.getElementsByTagName(Tag.SOIL.value()).item(0);
        flower.setSoil(soil.getTextContent());

        Node origin = qElement.getElementsByTagName(Tag.ORIGIN.value()).item(0);
        flower.setOrigin(origin.getTextContent());

        NodeList visualParameters = qElement.getElementsByTagName(Tag.VISUALPARAMETERS.value());
        flower.setVisualParameters(getVisualParameters(visualParameters));

        NodeList growingTips = qElement.getElementsByTagName(Tag.GROWINGTIPS.value());
        flower.setGrowingTips(getGrowingTips(growingTips));

        Node multiplying = qElement.getElementsByTagName(Tag.MULTIPLYING.value()).item(0);
        flower.setMultiplying(multiplying.getTextContent());

        return flower;
    }

    /**
     * Extracts answer object from the answer XML node.
     *
     * @param vpNode Answer node.
     * @return Answer object.
     */

    private VisualParameters getVisualParameters(NodeList vpNode) {
        VisualParameters visualParameters = new VisualParameters();
        Element aElement = (Element) vpNode.item(0);

        visualParameters.setStemColor(aElement.getAttribute(Tag.STEMCOLOR.value()));
        visualParameters.setLeafColor(aElement.getAttribute(Tag.LEAFCOLOR.value()));
        visualParameters.setAverageSize(aElement.getAttribute(Tag.AVERAGESIZE.value()));
        return visualParameters;
    }

    private GrowingTips getGrowingTips(NodeList gtNode) {
        GrowingTips growingTips = new GrowingTips();
        Element aElement = (Element) gtNode.item(0);

        growingTips.setTemperature(Integer.valueOf(aElement.getAttribute(Tag.TEMPERATURE.value())));
        growingTips.setLightning(Boolean.valueOf(aElement.getAttribute(Tag.LIGHTNING.value())));
        growingTips.setWatering(Integer.valueOf(aElement.getAttribute(Tag.WATERING.value())));
        return growingTips;
    }
}