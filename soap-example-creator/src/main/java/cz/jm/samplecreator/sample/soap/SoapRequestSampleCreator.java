package cz.jm.samplecreator.sample.soap;

import cz.jm.samplecreator.SampleCreator;
import cz.jm.samplecreator.sample.soap.sample.SoapSample;
import cz.jm.samplecreator.sample.soap.wsdl.WsdlReader;
import cz.jm.samplecreator.sample.soap.wsdl.schema.SchemaBrowser;

/**
 * Main class for soap request sample creation.
 * 
 * @author jakubmatena
 * 
 */
public class SoapRequestSampleCreator implements SampleCreator<SoapSample> {
	private final WsdlReader wsdlReader;


	public SoapRequestSampleCreator(WsdlReader wsdlReader) {
		this.wsdlReader = wsdlReader;
	}

	/**
	 * @param sampleForWhat
	 *            In this context is a name of method.
	 * @return Returns soap request sample for defined method.
	 */
	@Override
	public SoapSample createSample(String sampleForWhat) {
		SoapSample sample = new SoapSample();

		// QName operationType = wsdlReader.getXsdOperationType(null, null);

		SchemaBrowser schemaBrowser = wsdlReader.getSchemaBrowser();

		return sample;
	}

}
