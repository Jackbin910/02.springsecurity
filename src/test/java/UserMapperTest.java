import com.yangbin1.domain.Permission;
import com.yangbin1.domain.User;
import com.yangbin1.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindByUsername(){
        User user = userMapper.findByUsername("jack");
        System.out.println(user);
    }

    @Test
    public void testFindPermissionByUsername() {
        List<Permission> permissions = userMapper.findPermissionByUsername("jack");
        for (Permission permission : permissions) {
            System.out.println(permission.getPermName() + "-" + permission.getPermTag());
        }
    }
}
