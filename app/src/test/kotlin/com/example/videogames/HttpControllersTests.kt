package com.example.videogames

//import org.springframework.restdocs.RestDocumentationExtension
//import org.springframework.restdocs.RestDocumentationContextProvider
//import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
//import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration
//import org.springframework.test.context.junit.jupiter.SpringExtension
//import org.junit.jupiter.api.extension.ExtendWith
//import org.junit.jupiter.api.BeforeEach
//import org.springframework.test.web.servlet.setup.MockMvcBuilders
//import org.springframework.web.context.WebApplicationContext


/**
 * @see: https://www.baeldung.com/kotlin/spring-boot-testing
 * @see: https://github.com/spring-projects/spring-restdocs/blob/main/docs/src/docs/asciidoc/getting-started.adoc#setting-up-your-junit-5-tests
 */
/*
@WebMvcTest
//@ExtendWith(RestDocumentationExtension::class)
//@ExtendWith(SpringExtension::class)
@ActiveProfiles("unit-testing")
class HttpControllersTests(@Autowired val mockMvc: MockMvc) {

	@MockkBean
	lateinit var userRepository: UserRepository

	@MockkBean
	lateinit var articleRepository: ArticleRepository/

//	private var docMockMvc: MockMvc? = null

	*/
/**
	 * Should generate asciidoc snippets when running tests. Currently not working.
	 * https://github.com/eugenp/tutorials/blob/master/spring-5/src/test/java/com/baeldung/restdocs/ApiDocumentationJUnit5IntegrationTest.java
	 *//*

//	@BeforeEach
//	fun setUp(webApplicationContext: WebApplicationContext?, restDocumentation: RestDocumentationContextProvider?) {
//		docMockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext!!)
//			.apply(documentationConfiguration(restDocumentation))
//			.alwaysDo(document("{method-name}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))
//			.build()
//	}

	@Test
	fun `List articles`() {
		val johnDoe = User("johnDoe", "John", "Doe")
		val lorem5Article = Article("Lorem", "Lorem", "dolor sit amet", johnDoe)
		val ipsumArticle = Article("Ipsum", "Ipsum", "dolor sit amet", johnDoe)

		every { articleRepository.findAllByOrderByAddedAtDesc() } returns listOf(lorem5Article, ipsumArticle)

		mockMvc.perform(get("/api/article/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk)
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("\$.[0].author.login").value(johnDoe.login))
				.andExpect(jsonPath("\$.[0].slug").value(lorem5Article.slug))
				.andExpect(jsonPath("\$.[1].author.login").value(johnDoe.login))
				.andExpect(jsonPath("\$.[1].slug").value(ipsumArticle.slug))
	}

	@Test
	fun `List users`() {
		val johnDoe = User("johnDoe", "John", "Doe")
		val janeDoe = User("janeDoe", "Jane", "Doe")

		every { userRepository.findAll() } returns listOf(johnDoe, janeDoe)

		mockMvc.perform(get("/api/user/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk)
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("\$.[0].login").value(johnDoe.login))
				.andExpect(jsonPath("\$.[1].login").value(janeDoe.login))
	}
}
*/
