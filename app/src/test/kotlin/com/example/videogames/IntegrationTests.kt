package com.example.videogames

/**
 * @see: https://www.baeldung.com/kotlin/spring-boot-testing
 */
/*
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("unit-testing")
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {

	@BeforeAll
	fun setup() {
		println(">> Setup")
	}

	@Test
	fun `Assert videogames page title, content and status code`() {
		println(">> Assert videogames page title, content and status code")
		val entity = restTemplate.getForEntity<String>("/")
		assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
		assertThat(entity.body).contains("<h2>Blog Unit Testing</h2>", "Lorem")
	}

	@Test
	fun `Assert article page title, content and status code`() {
		println(">> Assert article page title, content and status code")
		val title = "Lorem"
		val entity = restTemplate.getForEntity<String>("/article/${title.toSlug()}")
		assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
		assertThat(entity.body).contains(title, "Lorem", "dolor sit amet")
	}

	@AfterAll
	fun teardown() {
		println(">> Tear down")
	}

}*/
