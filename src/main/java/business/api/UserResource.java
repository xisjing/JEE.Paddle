package business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import business.api.exceptions.AlreadyExistUserFieldException;
import business.api.exceptions.InvalidUserFieldException;
import business.controllers.UserController;
import business.wrapper.UserWrapper;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.USERS)
public class UserResource {

    private UserController userController;

    @Autowired
    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void registration(@RequestBody UserWrapper userWrapper) throws InvalidUserFieldException, AlreadyExistUserFieldException {
        validateField(userWrapper.getUsername(), "username");
        validateField(userWrapper.getEmail(), "email");
        validateField(userWrapper.getPassword(), "password");
        if (!this.userController.registration(userWrapper)) {
            throw new AlreadyExistUserFieldException();
        }
    }

    private void validateField(String field, String msg) throws InvalidUserFieldException {
        if (field == null || field.isEmpty()) {
            throw new InvalidUserFieldException(msg);
        }
    }

}
