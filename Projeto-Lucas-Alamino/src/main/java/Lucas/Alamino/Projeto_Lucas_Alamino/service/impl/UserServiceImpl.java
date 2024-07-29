package Lucas.Alamino.Projeto_Lucas_Alamino.service.impl;

import Lucas.Alamino.Projeto_Lucas_Alamino.domain.model.User;
import Lucas.Alamino.Projeto_Lucas_Alamino.domain.repository.UserRepository;
import Lucas.Alamino.Projeto_Lucas_Alamino.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }




    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }


    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("Esse Numero de Conta ja existe no banco de dados.");
        }
        return userRepository.save(userToCreate);
    }
}
