package com.example.videogames

/**
 * @see: https://www.baeldung.com/kotlin/spring-boot-testing
 */
/*
@DataJpaTest
@ActiveProfiles("unit-testing")
class RepositoriesTests {

	@Autowired
	lateinit var entityManager: TestEntityManager
	@Autowired
	lateinit var userRepository: UserRepository
	@Autowired
	lateinit var articleRepository: ArticleRepository

	@Test
	fun `When findByIdOrNull then return Article`() {
		val johnDoe = User("johnDoe", "John", "Doe")
		entityManager.persist(johnDoe)
		val article = Article("Lorem", "Lorem", "dolor sit amet", johnDoe)

		entityManager.persist(article)
		entityManager.flush()

		val found = articleRepository.findByIdOrNull(article.id!!)
		assertThat(found).isEqualTo(article)
	}

	@Test
	fun `When findByLogin then return User`() {
		val johnDoe = User("johnDoe", "John", "Doe")

		entityManager.persist(johnDoe)
		entityManager.flush()

		val user = userRepository.findByLogin(johnDoe.login)
		assertThat(user).isEqualTo(johnDoe)
	}
}
*/
