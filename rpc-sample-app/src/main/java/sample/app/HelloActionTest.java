package sample.app;

import client.RpcProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sample.client.HelloService;
import sample.client.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class HelloActionTest {

	@Autowired
	private RpcProxy rpcProxy;
	
	@Test
	public void helloTest1() {
		// 调用代理的create方法，代理HelloService接口
		HelloService helloService = rpcProxy.create(HelloService.class);
		
		// 调用代理的方法，执行invoke
		String result = helloService.hello("World");
		System.out.println("服务端返回结果：");
		System.out.println(result);
	}

	@Test
	public void helloTest2() {
		HelloService helloService = rpcProxy.create(HelloService.class);
		String result = helloService.hello(new Person("Xiao", "Tao"));
		System.out.println("服务端返回结果：");
		System.out.println(result);
	}
}
