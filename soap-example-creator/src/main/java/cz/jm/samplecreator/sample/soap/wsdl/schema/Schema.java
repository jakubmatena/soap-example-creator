package cz.jm.samplecreator.sample.soap.wsdl.schema;

import java.util.List;

public class Schema {
	private String namespace;
	private List<String> imports;
	private javax.wsdl.extensions.schema.Schema schema;

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public List<String> getImports() {
		return imports;
	}

	public void setImports(List<String> imports) {
		this.imports = imports;
	}

	public javax.wsdl.extensions.schema.Schema getSchema() {
		return schema;
	}

	public void setSchema(javax.wsdl.extensions.schema.Schema schema) {
		this.schema = schema;
	}
}
