/*
* generated by Xtext
*/
package lu.uni.snt.repeat.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class REPEATAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("lu/uni/snt/repeat/parser/antlr/internal/InternalREPEAT.tokens");
	}
}
