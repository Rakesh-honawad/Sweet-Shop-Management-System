package com.sweetshop.service;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {
    
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private AuthService authService;
    
    @Test
    void shouldRegisterNewUser() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("newuser");
        request.setEmail("new@test.com");
        request.setPassword("password123");
        
        when(userRepository.existsByUsername(anyString())).thenReturn(false);
        when(userRepository.existsByEmail(anyString())).thenReturn(false);
        when(passwordEncoder.encode(anyString())).thenReturn("encoded");
        when(userRepository.save(any())).thenReturn(User.builder().id(1L).username("newuser").build());
        
        AuthResponse response = authService.register(request);
        
        assertThat(response).isNotNull();
        verify(userRepository).save(any(User.class));
    }
}