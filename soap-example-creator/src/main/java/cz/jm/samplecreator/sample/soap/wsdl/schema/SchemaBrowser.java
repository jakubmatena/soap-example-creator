package cz.jm.samplecreator.sample.soap.wsdl.schema;

import java.util.List;
import java.util.Map;

import javax.wsdl.extensions.ElementExtensible;

public class SchemaBrowser {
	Map<String, Schema> schemas;

	public SchemaBrowser(List<ElementExtensible> extElements) {
		for (Object e : extElements) {
			if (e instanceof Schema) {
				javax.wsdl.extensions.schema.Schema wsdlSchema = (javax.wsdl.extensions.schema.Schema) e;

				Schema schema = new Schema();
			}
		}
	}
}
