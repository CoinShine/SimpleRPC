package registry;

/**
 * description: 常量
 * @author coin
 * @date 2019/06/05 23:10
 * @version 1.0
 */
public class Constant {

	public static final int ZK_SESSION_TIMEOUT = 5000;//zk超时时间

    public static final String ZK_REGISTRY_PATH = "/registry";//注册节点
    public static final String ZK_DATA_PATH = ZK_REGISTRY_PATH + "/data";//节点
}