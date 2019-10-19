
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: qiaolongjin
 * @date: 2019/8/2
 * @desc:
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(value = "com.qiao.nacos")
public class SpringCloudConfigProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigProducerApplication.class, args);
    }
}