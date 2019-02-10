package parctice;

import org.apache.log4j.Logger;

public class Test {

	private static Logger log = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++ ) {
			log.debug("hello world " + i);
		}
	}

}
