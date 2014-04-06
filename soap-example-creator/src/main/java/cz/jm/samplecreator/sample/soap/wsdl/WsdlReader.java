package cz.jm.samplecreator.sample.soap.wsdl;

import java.net.URL;
import java.util.Collection;
import java.util.Iterator;

import javax.wsdl.Binding;
import javax.wsdl.BindingOperation;
import javax.wsdl.Definition;
import javax.wsdl.Operation;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;

import cz.jm.samplecreator.sample.soap.wsdl.schema.SchemaBrowser;

public class WsdlReader {

	private String wsdlUri;
	private Definition wsdlDef;

	/**
	 * 
	 * @param wsdlUri
	 * @throws WSDLException
	 */
	public WsdlReader(String wsdlUri) throws WSDLException {
		this.wsdlUri = wsdlUri;
		init();
	}

	/**
	 * 
	 * @param wsdlDef
	 * @param binding
	 * @param operation
	 * @return
	 */
	public QName getXsdOperationType(String binding, String operation) {
		Binding wsdlBinding = null;

		if (binding == null) {
			wsdlBinding = findBindingForOperation(operation);
		} else {
			wsdlBinding = (Binding) wsdlDef.getBindings().get(binding);
		}

		Operation wsdlOperation = wsdlBinding.getPortType().getOperation(operation, null, null);
		return wsdlOperation.getInput().getMessage().getPart("parameters").getElementName();
	}

	/**
	 * 
	 * @param operation
	 * @return
	 */
	private Binding findBindingForOperation(String operation) {
		Collection<Binding> bindings = wsdlDef.getBindings().values();
		for (Iterator iterator = bindings.iterator(); iterator.hasNext();) {
			Binding binding = (Binding) iterator.next();
			BindingOperation bOperation = binding.getBindingOperation(operation, null, null);
			if (bOperation != null) {
				return binding;
			}
		}

		throw new IllegalArgumentException("Wrong operation name was set.");
	}

	public SchemaBrowser getSchemaBrowser() {
		return new SchemaBrowser(wsdlDef.getTypes().getExtensibilityElements());
	}

	/**
	 * 
	 * @throws WSDLException
	 */
	private void init() throws WSDLException {
		WSDLReader reader = WSDLFactory.newInstance().newWSDLReader();
		URL url = getClass().getResource(wsdlUri);
		wsdlDef = reader.readWSDL(url.toString());
	}

	/**
	 * 
	 * @param wsdlUri
	 * @throws WSDLException
	 */
	public void setWsdlUri(String wsdlUri) throws WSDLException {
		this.wsdlUri = wsdlUri;
		init();
	}
}
