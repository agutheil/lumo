package lumo;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreeterTest {

	@Test
	public void test() {
		Greeter greeter = new Greeter();
		assertEquals("Hello World", greeter.sayHello());
	}

}
