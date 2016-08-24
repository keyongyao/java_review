package com.example.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Administrator on 2016/8/13.
 */
public class PersonHandler extends DefaultHandler {
    public PersonHandler() {
        super();

    }

    @Override
    public void endDocument() throws SAXException {
        //   super.endDocument();
        System.out.println("结束处理文档XML");
    }

    @Override
    public void startDocument() throws SAXException {
        //   super.startDocument();
        System.out.println("开始处理文档XML");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //  super.startElement(uri, localName, qName, attributes);
        System.out.println(uri + " " + localName + " " + qName + " " + attributes.toString());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // super.endElement(uri, localName, qName);
        System.out.println(uri + " " + localName + " " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //   super.characters(ch, start, length);
        // System.out.println(new String(ch)+"  "+start+" "+length);
    }
}
