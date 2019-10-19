import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.Serializable;

/**
 * @author: qiaolongjin
 * @date: 2019/8/2
 * @desc:
 */
//@SpringBootApplication
@SpringCloudApplication
@ComponentScan(value = "com.qiao.nacos")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}