package jp.ac.morijyobi.kadai2_7.mapper;

import jp.ac.morijyobi.kadai2_7.bean.dto.LoginUserDto;
import jp.ac.morijyobi.kadai2_7.bean.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersMapper {
    @Select("SELECT u.id, u.username, u.password, u.name, a.authority " +
            "FROM users AS u " +
            "INNER JOIN authorities AS a ON a.id = u.authority_id " +
            "WHERE u.username = #{username}")
    LoginUserDto selectUserByUsername(String username);

    @Insert("INSERT INTO users VALUES (0, #{username}, #{password}, #{name}, #{authorityId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(User user);
}
