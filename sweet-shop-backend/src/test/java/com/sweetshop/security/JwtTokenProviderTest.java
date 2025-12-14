package com.sweetshop.security;

class JwtTokenProviderTest {
    
    private JwtTokenProvider tokenProvider;
    
    @BeforeEach
    void setUp() {
        tokenProvider = new JwtTokenProvider();
        ReflectionTestUtils.setField(tokenProvider, "jwtSecret", "testSecret");
        ReflectionTestUtils.setField(tokenProvider, "jwtExpiration", 86400000L);
    }
    
    @Test
    void shouldGenerateToken() {
        UserDetails userDetails = User.withUsername("test").password("pass").roles("USER").build();
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null);
        
        String token = tokenProvider.generateToken(auth);
        
        assertThat(token).isNotNull();
    }
}