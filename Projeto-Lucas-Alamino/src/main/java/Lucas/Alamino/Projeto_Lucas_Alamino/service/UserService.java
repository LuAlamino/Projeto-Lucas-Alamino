package Lucas.Alamino.Projeto_Lucas_Alamino.service;

import Lucas.Alamino.Projeto_Lucas_Alamino.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
