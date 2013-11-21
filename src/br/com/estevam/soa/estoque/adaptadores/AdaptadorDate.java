package br.com.estevam.soa.estoque.adaptadores;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class AdaptadorDate extends XmlAdapter<XMLGregorianCalendar, Date> {

	@Override
	public Date unmarshal(XMLGregorianCalendar date) throws Exception {
		return date.toGregorianCalendar().getTime();
	}

	@Override
	public XMLGregorianCalendar marshal(Date date) throws Exception {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		XMLGregorianCalendar xmlGregoriamCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
		xmlGregoriamCalendar.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);
		xmlGregoriamCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
		return xmlGregoriamCalendar;
	}
}
