package com.example.electronic_kits_store.app.model.admin;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "admin_user")
@Getter // Дозволяємо читання всіх полів
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA вимагає конструктор без аргументів
@EqualsAndHashCode(of = "id") // КРИТИЧНО! Використовуємо лише ID для JPA-порівняння
public class AdminUser implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_seq")
    @SequenceGenerator(name = "admin_seq", sequenceName = "seq_admin_id", allocationSize = 1)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "tel_number")
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    @ToString.Exclude
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "admin_role", joinColumns = @JoinColumn(name = "admin_id"))
    @Column(name = "role_name")
    private List<Role> roles;

    public void updatePassword(String hashedPassword) {
        this.password = hashedPassword;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Захисне копіювання: повертаємо незмінну копію для безпеки
        return List.copyOf(roles);
    }
    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    // Статуси облікового запису
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}