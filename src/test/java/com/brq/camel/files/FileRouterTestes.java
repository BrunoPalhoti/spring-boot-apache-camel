package com.brq.camel.files;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

public class FileRouterTestes extends CamelTestSupport {
	
private FileRouter fileRouter = null;
	
	protected FileRouter createRouteBuilder() throws Exception {
		
		if(fileRouter == null) {
			this.fileRouter = new FileRouter();
		}
		return this.fileRouter;
	}
	
	@Test
	public void checkIfFileExistsInOutputDirectory() throws Exception {
		
		FileRouter fileRouter = this.createRouteBuilder();
		
		File file = new File("files/output");
		assertTrue( file.isDirectory() ); // se é um diretorio
		assertTrue( file.listFiles().length > 0  ); // verifica se tem arquivos
	}
}
