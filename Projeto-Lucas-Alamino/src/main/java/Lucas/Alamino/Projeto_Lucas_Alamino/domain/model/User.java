package Lucas.Alamino.Projeto_Lucas_Alamino.domain.model;


import jakarta.persistence.*;

import java.util.List;
// Entity ( name = "NOME DA TABELA QUE VAI CRIAR")
@Entity(name = "TB_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Poderia colocar Column para cassos de limitar o tamanho exemplo
    //@Colum(length = 10) o limite maximo é de 10 caracteres
    private String name;

    // Cascade vai auxiliar em caso de excluir o usuario a conta dele sera excluida junto
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Feature> feature;


    //Vai trazer todas as features da pessoa com o fetch = Fetch
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Feature> getFeature() {
        return feature;
    }

    public void setFeature(List<Feature> feature) {
        this.feature = feature;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}