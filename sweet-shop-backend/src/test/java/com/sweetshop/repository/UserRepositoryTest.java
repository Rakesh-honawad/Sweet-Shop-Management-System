package com.sweetshop.repository;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Test
    void shouldFindUserByUsername() {
        User user = User.builder()
                .username("testuser")
                .email("test@example.com")
                .password("password")
                .role(Role.USER)
                .build();
        entityManager.persistAndFlush(user);
        
        Optional<User> found = userRepository.findByUsername("testuser");
        
        assertThat(found).isPresent();
        assertThat(found.get().getUsername()).isEqualTo("testuser");
    }
}