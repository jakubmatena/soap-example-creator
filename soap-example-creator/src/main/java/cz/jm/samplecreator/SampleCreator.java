package cz.jm.samplecreator;

public interface SampleCreator<T> {
	T createSample(String sampleForWhat);
}
