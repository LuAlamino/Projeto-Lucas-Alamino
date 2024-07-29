package Lucas.Alamino.Projeto_Lucas_Alamino.domain.repository;


import Lucas.Alamino.Projeto_Lucas_Alamino.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String accountNumber);


}
