package jp.ac.morijyobi.kadai2_7.service;

import jp.ac.morijyobi.kadai2_7.bean.entity.User;
import jp.ac.morijyobi.kadai2_7.bean.form.UserForm;

public interface UserService {
    User registerUser(UserForm userForm);
}
