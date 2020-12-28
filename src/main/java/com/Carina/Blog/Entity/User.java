package com.Carina.Blog.Entity;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    @Column(unique = true, nullable = false)
    @Email(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private String email;

    @NotBlank
    @Size(min = 8, max = 20)
    @Value("${db.password}")
    private String password;

    private LocalDate singUpDate = LocalDate.now();
    private String country;
    private String state;
    private String city;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value="postReference")
    private List <Post> posts = new ArrayList<>();

    @OneToMany(mappedBy="user_comments", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value="commentUser")
    private List <Comment> comments = new ArrayList<>();

    public User(Long id) { //constructor
        this.id = id;
    }

    public User() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public LocalDate getSingUpDate() { return singUpDate; }

    public void setSingUpDate(LocalDate singUpDate) { this.singUpDate = singUpDate; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public List<Post> getPosts() { return posts; }

    public void setPosts(List<Post> posts) { this.posts = posts; }

    public List<Comment> getComments() { return comments; }

    public void setComments(List<Comment> comments) { this.comments = comments; }
}
