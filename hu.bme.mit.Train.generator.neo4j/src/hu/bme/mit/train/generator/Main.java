package hu.bme.mit.train.generator;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		GeneratorConfig generatorConfig = new GeneratorConfig();
		generatorConfig.processParameters(args);
		IGenerator generator = null;
		if (generatorConfig.getSyntax().equals("EMF")) {
			generator = new Generator_EMF();
		}else if (generatorConfig.getSyntax().equals("SQL")) {
			generator = new Generator_SQL();
		}else if (generatorConfig.getSyntax().equals("Neo4j")) {
			generator = new Generator_Neo4j();
		}
		
		for(int size : generatorConfig.sizes) {
			generatorConfig.setSize(size);
			generatorConfig.processParameters(args); // to refresh size dependent values
			generator.testFillUpFile(generatorConfig);
		}
	}

}
