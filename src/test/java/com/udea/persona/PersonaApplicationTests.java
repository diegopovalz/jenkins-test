package com.udea.persona;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void shouldBeOne() {
		Integer one = 1;
		assertEquals(1, one);
	}

}
